package Home_work_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExSearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        if (text == null || word == null || word.isEmpty()) {
            return 0;
        }

        String escapedWord = Pattern.quote(word);
        String regex = "\\b" + escapedWord + "\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        long count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
