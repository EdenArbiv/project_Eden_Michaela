package project_Eden_Michaela;

public class Doctor extends Lecturer{
    private String[] articleArr;
    private int numOfArticlesArr;


    public Doctor(String name, String id, DegreeType degree, String degreeName, double salary, String[] articleArr, int numOfArticlesArr) {
        super(name, id, degree, degreeName, salary);
        this.articleArr = articleArr;
        this.numOfArticlesArr = numOfArticlesArr;
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
        return super.toString() + articlesToString();
    }


}
