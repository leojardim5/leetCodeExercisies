
import java.util.HashMap;

public class App {

    public static void main(String[] args) throws Exception {

        String[] paraTeste = divideString("abcdefghij", 3, 'k');

        for (String string : paraTeste) {

            System.out.println(string);

        }

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

}
