package org.example.codility;

import java.util.LinkedList;
import java.util.List;

public class CyclicRotation {

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] arg = {3, 8, 9, 7, 6};
        int[] result = cyclicRotation.solution(arg, 3);
    }

    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> data = (LinkedList<Integer>) convertIntToInteger(A);

        for (int i = 0; i < K; i++) {
            Integer value = data.getLast();
            data.addFirst(value);
            data.removeLast();
        }
        int[] result = new int[A.length];

        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }

        return result;
    }

    private List<Integer> convertIntToInteger(int[] a) {
        List<Integer> result = new LinkedList<>();
        for (int value : a) {
            result.add(value);
        }
        return result;
    }

}
