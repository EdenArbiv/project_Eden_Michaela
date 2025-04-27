package project_Eden_Michaela;


public class College {
    private final String collegeName;
    private Lecturer[] lecturers;
    private int numOfLecturers;
    private StudyDepartment[] StudyDepartments;
    private int numOfStudyDepartment;
    private Committee[] committees;
    private int numOfCommittee;

    public College(String collegeName){
        this.collegeName = collegeName;
        lecturers = new Lecturer[0];
        StudyDepartments = new StudyDepartment[0];
        committees = new Committee[0];
    }


    public Status addLecturer(String name, String id, DegreeType degreeType, String degreeName, int salary) {
        if(Utils.isExist(lecturers,numOfLecturers,name)){
            return Status.ALREADY_EXIST;
        }
        if (numOfLecturers == lecturers.length) {
            lecturers = (Lecturer[]) Utils.resizeArr(lecturers);
        }
        lecturers[numOfLecturers++] = new Lecturer(name, id, degreeType, degreeName, salary);
        return Status.SUCCESS;
    }
}
