
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println(frequenciaDeCaracteres("aavvvsbb"));

    }

    public static int[] twoSum(int[] array, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x = 0; x < array.length; x++) {

            int complement = target - array[x];

            if (map.containsKey(complement)) {

                return new int[]{map.get(complement), x};

            }

            map.put(array[x], x);

        }

        return null;
    }

    public static String[] divideString(String s, int k, char fill) {

        int rest = s.length() % k;
        int numberOfStrings = s.length() / k;

        StringBuilder newString = new StringBuilder();

        String[] arrayToReturn = (rest > 0) ? new String[numberOfStrings + 1] : new String[numberOfStrings];
        int indexIterator = 0;

        for (int x = 0, y = 0; x < s.length(); x++) {

            newString.append(s.charAt(x));

            if (newString.length() == k) {
                arrayToReturn[indexIterator++] = newString.toString();
                newString.setLength(0);

            }

        }

        if (newString.length() > 0) {

            while (newString.length() < k) {
                newString.append(fill);
            }

            arrayToReturn[indexIterator] = newString.toString();

        }

        return arrayToReturn;

    }

    public static int longestSubstringMapWay(String phrase) {

        HashMap<Character, Integer> map = new HashMap<>();

        int maxSub = 0;

        for (int right = 0, left = 0; right < phrase.length(); right++) {
            char currentCharacter = phrase.charAt(right);

            if (map.containsKey(currentCharacter) && map.get(currentCharacter) >= left) {

                left = map.get(currentCharacter) + 1;

            }

            maxSub = Math.max(maxSub, right - left + 1);
            map.put(currentCharacter, right);

        }

        return maxSub;

    }

    public static int longestSubstringSetWay(String phrase) {

        int inicio = 0, maxSub = 0;

        HashSet<Character> set = new HashSet<>();

        for (int fim = 0; fim < phrase.length(); fim++) {

            char currentCharacter = phrase.charAt(fim);

            while (set.contains(currentCharacter)) {

                set.remove(phrase.charAt(inicio));
                inicio++;

            }

            set.add(currentCharacter);
            maxSub = Math.max(maxSub, fim - inicio + 1);

        }

        return maxSub;

    }

    public static List<String> letterCombination(String digits) {

        List<String> result = new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterCombination(result, digits, "", 0, map);
        return result;

    }

    public static void letterCombination(List<String> result, String digits, String current, int index, HashMap<Character, String> map) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = map.get(digits.charAt(index));

        for (int i = 0; i < letters.length(); i++) {

            letterCombination(result, digits, current + letters.charAt(i), index + 1, map);

        }

    }

    public static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : words) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());

    }

    public static Map<Character, Integer> frequenciaDeCaracteres(String frase) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < frase.length(); i++) {

            map.put(frase.charAt(i), map.getOrDefault(frase.charAt(i), 0) + 1);

        }

        return map;

    }

}
