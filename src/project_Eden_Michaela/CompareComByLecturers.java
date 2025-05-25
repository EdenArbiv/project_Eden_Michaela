package project_Eden_Michaela;

import java.util.Comparator;

public class CompareComByLecturers implements Comparator<Committee> {
    @Override
    public int compare(Committee o1, Committee o2) {
        return Integer.compare(o1.getNumOfLecturers(), o2.getNumOfLecturers());
    }
}
