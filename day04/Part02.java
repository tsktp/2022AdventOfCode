package day04;
import day04.Part01;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Part02 {
	public static void main(String[] args) throws Exception {
		String[] pairs = Part01.readFile("day04/input.txt");
		int duplicate = 0;
        
		for (String s: pairs) {
			String[] sections = Part01.split(s);
			String leftSections = sections[0];
			String rightSections = sections[1];

			String[] ints = sections[0].split("-");
			int ll = Integer.parseInt(ints[0]);
			int lr = Integer.parseInt(ints[1]);

			ints = sections[1].split("-");
			int rl = Integer.parseInt(ints[0]);
			int rr = Integer.parseInt(ints[1]);

			List<Integer> rangeLeft = IntStream.rangeClosed(ll, lr).boxed().collect(Collectors.toList());
			List<Integer> rangeRight = IntStream.rangeClosed(rl, rr).boxed().collect(Collectors.toList());
			
			for (Integer i: rangeLeft) {
				if (rangeRight.contains(i)) {
					duplicate += 1;
					break;
				}
			}
		}

		System.out.println(duplicate);
    }
}
