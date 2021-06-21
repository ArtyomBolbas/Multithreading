package org.example.codility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BinaryLenght {

    public static void main(String[] args) {
        BinaryLenght myObject = new BinaryLenght();
        int retult = myObject.solution(1041);
        System.out.println(retult);
    }

    public int solution(int N) {
        // write your code in Java SE 8
        String binaryRepresent = Integer.toBinaryString(N);
        return longestUniqueSubsttr(binaryRepresent);
    }

    // Returns length of the longest substring
    // with all distinct characters.
    public static int longestUniqueSubsttr(String str) {
        int n = str.length();

        List<Integer> resultSet = new ArrayList<>();

        // Result
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isZero(str.charAt(i))) {
                count += 1;
            } else {
                resultSet.add(count);
                count = 0;
            }
        }

        Optional<Integer> result = resultSet.stream()
                                            .max(Comparator.naturalOrder());

        return result.orElse(0);
    }

    public static Boolean isZero(char figure) {
        return figure == '0';
    }

    // This function returns true if all characters in
    // str[i..j] are distinct, otherwise returns false
    public static Boolean areDistinct(String str, int i, int j) {

        // Note : Default values in visited are false
        boolean[] visited = new boolean[26];

        for(int k = i; k <= j; k++)
        {
            if (visited[str.charAt(k) - '0'] == true)
                return false;

            visited[str.charAt(k) - '0'] = true;
        }
        return true;
    }

}
