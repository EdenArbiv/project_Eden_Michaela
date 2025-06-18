package project_Eden_Michaela;


import java.io.Serializable;
import java.util.ArrayList;

import static project_Eden_Michaela.Status.*;

public class College implements Serializable {
    private final String collegeName;
    ArrayList<Lecturer> lecturers;
    ArrayList<StudyDepartment> studyDepartments;
    ArrayList<Committee> committees;

    public College(String collegeName){
        this.collegeName = collegeName;
        lecturers = new ArrayList<>();
        studyDepartments = new ArrayList<>();
        committees = new ArrayList<>();
    }

    public StudyDepartment findDepartmentByName(String name){
        for (StudyDepartment studyDepartment : studyDepartments) {
            if(studyDepartment.getName().equals(name)){
                return studyDepartment;
            }
        }
        return null;
    }

    public Lecturer findLecturerByName(String name){
        for (Lecturer lecturer : lecturers) {
            if(lecturer.getName().equals(name)){
                return lecturer;
            }
        }
        return null;
    }

    public Committee findCommitteeByName(String name){
        for (Committee committee : committees) {
            if(committee.getName().equals(name)){
                return committee;
            }
        }
        return null;
    }


    public void addLecturer(String name, String id, DegreeType degreeType, String degreeName, double salary) throws CollegeException {
        addLecturer(new Lecturer(name, id, degreeType, degreeName, salary));
    }

    public void addLecturer(String name, String id, DegreeType degreeType, String degreeName, double salary, ArrayList<String> articlesArr) throws CollegeException {
        addLecturer(new Doctor(name, id, degreeType, degreeName, salary, articlesArr));
    }

    public void addLecturer(String name, String id, DegreeType degreeType, String degreeName, double salary, ArrayList<String> articlesArr, String institution) throws CollegeException {
        addLecturer(new Professor(name, id, degreeType, degreeName, salary, articlesArr, institution));
    }


    public void addLecturer(Lecturer lecturer) throws CollegeException {
        if (lecturers.contains(lecturer)){
            throw new CollegeException(LECTURER_EXIST.toString());
        }
        lecturers.add(lecturer);
    }



    public void addCommittee(String name, String committeeChairman, DegreeType degreeType) throws CollegeException {
        Lecturer chairmanLecturer = findLecturerByName(committeeChairman);
        if (chairmanLecturer != null){
            addCommittee(new Committee(name, chairmanLecturer, degreeType));
        }else{
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }

    }

    public void addCommittee(Committee committee) throws CollegeException {
        if(committees.contains(committee)){
            throw new CollegeException(COMMITTEE_EXIST.toString());
        }
        if(!(committee.getCommitteeChairman() instanceof Doctor)){
            throw new CollegeException(AT_LEAST_DOCTOR.toString());
        }
        committees.add(committee);
    }



