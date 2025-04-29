package project_Eden_Michaela;

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

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public double getAverage() {
        double res = 0.0;
        double average = 0.0;
        for (int i = 0; i < numOfLecturers; i++) {
            res += lecturers[i].getSalary();
        }
        average = res/numOfLecturers;
        return average;
    }

    @Override
    public String toString() {
        return name;
    }



}
