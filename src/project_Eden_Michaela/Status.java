package project_Eden_Michaela;

public enum Status {
    SUCCESS("Operation completed Successfully"),
    FAILED("Operation failed"),
    LECTURER_EXIST("Lecturer already exist, please try again: "),
    LECTURER_EX_COM("Lecturer already exist in the committee"),
    LECTURER_NOT_EXIST("Lecturer not exist, please try again: "),
    COMMITTEE_EXIST("Committee already exist, please try again: "),
    COMMITTEE_NOT_EXIST("Committee not exist, please try again: "),
    DEPARTMENT_EXIST("Study department already exist, please try again: "),
    DEPARTMENT_NOT_EXIST("Study department not exist, please try again: "),
    CHAIRMAN_NOT_EXIST("Chairman not exist"),
    AT_LEAST_DOCTOR("The lecturer is required to have at least a doctorate"),
    ALREADY_CHAIRMAN("The lecturer is already chairman in the committee"),
    LECTURER_NOT_EX_COM("The lecturer is not in the committee"),
    NOT_FOUND("Item Not found"),
    INVALID_INPUT("Invalid input provided");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
