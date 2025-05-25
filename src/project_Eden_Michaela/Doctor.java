package project_Eden_Michaela;

public class Doctor extends Lecturer implements Comparable<Doctor>{
    private String[] articleArr;
    private int numOfArticlesArr;


    public Doctor(String name, String id, DegreeType degree, String degreeName, double salary, String[] articleArr, int numOfArticlesArr) throws CollegeException {
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

    public int getNumOfArticlesArr() {
        return numOfArticlesArr;
    }

    @Override
    public String toString() {
        return super.toString() + articlesToString();
    }


    @Override
    public int compareTo(Doctor other) {
        return Integer.compare(numOfArticlesArr, other.numOfArticlesArr);
    }
}
