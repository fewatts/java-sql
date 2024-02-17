import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static List<String> singlePermutations(String inputString) {
        List<String> permutations = new ArrayList<>();
        if (inputString.isEmpty())
            return permutations;

        List<Character> uniqueCharacters = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            if (!uniqueCharacters.contains(c))
                uniqueCharacters.add(c);
        }

        int factorial = factorial(uniqueCharacters.size());

        for (int i = 0; i < factorial; i++) {
            Collections.shuffle(uniqueCharacters);
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : uniqueCharacters)
                stringBuilder.append(c);
            permutations.add(stringBuilder.toString());
        }

        return permutations;
    }

    private static int factorial(int n) {
        return (n <= 1) ? 1 : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(singlePermutations("fer"));
    }
}
