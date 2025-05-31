package project_Eden_Michaela;
import java.util.Scanner;

import static project_Eden_Michaela.Status.SUCCESS;

public class Main {
    // Eden and Michaela
    // Eden 315253740
    // Michaela 323819342

    public static void main(String[] args) throws CollegeException {
        System.out.println("Enter collage name: ");
        String name = s.nextLine();
        College c = new College(name);
        run(c);
        s.close();
    }
    private static final Scanner s = new Scanner(System.in);
    private static final String[] MENU = {
            "Exit Program",
            "Add Lecturer",
            "Add Committee",
            "Add lecturer to Committee",
            "Edit Committee ChairMan",
            "Remove Lecturer from Committee",
            "Add Study Department",
            "Add lecturer to study department",
            "Show Average of salary",
            "Show Average of salary Department",
            "Show Lecturers details",
            "Show Committee details",
//            "Show Study Departments details",
            "Compare number of articles between doctor and professor",
            "Compare committees",
            "Duplicate committee"

    };


    public static void run(College c) throws CollegeException {
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
                case 9 -> showAverageSalaryDep(c);
                case 10 -> showLecturersDetails(c);
                case 11 -> showCommitteeDetails(c);
                case 12 -> compareDoctorProfessorArticles(c);
                case 13 -> compareCommittees(c);
                case 14 -> duplicateCommittee(c);
                // case 13 -> showDepartmentDetails(c); // for debugging
                default -> System.out.println("Unexpected value");
            }
        } while (userChosen != 0);
    }

    private static void duplicateCommittee(College c) {
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Enter committee:");
                String committee = s.nextLine();
                c.duplicateCommittee(committee);
                isOk = true;
                System.out.println(SUCCESS);
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void compareCommittees(College c) {
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Enter committee 1 (at least doctor): ");
                String committee1 = s.nextLine();
                System.out.println("Enter committee 2 (at least doctor): ");
                String committee2 = s.nextLine();
                c.compareCommittees(committee1, committee2);
                isOk = true;
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void compareDoctorProfessorArticles(College c) {
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Enter lecturer 1 (at least doctor): ");
                String lecturer1 = s.nextLine();
                System.out.println("Enter lecturer 2 (at least doctor): ");
                String lecturer2 = s.nextLine();
                c.compareDoctorProfessorArticles(lecturer1, lecturer2);
                isOk = true;
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static void showCommitteeDetails(College c) {
        System.out.println(c.getCommittees());
    }

    private static void showDepartmentDetails(College c) {
        System.out.println(c.getDepartments());
    }

    private static void showLecturersDetails(College c) {
        System.out.println(c.getLecturers());
    }

    private static void showAverageSalaryDep(College c) {
        Status res = Status.NOT_FOUND;
        while (!res.equals(SUCCESS)) {
            System.out.println("Enter study department: ");
            String name = s.nextLine();
            StudyDepartment findDep = c.findDepartmentByName(name);
            if (findDep == null){
                res = Status.DEPARTMENT_NOT_EXIST;
                System.out.println(res);
            }else {
                res = SUCCESS;
                System.out.println(c.getAverageSalaryCommittee(findDep));
            }
        }
    }


    private static void showAverageSalary(College c) {
        System.out.println("Average salary of lecturers is: " + c.getAverageSalary());
    }

    private static void addLecturerToDepDetails(College c){
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Enter lecturer name: ");
                String name = s.nextLine();
                System.out.println("Enter study department name: ");
                String depName = s.nextLine();
                c.addLecturerToDep(name, depName);
                isOk = true;
                System.out.println(SUCCESS);
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static void removeLecturerFromCommitteeDetails(College c) {
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Enter lecturer name: ");
                String name = s.nextLine();
                System.out.println("Enter committee name: ");
                String comName = s.nextLine();
                c.removeLecturerFromCommittee(name, comName);
                isOk =true;
                System.out.println(SUCCESS);
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void editCommitteeChairManDetails(College c) {
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Enter lecturer name: ");
                String name = s.nextLine();
                System.out.println("Enter committee name: ");
                String comName = s.nextLine();
                c.editCommitteeChairMan(name, comName);
                isOk = true;
                System.out.println(SUCCESS);
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addLecturerCommitteeDetails(College c) {
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Enter lecturer name: ");
                String name = s.nextLine();
                System.out.println("Enter committee name: ");
                String comName = s.nextLine();
                c.addLecturerCommittee(name, comName);
                isOk = true;
                System.out.println(SUCCESS);
            } catch (CollegeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addStudyDepartmentDetails(College c) {
        boolean isOk = false;
        while (!isOk) {
            try{
                System.out.println("Enter study department name: ");
                String name = s.nextLine();

                System.out.println("Enter number of students: ");
                int numOfStudents = s.nextInt();
                while (numOfStudents <= 0) {
                    System.out.println("Enter number of students (must be positive): ");
                    numOfStudents = s.nextInt();
                }
                s.nextLine();
                c.addStudyDepartment(name, numOfStudents);
                isOk = true;
                System.out.println(SUCCESS);
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addCommitteeDetails(College c) throws CollegeException{
        boolean isOk = false;
        while (!isOk) {
            try{
                System.out.println("Enter committee name: ");
                String name = s.nextLine();
                System.out.println("Enter chairman name: ");
                String chairman = s.nextLine();
                c.addCommittee(name, chairman);
                isOk = true;
                System.out.println(SUCCESS);
            } catch (CollegeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addLecturerDetails(College c) {
        boolean isOk = false;
        while (!isOk){
            try{
                System.out.println("Enter lecturer name: ");
                String name = s.nextLine();

                System.out.println("Enter lecturer id: ");
                String id = s.nextLine();

                System.out.println("Enter degree type (BA_DEGREE,MA_DEGREE, DOCTOR, PROFESSOR): ");
                String degree = s.nextLine();

                while (!degree.equalsIgnoreCase("BA_DEGREE") &&
                        !degree.equalsIgnoreCase("MA_DEGREE") &&
                        !degree.equalsIgnoreCase("DOCTOR") &&
                        !degree.equalsIgnoreCase("PROFESSOR")) {

                    System.out.println("Invalid Degree Type. Please enter one of the following: BA_DEGREE, MA_DEGREE, DOCTOR, PROFESSOR:");
                    degree = s.nextLine();
                }

                DegreeType degreeType = DegreeType.valueOf(degree.toUpperCase());

                System.out.println("Enter degree name: ");
                String degreeName = s.nextLine();

                double salary;
                System.out.println("Enter salary (positive number):");
                salary = s.nextDouble();
                s.nextLine();

                if (degreeType == DegreeType.DOCTOR || degreeType == DegreeType.PROFESSOR) {
                    System.out.println("Enter number of articles: ");
                    int numOfArticle = s.nextInt();
                    s.nextLine();
                    if (numOfArticle < 0) {
                        throw new CollegeException("Negative number");
                    }
                    String[] articlesArr = new String[numOfArticle];

                    for (int i = 1; i < numOfArticle + 1; i++) {
                        System.out.println("Enter article number " + i + ": ");
                        String nameOfArticle = s.nextLine();
                        articlesArr[i - 1] = nameOfArticle;
                    }
                    if(degreeType == DegreeType.PROFESSOR) {
                        System.out.println("Enter name of institution: ");
                        String institution = s.nextLine();
                        c.addLecturer(name, id, degreeType, degreeName, salary, articlesArr, numOfArticle, institution);
                    }else{
                        c.addLecturer(name, id, degreeType, degreeName, salary, articlesArr, numOfArticle);
                    }

                }else{
                    c.addLecturer(name, id, degreeType, degreeName, salary);
                }
                isOk = true;
                System.out.println(SUCCESS);
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
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
