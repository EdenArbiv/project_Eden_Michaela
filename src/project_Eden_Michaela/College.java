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

    private Lecturer findLecturerByName(String name){
        for (Lecturer lecturer: lecturers){
            if(lecturer.getName().equals(name)){
                return lecturer;
            }
        }
        return null;
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


    public double getAverageSalaryCommittee() {
        return 0;
    }

    public double getAverageSalary() {
        double res = 0.0;
        double average = 0.0;
        for (int i = 0; i < numOfLecturers; i++) {
            res += lecturers[i].getSalary();
        }
        average = res/numOfLecturers;
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

    private StudyDepartment findDepartmentByName(String name){
        for (StudyDepartment department: studyDepartments){
            if(department.getName().equals(name)){
                return department;
            }
        }
        return null;
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
        lecturer.changeDep(studyDepartment);
        return Status.SUCCESS;
    }
}
