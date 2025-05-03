package project_Eden_Michaela;

import java.util.Arrays;

public class StudyDepartment {
    private String name;
    private int numOfStudents;
    private Lecturer[] lecturers;
    private int numOfLecturers;

    public StudyDepartment(String name, int numOfStudents){
        this.name = name;
        this.numOfStudents = numOfStudents;
        lecturers = new Lecturer[0];
    }

    public String getName() {
        return name;
    }

    public boolean addLecturer(Lecturer lecturer) {
        if(Utils.isExist(lecturers,numOfLecturers,lecturer.getName())){
            return false;
        }
        if (numOfLecturers == lecturers.length){
            lecturers = (Lecturer[]) Utils.resizeArr(lecturers);
        }
        lecturers[numOfLecturers++] = lecturer;
        return true;
    }

    public double getAverage() {
        if (numOfLecturers == 0) return 0.0;
        double res = 0.0;
        for (int i = 0; i < numOfLecturers; i++) {
            res += lecturers[i].getSalary();
        }
        return Math.round((res / numOfLecturers) * 100.0) / 100.0;
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
        sb.append("StudyDepartment{name='").append(name).append("', lecturers=[");
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i].getName());
            if (i < numOfLecturers - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
