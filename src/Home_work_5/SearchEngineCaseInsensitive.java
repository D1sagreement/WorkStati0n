package Home_work_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SearchEngineCaseInsensitive implements ISearchEngine {
    private ISearchEngine engine;

    public SearchEngineCaseInsensitive(ISearchEngine engine) {
        this.engine = engine;
    }

    @Override
    public long search(String text, String word) {
        if (text == null || word == null) {
            return 0;
        }

        if (engine instanceof RegExSearch) {
            return searchWithRegEx(text, word);
        }

        return engine.search(text.toLowerCase(), word.toLowerCase());
    }

    private long searchWithRegEx(String text, String word) {
        if (text.isEmpty() || word.isEmpty()) {
            return 0;
        }

        String escapedWord = Pattern.quote(word);
        String regex = "\\b" + escapedWord + "\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(text);

        long count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}