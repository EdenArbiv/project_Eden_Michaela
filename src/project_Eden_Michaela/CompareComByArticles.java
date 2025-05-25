package project_Eden_Michaela;

import java.util.Comparator;

public class CompareComByArticles implements Comparator<Committee> {

    @Override
    public int compare(Committee o1, Committee o2) {
        return Integer.compare(o1.numOfArticles(), o2.numOfArticles());
    }
}
