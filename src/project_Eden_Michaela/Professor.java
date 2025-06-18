package project_Eden_Michaela;

import java.util.ArrayList;

public class Professor extends Doctor{
    private String institution;

    public Professor(String name, String id, DegreeType degree, String degreeName, double salary, ArrayList<String> articleArr, String institution) throws CollegeException {
        super(name, id, degree, degreeName, salary, articleArr);
        this.institution = institution;

    }


    @Override
    public String toString() {
        return super.toString() +" ,institution name: " + institution;
    }
}
