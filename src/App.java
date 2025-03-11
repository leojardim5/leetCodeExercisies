
import java.util.HashMap;
import java.util.HashSet;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println(longestSubstringSetWay("abcabcdcef"));

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

}
