package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Day2Part1 {

    public static void main() {
        List<Integer> inputList = readFile();
        for (int i = 0; i < inputList.size(); i++) {
            switch (inputList.get(i)) {
                case 1:
                    add(inputList, inputList.get(i + 1), inputList.get(i + 2), inputList.get(i + 3));
                    i += 3;
                    break;
                case 2:
                    multiply(inputList, inputList.get(i + 1), inputList.get(i + 2), inputList.get(i + 3));
                    i += 3;
                    break;
                case 99:
                    printResult(inputList);
                    return;
            }
        }
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
