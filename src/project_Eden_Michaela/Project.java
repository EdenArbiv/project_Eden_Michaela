package project_Eden_Michaela;
import java.util.Scanner;

public class Project {
    private static final String[] MENU = {
            "Exit Program",
            "Add Lecturer",
            "Add Meeting",
            "Add Study Department",
            "Add lecturer to Meeting",
            "Show Average of salary",
            "Show Average of salary Meeting",
            "Show Lecturers details",
            "Show Meeting details"
    };
    private static Scanner s;
    private static String collegeName;
    private static String[] lecturers;
    private static String[] meetings;
    private static String[] studyDepartment;
    private static int numOfLecturers;
    private static int numOfMeetings;
    private static int numOfStudyDepartment;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        System.out.println("Enter college name: " );
        collegeName = s.next();
        s.nextLine();
        run();
        s.close();
    }

    private static void run() {
        lecturers = new String[0];
        meetings = new String[0];
        studyDepartment = new String[0];
        int userChosen;
        do {
            userChosen = showMenu(s);
            switch (userChosen) {
                case 0 -> System.out.println("Done... Bye");
                case 1 -> addLecturer();
                case 2 -> addMeeting();
                case 3 -> addStudyDepartment();
                case 4 -> AddLecturerMeeting();
                case 5 -> ShowAverageSalary();
                case 6 -> ShowAverageSalaryMeeting();
                case 7 -> ShowLecturersDetails();
                case 8 -> ShowMeetingDetails();
                default -> System.out.println("Unexpected value");
            }
        } while (userChosen != 0);
    }

    private static void ShowMeetingDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfMeetings; i++) {
            sb.append(meetings[i]);
            if (i < numOfMeetings - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);

    }

    private static void ShowAverageSalaryMeeting() {
    }

    private static void ShowAverageSalary() {
    }

    private static void AddLecturerMeeting() {
        s.nextLine();
        System.out.println("Enter lecturer name: ");
        String lecturer = s.nextLine();
        boolean isExitLecturer = isExist(lecturers, numOfLecturers, lecturer);
        if (!isExitLecturer){
            System.out.println("This lecturer is not Exist");
        }
        System.out.println("Enter meeting name: ");
        String meeting = s.nextLine();
        boolean isExitMeeting = isExist(meetings, numOfMeetings, meeting);
        if (!isExitMeeting){
            System.out.println("This meeting is not Exist");
        }
    }

    private static void ShowLecturersDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i]);
            if (i < numOfLecturers - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    private static void addLecturer() {
        s.nextLine(); // מנקה תו Enter אם הגיע מ-nextInt()
        String name;

        while (true) {
            System.out.println("Enter lecturer name: ");
            name = s.nextLine();
            if (isExist(lecturers,  numOfLecturers,name)) {
                System.out.println(name + " already exists. Try again.");
            } else {
                break;
            }
        }

        if (numOfLecturers == lecturers.length) {
            lecturers = copyOf(lecturers, numOfLecturers == 0 ? 2 : numOfLecturers * 2);
        }
        lecturers[numOfLecturers++] = name;
    }

    private static void addMeeting() {
        s.nextLine(); // מנקה תו Enter אם הגיע מ-nextInt()
        String name;

        while (true) {
            System.out.println("Enter meeting name: ");
            name = s.nextLine();
            if (isExist(meetings,  numOfMeetings,name)) {
                System.out.println(name + " already exists. Try again.");
            } else {
                break;
            }
        }

        if (numOfMeetings == meetings.length) {
            meetings = copyOf(meetings, numOfMeetings == 0 ? 2 : numOfMeetings * 2);
        }
        meetings[numOfMeetings++] = name;
    }

    private static void addStudyDepartment() {
        s.nextLine(); // מנקה תו Enter אם הגיע מ-nextInt()
        String name;

        while (true) {
            System.out.println("Enter study department name: ");
            name = s.nextLine();
            if (isExist(studyDepartment,  numOfStudyDepartment,name)) {
                System.out.println(name + " already exists. Try again.");
            } else {
                break;
            }
        }

        if (numOfStudyDepartment == studyDepartment.length) {
            studyDepartment = copyOf(studyDepartment, numOfStudyDepartment == 0 ? 2 : numOfStudyDepartment * 2);
        }
        studyDepartment[numOfStudyDepartment++] = name;
    }

    private static String[] copyOf(String[] arr , int size) {
        String[] newArr = new String[size];
        int limit = arr.length < size ? arr.length : size;
        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private static boolean isExist(String[] kindOfArr, int size, String name) {
        for (int i = 0; i < size; i++) {
            if (kindOfArr[i].equals(name)){
                return true;
            }
        }
        return false;
    }



    private static int showMenu(Scanner s) {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.println("Please enter your chose : ");
        return s.nextInt();
    }

}