    public StringBuilder getLecturers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lecturers.size(); i++) {
            sb.append(lecturers.get(i).toString());

            if (i < lecturers.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        sb.append("]");
        return sb;
    }

    public StringBuilder getCommittees() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < committees.size(); i++) {
            sb.append(committees.get(i).toString()).append("\n");
        }
        sb.append("]");
        return sb;
    }
    public StringBuilder getDepartments() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < studyDepartments.size(); i++) {
            sb.append(studyDepartments.get(i).toString()).append("\n");
        }
        sb.append("]");
        return sb;
    }


    public double getAverageSalaryCommittee(StudyDepartment findDep) {
        return findDep.getAverage();
    }

    public double getAverageSalary() {
        if (lecturers.isEmpty()) return 0.0;
        double res = 0.0;
        for (Lecturer lecturer : lecturers){
            res += lecturer.getSalary();
        }
        return Math.round((res / lecturers.size()) * 100.0) / 100.0;
    }

    public void addStudyDepartment(String name, int numOfStudents) throws CollegeException {
        addStudyDepartment(new StudyDepartment(name, numOfStudents));
    }

    public void addStudyDepartment(StudyDepartment studyDepartment) throws CollegeException {
        if(studyDepartments.contains(studyDepartment)){
            throw new CollegeException(DEPARTMENT_EXIST.toString());
        }
        studyDepartments.add(studyDepartment);
    }


    public void addLecturerToDep(String name, String department) throws CollegeException {
        Lecturer lecturer = findLecturerByName(name);
        StudyDepartment studyDepartment = findDepartmentByName(department);
        if(studyDepartment == null) {
            throw new CollegeException(DEPARTMENT_NOT_EXIST.toString());
        }
        if(lecturer == null){
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(!studyDepartment.addLecturer(lecturer)){
            throw new CollegeException(LECTURER_EXIST.toString());
        }
        for (StudyDepartment dep : studyDepartments) {
            if (!dep.getName().equals(studyDepartment.getName())) {
                dep.removeLecturer(lecturer);
            }
        }
        lecturer.setStudyDepartment(studyDepartment);
    }

    public void addLecturerCommittee(String lecName, String comName) throws CollegeException {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(committee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        if(committee.getDegreeType() != lecturer.getDegree()) {
            throw new CollegeException(COMMITTEE_DEGREETYPE.toString());
        }
        if(committee.lecturers.contains(lecturer)) {
            throw new CollegeException(LECTURER_EX_COM.toString());
        }
        if(committee.getCommitteeChairman().getName().equals(lecName)) {
            throw new CollegeException(ALREADY_CHAIRMAN.toString());
        }
        committee.addLecturer(lecturer);
        lecturer.addCommittee(committee);
    }

    public void removeLecturerFromCommittee(String lecName, String comName) throws CollegeException {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(committee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        if(!committee.lecturers.contains(lecturer)) {
            throw new CollegeException(LECTURER_NOT_EX_COM.toString());
        }
        committee.removeLecturer(lecturer);
        lecturer.removeCommittee(committee);
    }

    public void editCommitteeChairMan(String lecName, String comName) throws CollegeException {
        Lecturer lecturer = findLecturerByName(lecName);
        Committee committee = findCommitteeByName(comName);
        if(lecturer == null) {
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if(committee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        if(lecturer.getDegree() != DegreeType.DOCTOR && lecturer.getDegree() != DegreeType.PROFESSOR ){
            throw new CollegeException(AT_LEAST_DOCTOR.toString());
        }
        if(committee.getCommitteeChairman().getName().equals(lecName)) {
            throw new CollegeException(ALREADY_CHAIRMAN.toString());
        }
        committee.setCommitteeChairman(lecturer);
        if(committee.lecturers.contains(lecturer)) {
            committee.removeLecturer(lecturer);
            lecturer.removeCommittee(committee);
        }
    }

    public void compareDoctorProfessorArticles(String lecturer1, String lecturer2) throws CollegeException {
        Lecturer firstlecturer = findLecturerByName(lecturer1);
        Lecturer secondLecturer = findLecturerByName(lecturer2);
        if (firstlecturer == null || secondLecturer == null){
            throw new CollegeException(LECTURER_NOT_EXIST.toString());
        }
        if (firstlecturer instanceof Doctor lecturer_1 && secondLecturer instanceof Doctor lecturer_2){
            lecturer_1.compareTo(lecturer_2);
        }else{
            throw new CollegeException(AT_LEAST_DOCTOR.toString());
        }

    }

    public void compareCommittees(String committee1, String committee2) throws CollegeException {
        Committee firstCommittee = findCommitteeByName(committee1);
        Committee secondCommittee = findCommitteeByName(committee2);
        if (firstCommittee == null || secondCommittee == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        CompareComByArticles comp1 = new CompareComByArticles();
        CompareComByLecturers comp2 = new CompareComByLecturers();
        comp1.compare(firstCommittee, secondCommittee);
        comp2.compare(firstCommittee, secondCommittee);
    }

    public void duplicateCommittee(String committee) throws CollegeException, CloneNotSupportedException {
        Committee committeeToDup = findCommitteeByName(committee);
        if (committeeToDup == null){
            throw new CollegeException(COMMITTEE_NOT_EXIST.toString());
        }
        committeeToDup.clone();
    }

}
