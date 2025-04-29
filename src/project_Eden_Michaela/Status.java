package project_Eden_Michaela;

public enum Status {
    SUCCESS("Operation completed Successfully"),
    FAILED("Operation failed"),
    ALREADY_EXIST("Item already exist"),
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
