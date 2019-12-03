package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Part2 {
    public static void main() {
        Long result = 0L;
        for (Integer fuel : readFile()) {
            result += countFuelSum(fuel);
        }
        System.out.println(result);
    }

    private static Integer countFuelSum(Integer fuel) {
        Integer fuelForFuel = fuel / 3 - 2;
        return fuelForFuel > 0 ? fuelForFuel += countFuelSum(fuelForFuel) : 0;
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
