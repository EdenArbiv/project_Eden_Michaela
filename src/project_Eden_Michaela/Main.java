package project_Eden_Michaela;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter collage name: ");
        String name = s.nextLine();
        College c = new College(name);
        run(c);
        s.close();
    }

    private static final String[] MENU = {
            "Exit Program",
            "Add Lecturer",
            "Add Committee",
            "Add lecturer to Committee",
            "Edit Committee ChairMan",
            "Delete Lecturer from Committee",
            "Add Study Department",
            "Ass lecturer to study department",
            "Show Average of salary",
            "Show Average of salary Committee",
            "Show Lecturers details",
            "Show Committee details"
    };
    private static Scanner s = new Scanner(System.in);


    public static void run(College c) {
        int userChosen;
        do {
            userChosen = showMenu(s);
            switch (userChosen) {
                case 0 -> System.out.println("Done... Bye");
                case 1 -> addLecturerDetails(c);
                case 2 -> addCommitteeDetails(c);
                case 3 -> addLecturerCommitteeDetails(c);
                case 4 -> editCommitteeChairManDetails(c);
                case 5 -> removeLecturerFromCommitteeDetails(c);
                case 6 -> addStudyDepartmentDetails(c);
                case 7 -> addLecturerToDepDetails(c);
                case 8 -> showAverageSalary(c);
                case 9 -> showAverageSalaryCommittee(c);
                case 10 -> showLecturersDetails(c);
                case 11 -> showCommitteeDetails(c);
                default -> System.out.println("Unexpected value");
            }
        } while (userChosen != 0);
    }

    private static void showCommitteeDetails(College c) {
        System.out.println(c.getCommittees());
    }

    private static void showLecturersDetails(College c) {
        System.out.println(c.getLecturers());
    }

    private static void showAverageSalaryCommittee(College c) {
        System.out.println(c.getAverageSalaryCommittee());

    }

    private static void showAverageSalary(College c) {
        System.out.println("Average salary of lecturers is: " + c.getAverageSalary());
    }

    private static void addLecturerToDepDetails(College c){
        Status res = Status.DEPARTMENT_EXIST;
        while (!res.equals(Status.SUCCESS)) {
            System.out.println("Enter lecturer name: ");
            String name = s.nextLine();
            System.out.println("Enter study department name: ");
            String depName = s.nextLine();
            res = c.addLecturerToDep(name, depName);
        }
    }


    private static void removeLecturerFromCommitteeDetails(College c) {

    }

    private static void editCommitteeChairManDetails(College c) {
    }

    private static void addLecturerCommitteeDetails(College c) {
    }

    private static void addStudyDepartmentDetails(College c) {
        Status res = Status.DEPARTMENT_EXIST;
        while (!res.equals(Status.SUCCESS)) {
            System.out.println("Enter study department name: ");
            String name = s.nextLine();
            System.out.println("Enter number of students: ");
            int numOfStudents = s.nextInt();
            s.nextLine();
            res = c.addStudyDepartment(name, numOfStudents);
            System.out.println(res);
        }


    }

    private static void addCommitteeDetails(College c) {
        Status res = Status.COMMITTEE_EXIST;
        while (!res.equals(Status.SUCCESS)) {
            Lecturer chairmanLecturer;
            System.out.println("Enter committee name: ");
            String name = s.nextLine();
            System.out.println("Enter chairman name: ");
            String chairman = s.nextLine();
            res = c.addCommittee(name, chairman);
            System.out.println(res);
        }
    }

    private static void addLecturerDetails(College c) {
        Status res = Status.LECTURER_EXIST;
        while (!res.equals(Status.SUCCESS)){
            System.out.println("Enter lecturer name: ");
            String name = s.nextLine();

            System.out.println("Enter lecturer id: ");
            String id = s.nextLine();

            System.out.println("Enter degree type (BA_DEGREE,MA_DEGREE, DOCTOR, PROFESSOR: ");
            String degree = s.nextLine();
            DegreeType degreeType = DegreeType.valueOf(degree.toUpperCase());

            System.out.println("Enter degree name: ");
            String degreeName = s.nextLine();

            System.out.println("Enter salary");
            double salary = s.nextInt();
            s.nextLine();

            res = c.addLecturer(name, id, degreeType, degreeName, salary);
            System.out.println(res);
        }
    }

    private static int showMenu(Scanner s) {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.println("Please enter your chose : ");
        int choice = s.nextInt();
        s.nextLine();
        return choice;
    }


}
