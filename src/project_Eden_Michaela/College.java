package project_Eden_Michaela;


import static project_Eden_Michaela.Status.*;

public class College {
    private final String collegeName;
    private Lecturer[] lecturers;
    private int numOfLecturers;
    private StudyDepartment[] studyDepartments;
    private int numOfStudyDepartment;
    private Committee[] committees;
    private int numOfCommittee;

    public College(String collegeName){
        this.collegeName = collegeName;
        lecturers = new Lecturer[0];
        studyDepartments = new StudyDepartment[0];
        committees = new Committee[0];

    }

    public StudyDepartment findDepartmentByName(String name){
        for (int i = 0; i < numOfStudyDepartment; i++) {
            if(studyDepartments[i].getName().equals(name)){
                return studyDepartments[i];
            }
        }
        return null;
    }

    public Lecturer findLecturerByName(String name){
        for (int i = 0; i < numOfLecturers ; i++) {
            if(lecturers[i].getName().equals(name)){
                return lecturers[i];
            }
        }
        return null;
    }

    public Committee findCommitteeByName(String name){
        for (int i = 0; i < numOfCommittee ; i++) {
            if(committees[i].getName().equals(name)){
                return committees[i];
            }
        }
        return null;
    }


    public void addLecturer(String name, String id, DegreeType degreeType, String degreeName, double salary) throws CollegeException {
        addLecturer(new Lecturer(name, id, degreeType, degreeName, salary));
    }

    public void addLecturer(String name, String id, DegreeType degreeType, String degreeName, double salary, String[] articlesArr, int numOfArticles) throws CollegeException {
        addLecturer(new Doctor(name, id, degreeType, degreeName, salary, articlesArr, numOfArticles));
    }

    public void addLecturer(String name, String id, DegreeType degreeType, String degreeName, double salary, String[] articlesArr,int numOfArticles, String institution) throws CollegeException {
        addLecturer(new Professor(name, id, degreeType, degreeName, salary, articlesArr, numOfArticles, institution));
    }


    public void addLecturer(Lecturer lecturer) throws CollegeException {
        if (Utils.isExist(lecturers, numOfLecturers, lecturer)){
            throw new CollegeException(LECTURER_EXIST.toString());
        }
        if (numOfLecturers == lecturers.length) {
            lecturers = (Lecturer[]) Utils.resizeArr(lecturers);
        }
        lecturers[numOfLecturers++] = lecturer;
    }



    public void addCommittee(String name, String committeeChairman, DegreeType degreeType) throws CollegeException {
        Lecturer chairmanLecturer = findLecturerByName(committeeChairman);
        if (chairmanLecturer != null){
            addCommittee(new Committee(name, chairmanLecturer, degreeType));
        }else{
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }

    }

    public void addCommittee(Committee committee) throws CollegeException {
        if(Utils.isExist(committees, numOfCommittee, committee)){
            throw new CollegeException(COMMITTEE_EXIST.toString());
        }
        if(!(committee.getCommitteeChairman() instanceof Doctor)){
            throw new CollegeException(AT_LEAST_DOCTOR.toString());
        }
        if (numOfCommittee == committees.length) {
            committees = (Committee[]) Utils.resizeArr(committees);
        }
        committees[numOfCommittee++] = committee;

    }



