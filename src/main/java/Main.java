import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ondrej.hosek
 */
public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static int INVALID_INPUT = -1;

	public Main() throws IOException {
	}

	/**
	 * Read one integer. If given input cannot be converted to integer,
	 * prints error and return -1;
	 *
	 * @return Integer read or -1 if invalid input entered
	 */
	public static int safeReadInt() {
		int result = INVALID_INPUT;
		String inputText = scanner.nextLine();
		try {
			result = Integer.parseInt(inputText);
		} catch (NumberFormatException ex) {
			System.err.println("Zadal jsi text, který nelze převést na celé číslo: " + inputText);
		}
		return result;
	}

	private static ArrayList<Integer> multiValuesReader() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lines = br.readLine();

		String[] strs = lines.trim().split("\\s+");
		ArrayList<Integer> values = new ArrayList<>();

		for (int i = 0; i < strs.length; i++) {
			Integer a = Integer.parseInt(strs[i]);
			values.add(a);
		}
		return values;
	}

	/**
	 * Example of use of {@link Main#safeReadInt()}
	 * <p>
	 * Read one integer from input and print it to output
	 *
	 * @return integer from input
	 */
	public static void readOneIntFromInputAndPrintIt() {
		System.out.println("Zadej číslo: ");
		int input = safeReadInt();
		System.out.println("Zadal jsi: " + input);
	}

	/**
	 * Read integers from input and print them until negative
	 * input.
	 */
	public static void readIntsFromInputAndPrintItUntilNegative(ArrayList<Integer> inputs) throws IOException {
//		with if
		for (Integer input : inputs) {
			if (input != null && input >= 0) {
				System.out.println(input);
			} else return;
		}
//		TODO: with do while loop
	}

	/**
	 * Sum all input numbers (negative number terminates reading) and return result.
	 *
	 * @return Sum of input numbers.
	 */
	public static Integer sumAllInputUntilNegative(ArrayList<Integer> list) {
		int finalValue = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= 0) {
				int value = list.get(i);
				finalValue += value;
			} else return finalValue;
		}
		return finalValue;
	}

	/**
	 * Store all input numbers in ArrayList (negative number terminates reading)
	 *
	 * @return ArrayList of read values (terminating negative value is included)
	 */
	public static void storeAllInputInArrayListUntilNegative(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= 0) {
				System.out.println(list.get(i));
			} else return;
		}
	}

	/**
	 * Print all integers from given list.
	 *
	 * @param list List of integers to print.
	 */
	private static void printAllIntegersFromList(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static Integer sumAllIntegersFromList(ArrayList<Integer> list) {
		int finalValue = 0;
		for (int i = 0; i < list.size(); i++) {
			int value = list.get(i);
			finalValue += value;
		}
		return finalValue;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Insert numbers: ");
		ArrayList<Integer> inputs = multiValuesReader();

		// Example
		System.out.println("--- Example - read and print one number ---");
//		readOneIntFromInputAndPrintIt();
		// ---
		System.out.println("--- Task 1 - read and print until negative ---");
		readIntsFromInputAndPrintItUntilNegative(inputs);
		// ---
		System.out.println("--- Task 2 - sum all until negative ---");
		System.out.println("Celkový součet je: " + sumAllInputUntilNegative(inputs));
		;
		// ---
		System.out.println("--- Task 3 - read to list until negative ---");
		storeAllInputInArrayListUntilNegative(inputs);
		// ---
		System.out.println("--- Task 4 - print all from list ---");
		printAllIntegersFromList(inputs);
		// ---
		System.out.println("--- Task 5 - sum all from list ---");
		System.out.println("Celkový součet je: " + sumAllIntegersFromList(inputs));
	}
}
