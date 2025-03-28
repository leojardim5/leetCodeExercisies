
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) throws Exception {

        // System.out.println(frequenciaDeCaracteres("aavvvsbb"));
        // for (String string : letrasRepetidas(palavras)) {
        //     System.out.println(string);
        // }
        // String[] palavras = {"passaro", "peixe", "gato", "peixe", "peixe"};
        // for (int freq : trocarPorFrequencia(palavras)) {
        //     System.out.println(freq);
        // }
        // System.out.println(primeiraLetraUnica("aabbcsefmmc"));
        // int[] valores = {1, 2, 3, 4, 6, 7, 8, 9};
        // System.out.println(numerosDuplicados(valores));
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

    public static List<String> letrasRepetidas(String[] palavras) {

        List<String> lista = new ArrayList<>();

        for (String palavra : palavras) {
            Set<Character> set = new HashSet<Character>();
            boolean eRepetido = false;
            for (int i = 0; i < palavra.length(); i++) {

                if (!set.add(palavra.charAt(i))) {
                    eRepetido = true;
                }
            }

            if (!eRepetido) {
                lista.add(palavra);
            }

        }
        return lista;
    }

    public static int[] trocarPorFrequencia(String[] palavras) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < palavras.length; i++) {

            map.put(palavras[i], map.getOrDefault(palavras[i], 0) + 1);

        }

        int[] listaFrequencia = new int[map.size()];
        int i = 0;
        for (int frequencia : map.values()) {

            listaFrequencia[i] = frequencia;
            i++;
        }
        return listaFrequencia;

    }

    public static Character primeiraLetraUnica(String frase) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < frase.length(); i++) {

            map.put(frase.charAt(i), map.getOrDefault(frase.charAt(i), 0) + 1);

        }

        for (char x : frase.toCharArray()) {

            if (map.get(x) == 1) {

                return x;

            }

        }

        return null;
    }

    public static boolean verificarAnagramas(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        for (char c : s2.toCharArray()) {

            if (map.containsKey(c) || map.get(c) == 0) {

                map.put(c, map.get(c) - 1);

            }

        }

        for (Integer i : map.values()) {

            if (i != 0) {
                return false;
            }

        }

        return true;

    }

    public static int contarFreqImpar(int[] vetor) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : vetor) {

            map.put(i, map.getOrDefault(i, 0) + 1);

        }

        for (int x : vetor) {

            if (map.get(x) % 2 != 0) {

                return x;

            }

        }
        return -1;
    }

    public static List<String> palavraComLetraRepetida(String[] vetorPalavras) {

        List<String> listToReturn = new ArrayList<>();

        for (int x = 0; x < vetorPalavras.length; x++) {

            HashSet<Character> set = new HashSet<>();
            for (char c : vetorPalavras[x].toCharArray()) {

                if (!set.add(c)) {

                    listToReturn.add(vetorPalavras[x]);
                    break;

                }

            }

        }

        return listToReturn;

    }

    public static boolean palindromoPorOrdenacao(String palavra) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : palavra.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        int contadorImpar = 0;
        for (int c : map.values()) {

            if (palavra.length() % 2 == 0) {

                if (c % 2 != 0) {
                    return false;
                }

            }

            if (palavra.length() % 2 != 0) {

                if (c % 2 != 0) {
                    contadorImpar++;
                }

            }

            if (contadorImpar > 1) {
                return false;
            }

        }

        return true;

    }

    public static int caracteresEmComum(String s1, String s2) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {

            map.put(c, 1);

        }

        for (char c : s2.toCharArray()) {

            if (map.getOrDefault(c, 0) == 1) {

                map.put(c, 2);

            }

        }

        int valueToReturn = 0;

        for (int c : map.values()) {

            if (c == 2) {
                valueToReturn++;
            }

        }

        return valueToReturn;

    }

    public static boolean ePangrama(String s) {

        HashSet<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {

            if (c != ' ') {

                set.add(c);

            }

        }

        return set.size() == 26 ? true : false;
    }

    public static boolean numerosDuplicados(int[] valores) {

        HashSet<Integer> set = new HashSet<>();

        for (int valor : valores) {

            if (!set.add(valor)) {
                return true;
            }
        }

        return false;
    }

    public static List<Integer> intersecDoisArrays(int[] nums1, int[] nums2) {
        Set<Integer> listaToReturn = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {

            if (set.contains(n)) {
                listaToReturn.add(n);
            }

        }

        return new ArrayList<>(listaToReturn);

    }

    public static int maiorApperance(int[] vetor) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : vetor) {

            map.put(i, map.getOrDefault(i, 0) + 1);

        }
        int maiorValor = 0;
        int maiorAparicao = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maiorValor) {
                maiorAparicao = entry.getKey();
                maiorValor = entry.getValue();
            }

        }

        return maiorAparicao;

    }

    

}
