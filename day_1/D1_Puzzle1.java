package day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class D1_Puzzle1 {
    public static void main(String[] args) {
        try {
            int sum = 0;

            // Read the file
            File input = new File("day_1/input.txt");
            Scanner scanner = new Scanner(input);

            // List to store parsed integer arrays
            List<Integer> leftColumn = new ArrayList<>();
            List<Integer> rightColumn = new ArrayList<>();

            // Read each line from the file
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine().trim();

                // Split by whitespace and parse into integers
                String[] parts = data.split("\\s+");

                // Validate and parse each part into integers
                if (parts.length == 2) {
                    try {
                        int first = Integer.parseInt(parts[0]);
                        int second = Integer.parseInt(parts[1]);
                        leftColumn.add(first);
                        rightColumn.add(second);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid line: " + data);
                    }
                } else {
                    System.err.println("Skipping invalid line: " + data);
                }
            }
            scanner.close();

            // Sort both columns independently
            leftColumn.sort(Integer::compareTo); //leftColumn.sort((a, b) -> a - b);
            rightColumn.sort(Integer::compareTo); //rightColumn.sort((a, b) -> a - b);

            // Create two-column format
            int maxSize = Math.max(leftColumn.size(), rightColumn.size());
            for (int i = 0; i < maxSize; i++) {
                int leftValue = Integer.parseInt((i < leftColumn.size()) ? String.valueOf(leftColumn.get(i)) : "");
                int rightValue = Integer.parseInt((i < rightColumn.size()) ? String.valueOf(rightColumn.get(i)) : "");
                // System.out.printf("%-10s %s%n", leftValue, rightValue);

                // Calculate left and right column distance
                int pairDistance = leftValue - rightValue;
                sum = sum + Math.abs(pairDistance);
            }

            System.out.println(sum);

        } catch (FileNotFoundException e) {
            System.err.println("The file was not found.");
        }
    }

}