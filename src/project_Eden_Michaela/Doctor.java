package project_Eden_Michaela;

import java.util.ArrayList;

public class Doctor extends Lecturer implements Comparable<Doctor>{
    ArrayList<String> articleArr;



    public Doctor(String name, String id, DegreeType degree, String degreeName, double salary, ArrayList<String> articleArr) throws CollegeException {
        super(name, id, degree, degreeName, salary);
        this.articleArr = articleArr;
    }

    public String articlesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ,articles = ");
        for (int i = 0; i < articleArr.size(); i++) {
            sb.append(articleArr.get(i));
            if (i != articleArr.size() -1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return super.toString() + articlesToString();
    }


    @Override
    public int compareTo(Doctor other) {
        return Integer.compare(articleArr.size(), other.articleArr.size());
    }
}
