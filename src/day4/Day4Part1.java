package day4;

import java.util.HashSet;
import java.util.Set;

public class Day4Part1 {

    static Integer start = 236491;
    static Integer end = 713787;
    static Set<Integer> result = new HashSet();

    public static void main() {
        for (int i = start; i <= end; i++) {
            String[] signs = String.valueOf(i).split("");
            if (checkIfIncreasing(signs)) result.add(i);
        }
        System.out.println(result.size());
    }

    static Boolean checkIfIncreasing(String[] signs) {
        boolean increasingResult = true;
        boolean sameResult = false;
        for (int j = 0; j < signs.length - 1; j++) {
            if (Integer.valueOf(signs[j]) > Integer.valueOf(signs[j + 1])) increasingResult = false;
            if (Integer.valueOf(signs[j]).equals(Integer.valueOf(signs[j + 1]))) sameResult = true;
        }
        return increasingResult && sameResult;
    }

}
