package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Part1 {
    public static void main() {
        int result = 0;
        for (Integer fuel : readFile()) {
            result += fuel / 3 - 2;
        }
        System.out.println(result);
    }

    static List<Integer> readFile() {
        List<Integer> input = new ArrayList();
        try {
            File file = new File("src/day1/1.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                int i = sc.nextInt();
                input.add(i);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }
}
