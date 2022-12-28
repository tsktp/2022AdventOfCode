package day04;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Part01 {
    public static void main(String[] args) throws Exception {
		String[] pairs = readFile("day04/input.txt");
		int duplicate = 0;
        
		for (String s: pairs) {
			String[] sections = split(s);
			String leftSections = sections[0];
			String rightSections = sections[1];

			String[] ints = sections[0].split("-");
			int ll = Integer.parseInt(ints[0]);
			int lr = Integer.parseInt(ints[1]);

			ints = sections[1].split("-");
			int rl = Integer.parseInt(ints[0]);
			int rr = Integer.parseInt(ints[1]);

			if (range(leftSections) > range(rightSections)) {
				if (ll <= rl && lr >= rr) {
					duplicate += 1;
				}
			} else if (range(leftSections) < range(rightSections)) {
				if (ll >= rl && lr <= rr) {
					duplicate += 1;
				}
			} else {
				if (ll == rl && lr == rr) {
					duplicate += 1;
				}
			}
		}

		System.out.println(duplicate);
    }

	public static int range(String data) {
		String[] ints = data.split("-");
		int left = Integer.parseInt(ints[0]);
		int right = Integer.parseInt(ints[1]);

		return Math.abs(right - left);
	}

	public static String[] split(String data) {
		return data.split(",");
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
