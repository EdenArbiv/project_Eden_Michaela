package project_Eden_Michaela;


import java.util.ArrayList;

public class Lecturer implements Cloneable{
    private String name;
    private String id;
    private DegreeType degree;
    private String degreeName;
    private double salary;
    ArrayList<Committee> committees;
    private StudyDepartment studyDepartment;

    public Lecturer(String name, String id, DegreeType degree, String degreeName, double salary) throws CollegeException {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.degreeName = degreeName;
        setSalary(salary);
        committees = new ArrayList<>();
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

    public void setStudyDepartment(StudyDepartment studyDepartment) {
        this.studyDepartment = studyDepartment;
    }

    public void setSalary(double salary) throws CollegeException {
        if (salary < 0) {
            throw new CollegeException("salary must be positive");
        }
        this.salary = salary;
    }

    public void addCommittee(Committee committee) {
        committees.add(committee);
    }


    public void removeCommittee(Committee committee) {
        committees.remove(committee);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lecturer{");
        sb.append("name=").append(name);
        sb.append(", id=").append(id);
        sb.append(", degree=").append(degree);
        sb.append(", degreeName=").append(degreeName);
        sb.append(", salary=").append(salary);
        sb.append(", committees=[");
        for (int i = 0; i < committees.size(); i++) {
            sb.append(committees.get(i).getName());
            if (i < committees.size() - 1) sb.append(", ");
        }
        sb.append("], studyDepartment=").append(studyDepartment);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Lecturer lecturer) {
            return name.equals(lecturer.name);
        }
        return false;
    }

    @Override
    protected Lecturer clone() throws CloneNotSupportedException {
        return (Lecturer) super.clone();
    }
}
