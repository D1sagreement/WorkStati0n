package Home_work_5;

class SearchEngineCaseNormal implements ISearchEngine {
    private ISearchEngine engine;

    public SearchEngineCaseNormal(ISearchEngine engine) {
        this.engine = engine;
    }

    @Override
    public long search(String text, String word) {
        if (text == null || word == null) {
            return 0;
        }

        String normalizedText = normalizeToNominative(text);
        String normalizedWord = normalizeToNominative(word);

        SearchEngineCaseInsensitive insensitiveEngine = new SearchEngineCaseInsensitive(engine);

        return insensitiveEngine.search(normalizedText, normalizedWord);
    }

    private String normalizeToNominative(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.length() > 3) {
                String normalizedWord = word;

                if (word.endsWith("ой") || word.endsWith("ей") ||
                        word.endsWith("ую") || word.endsWith("юю")) {
                    normalizedWord = word.substring(0, word.length() - 2) + "ая";
                } else if (word.endsWith("ому") || word.endsWith("ему")) {
                    normalizedWord = word.substring(0, word.length() - 3) + "ый";
                } else if (word.endsWith("ом") || word.endsWith("ем")) {
                    normalizedWord = word.substring(0, word.length() - 2);
                } else if (word.endsWith("ами") || word.endsWith("ями")) {
                    normalizedWord = word.substring(0, word.length() - 3);
                } else if (word.endsWith("ах") || word.endsWith("ях")) {
                    normalizedWord = word.substring(0, word.length() - 2);
                } else if (word.endsWith("ов") || word.endsWith("ев") || word.endsWith("ёв")) {

                } else if (word.endsWith("ам") || word.endsWith("ям")) {
                    normalizedWord = word.substring(0, word.length() - 2);
                } else if (word.endsWith("и") && word.length() > 1) {
                    normalizedWord = word.substring(0, word.length() - 1);
                }

                result.append(normalizedWord).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }
        return  result.toString().trim();
    }
}