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

    public void setCommitteeChairman(Lecturer committeeChairman) {
        this.committeeChairman = committeeChairman;
    }

    public boolean findLecturer(String name) {
        return Utils.isExist(lecturers, numOfLecturers, name);
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
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i].getName().equals(lecturer.getName())) {
                // להזיז שמאלה
                for (int j = i; j < numOfLecturers - 1; j++) {
                    lecturers[j] = lecturers[j + 1];
                }
                // מחיקת המקום האחרון
                lecturers[numOfLecturers - 1] = null;
                numOfLecturers--;
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
