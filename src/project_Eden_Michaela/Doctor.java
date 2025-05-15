package project_Eden_Michaela;

public class Doctor extends Lecturer{
    private String[] articleArr;
    private int numOfArticlesArr;


    public Doctor(String name, String id, DegreeType degree, String degreeName, double salary) {
        super(name, id, degree, degreeName, salary);
        articleArr = new String[0];
    }
}
