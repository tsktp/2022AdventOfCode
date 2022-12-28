package day01;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String[] data = readFile("day01/input.txt");
		Integer[] elfCalories = parseData(data);
		Arrays.sort(elfCalories);

		//String result = findMax(elfCalories);
		System.out.println(elfCalories[elfCalories.length-1]);
		System.out.println(elfCalories[elfCalories.length-1] + elfCalories[elfCalories.length-2] + elfCalories[elfCalories.length-3]);

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

	public static Integer[] parseData(String[] data) {
		LinkedList<Integer> elfCalories = new LinkedList<Integer>();
		int calories = 0;

		for(int i = 0; i < data.length; i++) {
			if(data[i].equals("")) {
				elfCalories.add(calories);
				calories = 0;
			} else {
				calories += Integer.parseInt(data[i]);
			}
		}

		Object[] ret = elfCalories.toArray();
		return Arrays.copyOf(ret, ret.length, Integer[].class);
	}
}