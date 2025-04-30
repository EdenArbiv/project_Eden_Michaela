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
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return "Committee{" +
                "name='" + name + '\'' +
                ", lecturers=" + Arrays.toString(lecturers) +
                ", committeeChairman=" + committeeChairman +
                '}';
    }

}
