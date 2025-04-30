package project_Eden_Michaela;

import java.util.Arrays;

public class Committee {
    private String name;
    private Lecturer[] lecturers;
    private int numOfLecturers;
    private Lecturer committeeChairman;

    public Committee(String name, Lecturer committeeChairman) {
        this.name = name;
        this.committeeChairman = committeeChairman;
        lecturers = new Lecturer[0];
    }

    public String getName() {
        return name;
    }

    public boolean findLecturer(String name) {
        if(Utils.isExist(lecturers,numOfLecturers, name)){
            return true;
        }
        return false;
    }

    public void addLecturer(Lecturer lecturer) {
        if (numOfLecturers == lecturers.length){
            lecturers = (Lecturer[]) Utils.resizeArr(lecturers);
        }
        lecturers[numOfLecturers++] = lecturer;
    }

    public Lecturer getCommitteeChairman() {
        return committeeChairman;
    }

    public void removeLecturer(Lecturer lecturer) {
        Lecturer[] newLecturers = new Lecturer[numOfLecturers - 1];
        for (int i = 0; i < numOfLecturers; i++) {
            if (!lecturers[i].getName().equals(lecturer.getName())){
                newLecturers[i] = lecturers[i];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee{name='").append(name).append("', chairman=").append(committeeChairman.getName()).append(", lecturers=[");
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i].getName());
            if (i < numOfLecturers - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }

}
