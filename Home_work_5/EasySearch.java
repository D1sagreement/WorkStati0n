package Home_work_5;

class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        if (text == null || word == null || word.isEmpty()) {
            return 0;
        }

        long count = 0;
        int index = 0;
        int wordLenght = word.length();

        while (index < text.length()) {
            index = text.indexOf(word, index);
            if (index == -1) {
                break;
            }

            boolean isStartOk = checkStart(text, index);
            boolean isEndOk = checkEnd(text, index, wordLenght);

            if (isStartOk && isEndOk) {
                count++;
            }

            index += 1;
        }

        return count;
    }

    private boolean checkStart(String text, int index) {
        if (index == 0) {
            return true;
        }

        char before = text.charAt(index - 1);
        return !(Character.isLetterOrDigit(before) || before == '-');
    }

    private boolean checkEnd(String text, int index, int wordLenght) {
        int endIndex = index + wordLenght;

        if (endIndex >= text.length()) {
            return true;
        }

        char after = text.charAt(endIndex);
        return !(Character.isLetterOrDigit(after) || after == '-');
    }
}
