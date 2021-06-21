package org.example.codility;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CodilityTest {

    public static void main(String[] args) {

    }

    public int solution(int[] a) {
        List<Integer> data = convertIntToInteger(a);
        // write your code in Java SE 8
        if (data != null && !data.isEmpty()) {
            List<Integer> positiveData = retrievePositiveFigures(data);
            if (!positiveData.isEmpty()) {
                Integer result = positiveData.stream()
                                             .max(Integer::compare)
                                             .get();
                Integer expectedNegativeCase = result - 1;
                Integer expectedPositiveCase = result + 1;
                if (isFigure(positiveData, expectedNegativeCase)) {
                    return expectedPositiveCase;
                } else if (!isFigure(positiveData, expectedNegativeCase)) {
                    return expectedNegativeCase;
                }

                return result;
            } else {
                return 1;
            }
        }
        return 0;
    }

    private boolean isFigure(List<Integer> data, Integer expected) {
        return data.stream()
                   .anyMatch(figure -> figure.equals(expected));
    }

    private List<Integer> retrievePositiveFigures(List<Integer> data) {
        return data.stream()
                   .filter(figure -> figure > 0)
                   .collect(toList());
    }

    private List<Integer> convertIntToInteger(int[] a) {
        List<Integer> result = new ArrayList<>();
        for (int value : a) {
            result.add(value);
        }
        return result;
    }

}

//class Solution {
//    public int solution(int[] A) {
//        // write your code in Java SE 8
//    }
//}
