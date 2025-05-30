package project_Eden_Michaela;


public class Lecturer implements Cloneable{
    private String name;
    private String id;
    private DegreeType degree;
    private String degreeName;
    private double salary;
    private Committee[] committees;
    private int numOfCommittees;
    private StudyDepartment studyDepartment;

    public Lecturer(String name, String id, DegreeType degree, String degreeName, double salary) throws CollegeException {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.degreeName = degreeName;
        setSalary(salary);
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
        if (numOfCommittees == committees.length){
            committees = (Committee[]) Utils.resizeArr(committees);
        }
        committees[numOfCommittees++] = committee;
    }


    public void removeCommittee(Committee committee) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committees[i].getName().equals(committee.getName())) {
                // מזיז את כל שאר הקומיטאות שמאלה
                for (int j = i; j < numOfCommittees - 1; j++) {
                    committees[j] = committees[j + 1];
                }
                // ניקוי התא האחרון
                committees[numOfCommittees - 1] = null;
                numOfCommittees--;
            }
        }
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
        for (int i = 0; i < numOfCommittees; i++) {
            sb.append(committees[i].getName());
            if (i < numOfCommittees - 1) sb.append(", ");
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
