project2/
│
├── src/
│   └── Main.java
│
├── test/
│   └── MainTest.java
│
├── .gitignore
├── README.md
└── pom.xml
package test;

import main.Main;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testGetEvenNumbers() {
        List<Integer> inputList = List.of(1, 2, 4, 5, 8, 10, 15);
        List<Integer> expected = List.of(2, 4, 8, 10);

        assertEquals(expected, Main.getEvenNumbers(inputList));
    }

    @Test
    void testConvertToUpperCase() {
        String input = "hello";
        String expected = "HELLO";

        assertEquals(expected, Main.convertToUpperCase(input));
    }

    @Test
    void testFindLongestString() {
        List<String> inputStrings = List.of("apple", "orange", "banana", "watermelon");
        String expected = "watermelon";

        assertEquals(expected, Main.findLongestString(inputStrings));
    }

    @Test
    void testFindLongestStringWithEmptyList() {
        List<String> inputStrings = List.of();
        String expected = "";

        assertEquals(expected, Main.findLongestString(inputStrings));
    }
}
2. Main.java (Application Logic)
The functions are implemented here:

java
Copy code
package main;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * Returns a list of all even numbers from the provided list.
     * @param numbers List of integers to process.
     * @return List of even integers.
     */
    public static List<Integer> getEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    /**
     * Converts all characters of the given string to uppercase.
     * @param input Input string.
     * @return String in uppercase.
     */
    public static String convertToUpperCase(String input) {
        return input.toUpperCase();
    }

    /**
     * Finds and returns the longest string in a provided list of strings.
     * @param strings List of strings to search.
     * @return The longest string. If the list is empty, returns an empty string.
     */
    public static String findLongestString(List<String> strings) {
        return strings.stream()
                .max((a, b) -> Integer.compare(a.length(), b.length()))
                .orElse("");
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(getEvenNumbers(List.of(1, 2, 4, 5, 8, 10)));
        System.out.println(convertToUpperCase("hello"));
        System.out.println(findLongestString(List.of("apple", "orange", "banana", "watermelon")));
    }
}