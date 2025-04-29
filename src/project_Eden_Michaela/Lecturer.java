package project_Eden_Michaela;

import java.util.Arrays;

public class Lecturer {
    private String name;
    private String id;
    private DegreeType degree;
    private String degreeName;
    private double salary;
    private Committee[] committees;
    private int numOfCommittees;
    private StudyDepartment studyDepartment;

    public Lecturer(String name, String id, DegreeType degree, String degreeName, double salary) {
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

    public DegreeType getDegree() {
        return degree;
    }

    public double getSalary() {
        return salary;
    }

    public void changeDep(StudyDepartment studyDepartment) {

    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", degree=" + degree +
                ", degreeName='" + degreeName + '\'' +
                ", salary=" + salary +
                ", committees=" + Arrays.toString(committees) +
                ", studyDepartment=" + studyDepartment +
                '}';
    }

}
