package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3Part2 {

    static Map<Node, Integer> firstWireNodesMap = new HashMap<>();
    static Map<Node, Integer> matchingNodesMap = new HashMap<>();
    static Integer stepa = 0;
    static Integer stepb = 0;

    public static void main() {
        List<String[]> input = readFile();
        fillNodeList(input.get(0));
        fillIMatchingNodes(input.get(1));
        int min = matchingNodesMap.values().stream().min(Integer::compareTo).orElse(0);
        System.out.println(min);
    }

    private static void fillNodeList(String[] input) {
        Node startingNode = new Node(0, 0);
        for (String move : input) {
            move(Integer.valueOf(move.substring(1)), move.substring(0, 1), startingNode);
        }
    }

    private static void fillIMatchingNodes(String[] input) {
        Node startingNode = new Node(0, 0);
        Integer step = 0;
        for (String move : input) {
            moveAndCheck(Integer.valueOf(move.substring(1)), move.substring(0, 1), startingNode);
        }
    }

    static void move(Integer way, String direction, Node node) {
        for (int i = 0; i < way; i++) {
            moveNode(direction, node);
            stepa++;
            firstWireNodesMap.put(new Node(node), stepa);
        }
    }

    private static void moveNode(String direction, Node node) {
        if (direction.equals("R")) {
            node.y = node.y + 1;
        }
        if (direction.equals("L")) {
            node.y = node.y - 1;
        }
        if (direction.equals("U")) {
            node.x = node.x + 1;
        }
        if (direction.equals("D")) {
            node.x = node.x - 1;
        }
    }

    static void moveAndCheck(Integer way, String direction, Node node) {
        for (int i = 0; i < way; i++) {
            moveNode(direction, node);
            stepb++;
            Node newNode = new Node(node);
            if (firstWireNodesMap.containsKey(newNode)) {
                matchingNodesMap.put(newNode, stepb + firstWireNodesMap.get(newNode));
            }
        }
    }

    static List<String[]> readFile() {
        List<String[]> input = new ArrayList();
        try {
            File file = new File("src/day3/3.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.next();
                input.add(line.split(","));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node(Node node) {
            this.x = node.x;
            this.y = node.y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
