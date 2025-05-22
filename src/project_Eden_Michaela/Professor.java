package project_Eden_Michaela;

public class Professor extends Lecturer{
    private String[] articleArr;
    private String institution;
    private int numOfArticlesArr;

    public Professor(String name, String id, DegreeType degree, String degreeName, double salary,String[] articleArr, int numOfArticlesArr, String institution) {
        super(name, id, degree, degreeName, salary);
        this.articleArr = articleArr;
        this.numOfArticlesArr = numOfArticlesArr;
        this.institution = institution;

    }

    public String articlesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ,articles = ");
        for (int i = 0; i < numOfArticlesArr; i++) {
            sb.append(articleArr[i]);
            if (i != numOfArticlesArr -1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + articlesToString() + " ,institution name: " + institution;
    }
}
