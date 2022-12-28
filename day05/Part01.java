package day05;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Part01 {
	public static void main(String[] args) throws Exception {
		String[] stackFile = readFile("day05/stack.txt");
		String[] cases = printCases(stackFile);
		char[][] charStack = createArray(cases);
		Stack<Character>[] stack = createStack(charStack);

		String[] moveFile = readFile("day05/moves.txt");
		// line {qty, src, dst}
		int[][] moves = parseMoves(moveFile);

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i][0]; j++) {
				stack[(moves[i][2]-1)].push(stack[(moves[i][1]-1)].pop());
			}
		}

		printStack(stack);
	}

	public static Stack<Character>[] createStack(char[][] data) {
		Stack<Character>[] stack = new Stack[data.length];

		for(int i = 0; i < stack.length; i++) {
			stack[i] = new Stack<Character>();
		}

		for (int i = data.length-1; i >= 0 ; i--) {
			for (int j = data[i].length-1; j >= 0 ; j--) {
				if (Character.isUpperCase(data[i][j])) {
					stack[i].push(data[i][j]);
				}
			}
		}

		return stack;
	}

	public static char[][] createArray(String[] data) {
		// 8 = height
		// 9 = stack
		char[][] reverseStack = new char[9][8];
		//char[][] reverseStack = new char[3][3];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length(); j++) {
				if (data[i].charAt(j) != ' ') {
					reverseStack[j][i] = data[i].charAt(j);
				}
			}
		}

		return reverseStack;
	}

	public static int[][] parseMoves(String[] data) throws NumberFormatException {
		int[][] moves = new int[data.length][3];

		for (int i = 0; i < data.length; i++) {
			String[] split = data[i].split(" ");
			moves[i][0] = Integer.parseInt(split[1]);
			moves[i][1] = Integer.parseInt(split[3]);
			moves[i][2] = Integer.parseInt(split[5]);
		}

		return moves;
	}

	public static void printStack(Stack<Character>[] stack){
		for (int i = 0; i < stack.length; i++) {
			System.out.print("Stack " + (i+1) + ": ");

			while(!stack[i].empty()) {
				System.out.print(stack[i].pop());
			}

			System.out.println();
		}
	}

	public static void printArrayStack(char[][] data){
		for (int i = 0; i < data.length; i++) {
			System.out.print("Stack " + (i+1) + ": ");
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}

	public static String[] printCases(String[] data) {
		String[] ret = new String[data.length-1];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < data.length-1; i++) {
			for (int j = 1; j < data[i].length(); j += 4) {
				sb.append(data[i].charAt(j));
			}
			ret[i] = sb.toString();
			sb.setLength(0);
		}

		return ret;
	}

	public static String[] readFile(String path) throws FileNotFoundException {
		LinkedList<String> list = new LinkedList<String>();
		File file = new File(path);
		Scanner reader = new Scanner(file);

		while (reader.hasNextLine()) {
			list.add(reader.nextLine());
		}

		reader.close();
		Object[] data = list.toArray();
		return Arrays.copyOf(data, data.length, String[].class);
	}

}