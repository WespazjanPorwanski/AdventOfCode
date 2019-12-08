package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IntcodeComputer {
    List<Integer> inputList = new LinkedList<>();

    public int start(Integer input, Integer secInput) {
        Integer output = 0;
        inputList = readFile();
        int i = 0;
        boolean firstInput = true;
        for (; ; ) {
            int r = Math.floorMod(inputList.get(i), 100);
            int firstMode = Math.floorMod((inputList.get(i) / 100), 10);
            int secondMode = Math.floorMod((inputList.get(i) / 1000), 10);
            int a = inputList.get(i + 1);

            int b = 0, c = 0;
            if (i + 2 < inputList.size())
                b = inputList.get(i + 2);

            if (i + 3 < inputList.size())
                c = inputList.get(i + 3);

            switch (r) {
                case 1:
                    inputList.set(c, getValue(a, firstMode) + getValue(b, secondMode));
                    i += 4;
                    break;
                case 2:
                    inputList.set(c, getValue(a, firstMode) * getValue(b, secondMode));
                    i += 4;
                    break;
                case 3:
                    inputList.set(a,  firstInput ? input : secInput);
                    firstInput = false;
                    i += 2;
                    break;
                case 4:
                    output = getValue(a, firstMode);
                    i += 2;
                    break;
                case 5:
                    if (getValue(a, firstMode) != 0) {
                        i = getValue(b, secondMode);
                    } else {
                        i += 3;
                    }
                    break;
                case 6:
                    if (getValue(a, firstMode) == 0) {
                        i = getValue(b, secondMode);
                    } else {
                        i += 3;
                    }
                    break;
                case 7:
                    inputList.set(c, getValue(a, firstMode) < getValue(b, secondMode) ? 1 : 0);
                    i += 4;
                    break;
                case 8:
                    inputList.set(c, getValue(a, firstMode) == getValue(b, secondMode) ? 1 : 0);
                    i += 4;
                    break;
                case 99:
                    return output;
            }
        }
    }

    int getValue(Integer value, Integer mode) {
        return mode == 1 ? value : inputList.get(value);
    }

    List<Integer> readFile() {
        List<Integer> input = new LinkedList<>();
        try {
            File file = new File("src/day7/7.txt");
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
