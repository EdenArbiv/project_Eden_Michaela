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
                case 2 -> addCommittee();
                case 3 -> addLecturerCommittee();
                case 4 -> editCommitteeChairMan();
                case 5 -> deleteLecturerCommittee();
                case 6 -> addStudyDepartment();
                case 7 -> showAverageSalary();
                case 8 -> showAverageSalaryCommittee();
                case 9 -> showLecturersDetails();
                case 10 -> showCommitteeDetails();
                default -> System.out.println("Unexpected value");
            }
        } while (userChosen != 0);
    }

    private static void showCommitteeDetails() {
    }

    private static void showLecturersDetails() {
    }

    private static void showAverageSalaryCommittee() {
    }

    private static void showAverageSalary() {
    }

    private static void addStudyDepartment() {
    }

    private static void deleteLecturerCommittee() {

    }

    private static void editCommitteeChairMan() {
    }

    private static void addLecturerCommittee() {
    }

    private static void addCommittee() {

    }

    private static void addLecturerDetails(College c) {
        Status res = Status.ALREADY_EXIST;
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
            int salary = s.nextInt();
            s.nextLine();

            res = c.addLecturer(name, id, degreeType, degreeName, salary);
            System.out.println(res);
        }
        System.out.println(Status.SUCCESS.getMessage());


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
