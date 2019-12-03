package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day2Part2 {
    static List<Integer> inputList = new LinkedList<>();

    public static void main() {
        inputList = readFile();
        for (int x = 1; x < 100; ++x) {
            for (int y = 1; y < 100; ++y) {
                if (returnFirstValue(x, y) == 19690720) {
                    System.out.println(100 * x + y);
                }
            }
        }
    }

    static int returnFirstValue(int x, int y) {
        List<Integer> cloned = new LinkedList(inputList);
        cloned.set(1, x);
        cloned.set(2, y);
        for (int i = 0; i < cloned.size(); i++) {
            switch (cloned.get(i)) {
                case 1:
                    add(cloned, cloned.get(i + 1), cloned.get(i + 2), cloned.get(i + 3));
                    i += 3;
                    break;
                case 2:
                    multiply(cloned, cloned.get(i + 1), cloned.get(i + 2), cloned.get(i + 3));
                    i += 3;
                    break;
                case 99:
                    return cloned.get(0);
            }
        }
        return cloned.get(0);
    }

    static void printResult(List<Integer> result) {
        String resultString = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.print(resultString);
    }

    static void add(List<Integer> list, Integer add1, Integer add2, Integer sumPosition) {
        list.set(sumPosition, list.get(add1) + list.get(add2));
    }

    static void multiply(List<Integer> list, Integer add1, Integer add2, Integer multiplyPosition) {
        list.set(multiplyPosition, list.get(add1) * list.get(add2));
    }

    static List<Integer> readFile() {
        List<Integer> input = new LinkedList<>();
        try {
            File file = new File("src/day2/2.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.next();
                String[] strings = i.split(",");
                for (String s : strings) input.add(Integer.valueOf(s));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    }

}
