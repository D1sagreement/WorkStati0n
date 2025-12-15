package Home_work_5;

import java.io.IOException;
import java.util.*;

public class WarAndPeaceAnalysis {
    public static void main(String[] args) {
        try {
            String filePath = "src\\Home_work_5\\Война и мир.bin";
            System.out.println("Чтение файла " + filePath);

            String text = TextUtils.readFileToString(filePath);
            System.out.println("Файл успешно прочитан.");
            System.out.println("Общая длина текста: " + text.length() + " символов\n");

            Set<String> uniqueWords = getUniqueWords(text);
            System.out.println("2.1 Уникальные слова:");
            System.out.println("Кол-во уникальных слов: " + uniqueWords.size());

            int topN = 10;
            Map<String, Integer> wordFrequency = getWordFrequency(text);
            List<Map.Entry<String, Integer>> topWords = getTopWords(wordFrequency, topN);

            System.out.println("\n Топ слов " + topN + " самые частые слова:");
            for (int i = 0; i < topWords.size(); i++) {
                Map.Entry<String, Integer> entry = topWords.get(i);
                System.out.printf("%2d. %-15s - %6d раз%n",
                        i + 1, entry.getKey(), entry.getValue());
            }

            System.out.println("\n5. Поиск слов 'война', 'и', 'мир': ");
            System.out.println("--------------------------------------");
            System.out.println("\n5.1 Поиск 'как есть':");

            ISearchEngine easySearch = new EasySearch();
            System.out.println("\nEasySearch:");
            printSearchResults(easySearch, text, "война", "и", "мир");

            ISearchEngine regExSearch = new RegExSearch();
            System.out.println("\nRegExSearch:");
            printSearchResults(regExSearch, text, "война", "и", "мир");

            System.out.println("\nС декораторами:");

            ISearchEngine normalizedSearch = new SearchEnginePunctuationNormal(easySearch);
            System.out.println("\nSearchEnginePunctuationNormalizer + EasySearch:");
            printSearchResults(normalizedSearch, text, "война", "и", "мир");

            ISearchEngine caseInsensitiveSearch = new SearchEngineCaseInsensitive(easySearch);
            System.out.println("\nSearchEngineCaseInsensitive + EasySearch:");
            printSearchResults(caseInsensitiveSearch, text, "война", "и", "мир");

            ISearchEngine caseNormalizerSearch = new SearchEngineCaseNormal(easySearch);
            System.out.println("\nSearchEngineCaseNormalizer + EasySearch:");
            printSearchResults(caseNormalizerSearch, text, "война", "и", "мир");

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Set<String> getUniqueWords(String text) {
        String[] words = TextUtils.splitIntoWords(text);
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }

    private static Map<String, Integer> getWordFrequency(String text) {
        String[] words = TextUtils.splitIntoWords(text);
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                if (frequencyMap.containsKey(word)) {
                    frequencyMap.put(word, frequencyMap.get(word) + 1);
                } else {
                    frequencyMap.put(word, 1);
                }
            }
        }
        return frequencyMap;
    }

    private static List<Map.Entry<String, Integer>> getTopWords(
            Map<String, Integer> frequencyMap, int topN) {

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        if (topN < entries.size()) {
            return entries.subList(0, topN);
        }

        return entries;
    }

    private static void printSearchResults(ISearchEngine engine, String text,
                                           String... words) {
        for (String word : words) {
            long count = engine.search(text, word);
            System.out.printf(" '%s' - %d раз%n", word, count);
        }
    }

    public static void testWordSplitting() {
        System.out.println("\n Тест разбиения слов:");
        System.out.println("-----------------------");

        String[] testCases = {
                "Привет, как дела!",
                "Привет,какдела!",
                "Привет;как дела!",
                "как дела!. Что делаешь?",
                "Привет-привет",
                "Привет -привет",
                "4-х",
                "один и 1",
                "бабушка бабушке бабушку"
        };

        for (String testCase : testCases) {
            String[] words = TextUtils.splitIntoWords(testCase);
            System.out.println("\"" + testCase + "\"");
            System.out.println(" -> [" + String.join(", ", words) + "]");
            System.out.println(" -> Кол-во слов: " + words.length);
            System.out.println();
        }
    }
}
