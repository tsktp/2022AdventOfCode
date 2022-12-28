package day03;
import day03.Part01;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Part02 {
	public static void main(String[] args) throws Exception {
		int score = 0;
		String[] data = Part01.readFile("day03/input.txt");

		for (int i = 0; i < data.length/3; i++) {
			HashSet<Character> first = Part01.intoHashSet(data[i*3]);
			String compFirst = contains(first, data[(i*3)+1]);

			HashSet<Character> second = Part01.intoHashSet(compFirst);
			String compSecond = contains(second, data[(i*3)+2]);

			score += Part01.priority(compSecond.charAt(0));
		}

		System.out.println(score);
		
	}

	public static String contains(HashSet<Character> one, String two){
		StringBuilder charList = new StringBuilder();

		for (int i = 0; i < two.length(); i++) {
			if (one.contains(two.charAt(i))) {
				charList.append(two.charAt(i));
			}
		}

		return charList.toString(); 
	}
}
