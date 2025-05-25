package project_Eden_Michaela;

public class Professor extends Doctor{
    private String institution;

    public Professor(String name, String id, DegreeType degree, String degreeName, double salary,String[] articleArr, int numOfArticlesArr, String institution) throws CollegeException {
        super(name, id, degree, degreeName, salary, articleArr, numOfArticlesArr);
        this.institution = institution;

    }


    @Override
    public String toString() {
        return super.toString() +" ,institution name: " + institution;
    }
}
