package project_Eden_Michaela;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class StudyDepartment implements Serializable {
    private String name;
    private int numOfStudents;
    ArrayList<Lecturer> lecturers;

    public StudyDepartment(String name, int numOfStudents){
        this.name = name;
        this.numOfStudents = numOfStudents;
        lecturers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addLecturer(Lecturer lecturer) {
        if(lecturers.contains(lecturer)){
            return false;
        }
        lecturers.add(lecturer);
        return true;
    }

    public double getAverage() {
        if (lecturers.isEmpty()) return 0.0;
        double res = 0.0;
        for (Lecturer lecturer : lecturers){
            res += lecturer.getSalary();
        }
        return Math.round((res / lecturers.size()) * 100.0) / 100.0;
    }

    public void removeLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StudyDepartment{name='").append(name).append("', lecturers=[");
        for (int i = 0; i < lecturers.size(); i++) {
            sb.append(lecturers.get(i).getName());
            if (i < lecturers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StudyDepartment studyDepartment) {
            return name.equals(studyDepartment.name);
        }
        return false;
    }
}
