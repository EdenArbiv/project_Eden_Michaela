package project_Eden_Michaela;

public class Professor extends Lecturer{
    private String[] articleArr;
    private String institution;
    private int numOfArticlesArr;

    public Professor(String name, String id, DegreeType degree, String degreeName, double salary, String institution) {
        super(name, id, degree, degreeName, salary);
        this.institution = institution;
        articleArr = new String[0];
    }


}
