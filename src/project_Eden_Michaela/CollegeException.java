package project_Eden_Michaela;

public class CollegeException extends Exception{
    private  static final String PRE_MESSAGE = "Error: ";

    public CollegeException(String message) {
        super(PRE_MESSAGE + message);
    }
}
