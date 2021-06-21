package org.example.codility;

public class FrogJmp {

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
//        int result = frogJmp.solution(10, 85, 30);
        int result = frogJmp.solution(5, 105, 3);
        System.out.println("result = " + result);
    }

    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        int count = distance / D;
        if (distance % D > 0) {
            count++;
        }
        return count;


        // write your code in Java SE 8
//        int distance = Y - X;
//        if (distance <= 0) {
//            return 0;
//        } else {
//            int remainder = distance % D;
//            if (remainder > 1) {
//                return (((Y - remainder) / D) + 1);
//            } else {
//                return (Y - remainder) / D;
//            }
//        }
    }

}
