package project_Eden_Michaela;

public class StudyDepartment {
    private String name;
    private int numOfStudents;
    private Lecturer[] lecturers;
    public StudyDepartment(String name, int numOfStudents){
        this.name = name;
        this.numOfStudents = numOfStudents;
        lecturers = new Lecturer[0];
    }

    public String getName() {
        return name;
    }

}
