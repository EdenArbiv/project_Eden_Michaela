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

    public void setStudyDepartment(StudyDepartment studyDepartment) {
        this.studyDepartment = studyDepartment;
    }

    public void addCommittee(Committee committee) {
        if (numOfCommittees == committees.length){
            committees = (Committee[]) Utils.resizeArr(committees);
        }
        committees[numOfCommittees++] = committee;
    }

    public void removeCommittee(Committee committee) {
        Committee[] newCommittee = new Committee[numOfCommittees - 1];
        int newIndex = 0;
        for (int i = 0; i < numOfCommittees; i++) {
            if (!committees[i].getName().equals(committee.getName())) {
                newCommittee[newIndex++] = committees[i];
            }
        }
        committees = newCommittee;
        numOfCommittees--;
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

}
