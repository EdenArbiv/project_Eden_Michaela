package project_Eden_Michaela;

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
}
