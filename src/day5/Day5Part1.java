package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day5Part1 {
    public static void main() {
        Integer output = 0;
        List<Integer> inputList = readFile();
        for (int i = 0; i < inputList.size(); i++) {
            int r = Math.floorMod(inputList.get(i), 100);
            int firstMode = Math.floorMod((inputList.get(i) / 100), 10);
            int secondMode = Math.floorMod((inputList.get(i) / 1000), 10);
            switch (r) {
                case 1:
                    add(inputList, firstMode == 0 ? inputList.get(i + 1) : i + 1, secondMode == 0 ? inputList.get(i + 2) : i + 2, inputList.get(i + 3));
                    i += 3;
                    break;
                case 2:
                    multiply(inputList, firstMode == 0 ? inputList.get(i + 1) : i + 1, secondMode == 0 ? inputList.get(i + 2) : i + 2, inputList.get(i + 3));
                    i += 3;
                    break;
                case 3:
                    input(inputList, i + 1);
                    i += 1;
                    break;
                case 4:
                    output= inputList.get(inputList.get(i + 1));
                    i += 1;
                    break;
                case 99:
                    System.out.println(output);
                    return;
            }
        }
    }

    static void printResult(List<Integer> result) {
        String resultString = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.print(resultString);
    }

    static void input(List<Integer> list, Integer index) {
        list.set(list.get(index), 1);
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
            File file = new File("src/day5/5.txt");
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
