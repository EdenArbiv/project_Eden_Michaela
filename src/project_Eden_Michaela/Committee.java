package project_Eden_Michaela;

import java.util.ArrayList;

public class Committee implements Cloneable{
    private String name;
    ArrayList<Lecturer> lecturers;
    private DegreeType degreeType;
    private Lecturer committeeChairman;

    public Committee(String name, Lecturer committeeChairman, DegreeType degreeType) {
        this.name = name;
        this.committeeChairman = committeeChairman;
        this.degreeType = degreeType;
        lecturers = new ArrayList<>();
    }

    public DegreeType getDegreeType() {
        return degreeType;
    }

    public String getName() {
        return name;
    }

    public void setCommitteeChairman(Lecturer committeeChairman) {
        this.committeeChairman = committeeChairman;
    }


    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public Lecturer getCommitteeChairman() {
        return committeeChairman;
    }

    public int numOfArticles() {
        int sum = 0;
        for (Lecturer lecturer : lecturers) {
            if (lecturer instanceof Doctor lec) {
                sum += lec.articleArr.size();
            }
        }
        return sum;
    }

    public void removeLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee{name='").append(name).append("', chairman=").append(committeeChairman.getName()).append(", lecturers=[");
        for (int i = 0; i < lecturers.size(); i++) {
            sb.append(lecturers.get(i).getName());
            if (i < lecturers.size() - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Committee committee) {
            return name.equals(committee.name);
        }
        return false;
    }

    @Override
    protected Committee clone() throws CloneNotSupportedException {
        Committee cloned = (Committee) super.clone();
        cloned.name = "new " + name;
        cloned.lecturers = new ArrayList<>();
        for (Lecturer lec : lecturers) {
            cloned.lecturers.add(lec.clone());
        }
        cloned.committeeChairman = committeeChairman.clone();
        return cloned;
    }
}
