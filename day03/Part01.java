package day03;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Part01 {
	public static void main(String[] args) throws Exception {
		int score = 0;
		String[] data = readFile("day03/input.txt");
		
		for (String s: data) {
			String[] compartments = splitCompartments(s);
			HashSet<Character> compartmentOne = intoHashSet(compartments[0]);
			char both = rucksackContains(compartmentOne, compartments[1]);
			score += priority(both);
		}

		System.out.println(score);
	}

	public static int priority(char c) {
		if (Character.isUpperCase(c)) {
			return (int) c - 38;
		} else {
			return (int) c - 96;
		}
	}

	public static String[] splitCompartments(String data) throws Exception {
		if (data.length() % 2 != 0) {
			throw new Exception("Data not even.");
		}

		StringBuilder compartment1 = new StringBuilder();
		StringBuilder compartment2 = new StringBuilder();

		for (int i = 0; i < data.length()/2; i++){
			compartment1.append(data.charAt(i));
			compartment2.append(data.charAt((data.length()/2) + i));
		}

		return new String[]{compartment1.toString(), compartment2.toString()};

	}

	public static HashSet<Character> intoHashSet(String compartment) {
		HashSet<Character> set = new HashSet<Character>(compartment.length());

		for (int i = 0; i < compartment.length(); i++) {
			set.add(compartment.charAt(i));
		}

		return set;
	}

	public static char rucksackContains(HashSet<Character> data, String compartment2) {
		for (int i = 0; i < compartment2.length(); i++) {
			if (data.contains(compartment2.charAt(i))){
				return compartment2.charAt(i);
			}
		}
		return Character.MIN_VALUE;
	}

	public static String[] readFile(String path) throws FileNotFoundException {
		LinkedList<String> list = new LinkedList<String>();
		File file = new File(path);
		Scanner reader = new Scanner(file);

		while(reader.hasNextLine()) {
			list.add(reader.nextLine());
		}

		reader.close();
		Object[] data = list.toArray();
		return Arrays.copyOf(data, data.length, String[].class);
	}
}
