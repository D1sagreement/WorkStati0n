package Home_work_5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class TextUtils {
    public static String[] splitIntoWords(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else if (c ==  '-') {
                if (i > 0 && i < text.length() - 1 &&
                Character.isLetterOrDigit(text.charAt(i - 1)) &&
                Character.isLetterOrDigit(text.charAt(i + 1))) {
                    currentWord.append(c);
                } else {
                    if (currentWord.length() > 0) {
                        words.add(currentWord.toString());
                        currentWord = new StringBuilder();
                    }
                }
            } else {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            }
        }

        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        return words.toArray(new String[0]);
    }

    public static String readFileToString(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }
}
