package Home_work_5;

class SearchEnginePunctuationNormal implements ISearchEngine {
    private ISearchEngine engine;

    public SearchEnginePunctuationNormal(ISearchEngine engine) {
        this.engine = engine;
    }

    @Override
    public long search(String text, String word) {
        if (text == null || word == null) {
            return 0;
        }

        String normalizedText = normalizeText(text);
        String normalizedWord = normalizedWord(word);

        return engine.search(normalizedText, normalizedWord);
    }

    private String normalizeText(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c) || c == ' ' || c == '\n' || c == '\r') {
                result.append(c);
            } else if (c == '-') {
                if (i > 0 && i < text.length() - 1 &&
                        Character.isLetterOrDigit(text.charAt(i - 1)) &&
                        Character.isLetterOrDigit(text.charAt(i + 1))) {
                    result.append(c);
                } else {
                    result.append(' ');
                }
            } else {
                result.append(' ');
            }

        }
        String singleSpaced = result.toString().replaceAll("\\s+", " ");
        return singleSpaced;
    }

    private String normalizedWord(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = word.length();

        while (start < end && !Character.isLetterOrDigit(word.charAt(start))) {
            start++;
        }
        while (end > start && !Character.isLetterOrDigit(word.charAt(end - 1))) {
            end--;
        }

        if (start >= end) {
            return "";
        }
        return word.substring(start, end);
    }
}
