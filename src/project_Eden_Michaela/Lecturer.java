package project_Eden_Michaela;

public class Lecturer {
    private String name;
    private String id;
    private DegreeType degree;
    private String degreeName;
    private int salary;
    private Committee[] committees;
    private int numOfCommittees;
    private StudyDepartment studyDepartment;

    public Lecturer(String name, String id, DegreeType degree, String degreeName, int salary) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.degreeName = degreeName;
        this.salary = salary;
        committees = new Committee[0];
    }

    public String getName() {
        return name;
    }
}
