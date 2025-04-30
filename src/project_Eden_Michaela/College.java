package project_Eden_Michaela;


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


    public Status addLecturer(String name, String id, DegreeType degreeType, String degreeName, double salary) {
        if(Utils.isExist(lecturers,numOfLecturers,name)){
            return Status.LECTURER_EXIST;
        }
        if (numOfLecturers == lecturers.length) {
            lecturers = (Lecturer[]) Utils.resizeArr(lecturers);
        }
        lecturers[numOfLecturers++] = new Lecturer(name, id, degreeType, degreeName, salary);
        return Status.SUCCESS;
    }


    public Status addCommittee(String name, String committeeChairman) {
        if(Utils.isExist(committees, numOfCommittee, name)){
            return Status.COMMITTEE_EXIST;
        }
        if(!Utils.isExist(lecturers,numOfLecturers, committeeChairman)){
            return Status.CHAIRMAN_NOT_EXIST;
        }
        Lecturer chairmanLecturer = findLecturerByName(committeeChairman);
        if(chairmanLecturer != null){
            if(chairmanLecturer.getDegree() != DegreeType.DOCTOR && chairmanLecturer.getDegree() != DegreeType.PROFESSOR ){
                return Status.AT_LEAST_DOCTOR;
            }
            if (numOfCommittee == committees.length) {
                committees = (Committee[]) Utils.resizeArr(committees);
            }
            committees[numOfCommittee++] = new Committee(name, chairmanLecturer);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }

    public StringBuilder getLecturers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i].toString()).append("\n");
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


    public double getAverageSalaryCommittee(StudyDepartment findDep) {
        return findDep.getAverage();
    }

    public double getAverageSalary() {
        double res = 0.0;
        double average;
        for (int i = 0; i < numOfLecturers; i++) {
            res += lecturers[i].getSalary();
        }
        average = Math.round(res/numOfLecturers* 100.0) / 100.0; // מעגל ל-2 ספרות אחרי הנקודה
        return average;
    }

    public Status addStudyDepartment(String name, int numOfStudents) {
        if(Utils.isExist(studyDepartments, numOfStudyDepartment, name)){
            return Status.DEPARTMENT_EXIST;
        }
        if (numOfStudyDepartment == studyDepartments.length) {
            studyDepartments = (StudyDepartment[]) Utils.resizeArr(studyDepartments);
        }
        studyDepartments[numOfStudyDepartment++] = new StudyDepartment(name, numOfStudents);
        return Status.SUCCESS;
    }


    public Status addLecturerToDep(String name, String department) {
        Lecturer lecturer = findLecturerByName(name);
        StudyDepartment studyDepartment = findDepartmentByName(department);
        if(studyDepartment == null) {
            return Status.DEPARTMENT_NOT_EXIST;
        }
        if(lecturer == null){
            return Status.LECTURER_NOT_EXIST;
        }
        if(!studyDepartment.addLecturer(lecturer)){
            return Status.LECTURER_EXIST;
        }
        lecturer.setStudyDepartment(studyDepartment);
        return Status.SUCCESS;
    }

    public Status addLecturerCommittee(String lecName, String comName) {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            return Status.LECTURER_NOT_EXIST;
        }
        if(committee == null){
            return Status.COMMITTEE_NOT_EXIST;
        }
        if(committee.findLecturer(lecName)) {
            return Status.LECTURER_EX_COM;
        }
        if(committee.getCommitteeChairman().getName().equals(lecName)) {
            return Status.ALREADY_CHAIRMAN;
        }
        committee.addLecturer(lecturer);
        lecturer.addCommittee(committee);
        return Status.SUCCESS;
    }

    public Status removeLecturerFromCommittee(String lecName, String comName) {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            return Status.LECTURER_NOT_EXIST;
        }
        if(committee == null){
            return Status.COMMITTEE_NOT_EXIST;
        }
        if(!committee.findLecturer(lecName)) {
            return Status.LECTURER_NOT_EX_COM;
        }
        committee.removeLecturer(lecturer);
        lecturer.removeCommittee(committee);
        return Status.SUCCESS;
    }
}