    public StringBuilder getLecturers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i].toString());

            if (i < numOfLecturers - 1) {
                sb.append(System.lineSeparator());
            }
        }
        sb.append("]");
        return sb;
    }

    public StringBuilder getCommittees() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfCommittee; i++) {
            sb.append(committees[i].toString()).append("\n");
        }
        sb.append("]");
        return sb;
    }
    public StringBuilder getDepartments() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfStudyDepartment; i++) {
            sb.append(studyDepartments[i].toString()).append("\n");
        }
        sb.append("]");
        return sb;
    }


    public double getAverageSalaryCommittee(StudyDepartment findDep) {
        return findDep.getAverage();
    }

    public double getAverageSalary() {
        if (numOfLecturers == 0) return 0.0;
        double res = 0.0;
        double average;
        for (int i = 0; i < numOfLecturers; i++) {
            res += lecturers[i].getSalary();
        }
        average = Math.round(res/numOfLecturers* 100.0) / 100.0; // מעגל ל2 ספרות אחרי הנקודה
        return average;
    }

    public void addStudyDepartment(String name, int numOfStudents) throws CollegeException {
        addStudyDepartment(new StudyDepartment(name, numOfStudents));
    }

    public void addStudyDepartment(StudyDepartment studyDepartment) throws CollegeException {
        if(Utils.isExist(studyDepartments, numOfStudyDepartment, studyDepartment)){
            throw new CollegeException(DEPARTMENT_EXIST.toString());
        }
        if (numOfStudyDepartment == studyDepartments.length) {
            studyDepartments = (StudyDepartment[]) Utils.resizeArr(studyDepartments);
        }
        studyDepartments[numOfStudyDepartment++] = studyDepartment;
    }


    public void addLecturerToDep(String name, String department) throws CollegeException {
        Lecturer lecturer = findLecturerByName(name);
        StudyDepartment studyDepartment = findDepartmentByName(department);
        if(studyDepartment == null) {
            throw new CollegeException(DEPARTMENT_NOT_EXIST.toString());
        }
        if(lecturer == null){
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(!studyDepartment.addLecturer(lecturer)){
            throw new CollegeException(LECTURER_EXIST.toString());
        }
        for (int i = 0; i < numOfStudyDepartment; i++) {
            StudyDepartment currentDep = studyDepartments[i];
            if (!currentDep.getName().equals(studyDepartment.getName())) {
                currentDep.removeLecturer(lecturer);
            }
        }
        lecturer.setStudyDepartment(studyDepartment);
    }

    public void addLecturerCommittee(String lecName, String comName) throws CollegeException {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(committee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        if(committee.getDegreeType() != lecturer.getDegree()) {
            throw new CollegeException(COMMITTEE_DEGREETYPE.toString());
        }
        if(committee.findLecturer(lecName)) {
            throw new CollegeException(LECTURER_EX_COM.toString());
        }
        if(committee.getCommitteeChairman().getName().equals(lecName)) {
            throw new CollegeException(ALREADY_CHAIRMAN.toString());
        }
        committee.addLecturer(lecturer);
        lecturer.addCommittee(committee);
    }

    public void removeLecturerFromCommittee(String lecName, String comName) throws CollegeException {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(committee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        if(!committee.findLecturer(lecName)) {
            throw new CollegeException(LECTURER_NOT_EX_COM.toString());
        }
        committee.removeLecturer(lecturer);
        lecturer.removeCommittee(committee);
    }

    public void editCommitteeChairMan(String lecName, String comName) throws CollegeException {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(committee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        if(lecturer.getDegree() != DegreeType.DOCTOR && lecturer.getDegree() != DegreeType.PROFESSOR ){
            throw new CollegeException(AT_LEAST_DOCTOR.toString());
        }
        if(committee.getCommitteeChairman().getName().equals(lecName)) {
            throw new CollegeException(ALREADY_CHAIRMAN.toString());
        }
        committee.setCommitteeChairman(lecturer);
        if(committee.findLecturer(lecName)) {
            committee.removeLecturer(lecturer);
            lecturer.removeCommittee(committee);
        }
    }

    public void compareDoctorProfessorArticles(String lecturer1, String lecturer2) throws CollegeException {
        Lecturer firstlecturer = findLecturerByName(lecturer1);
        Lecturer secondLecturer = findLecturerByName(lecturer2);
        if (firstlecturer == null || secondLecturer == null){
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if (firstlecturer instanceof Doctor lecturer_1 && secondLecturer instanceof Doctor lecturer_2){
            lecturer_1.compareTo(lecturer_2);
        }else{
            throw new CollegeException(AT_LEAST_DOCTOR.toString());
        }

    }

    public void compareCommittees(String committee1, String committee2) throws CollegeException {
        Committee firstCommittee = findCommitteeByName(committee1);
        Committee secondCommittee = findCommitteeByName(committee2);
        if (firstCommittee == null || secondCommittee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        CompareComByArticles comp1 = new CompareComByArticles();
        CompareComByLecturers comp2 = new CompareComByLecturers();
        comp1.compare(firstCommittee, secondCommittee);
        comp2.compare(firstCommittee, secondCommittee);
    }

    public void duplicateCommittee(String committee) throws CollegeException, CloneNotSupportedException {
        Committee committeeToDup = findCommitteeByName(committee);
        if (committeeToDup == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        committeeToDup.clone();
    }
}
