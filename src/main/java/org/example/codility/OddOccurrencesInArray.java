package org.example.codility;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] ex = {9, 3, 9, 3, 9, 7, 9};
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int result = oddOccurrencesInArray.solution(ex);
        System.out.println(result);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        // write your code in Java SE 8
        int elem = 0;

        for (int i = 0; i < A.length; i++) {
            elem ^= A[i];
        }
        return elem;


//        HashSet<Integer> dups = new HashSet<>();
//        int elem = -1;
//
//        for (int i = 0; i < A.length; i++) {
//            if (dups.add(A[i])) {
//                elem = A[i];
//            }
//        }
//        return elem;


        // write your code in Java SE 8
        //return findUnpaired(convertIntToInteger(A));
    }

//    private int findUnpaired(List<Integer> data) {
//        Set<Integer> cash = new HashSet<>();
//        if (data != null && !data.isEmpty()) {
//            for (int i = 0; i < data.size(); i++) {
//                Integer value = data.get(i);
//                if (!cash.isEmpty()) {
//                    if (!cash.contains(value)) {
//                        cash.add(value);
//                        if (getCount(data, value) == 1) {
//                            return value;
//                        }
//                    }
//                } else {
//                    cash.add(value);
//                    if (getCount(data, value) == 1) {
//                        return value;
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//
//    private long getCount(List<Integer> data, Integer number) {
//        return data.stream()
//                    .filter(value -> value.equals(number))
//                    .count();
//    }
//
//    private List<Integer> convertIntToInteger(int[] a) {
//        List<Integer> result = new LinkedList<>();
//        for (int value : a) {
//            result.add(value);
//        }
//        return result;
//    }

}
