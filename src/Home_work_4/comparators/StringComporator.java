package Home_work_4.comparators;
import java.util.Comparator;

public class StringComporator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
