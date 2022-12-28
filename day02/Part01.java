package day02;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/***
 * A, X = ROCK      (1)
 * B, Y = PAPER     (2)
 * C, Z = SCISSORS  (3)
 * 
 * LOSE             (0)
 * TIE              (3)
 * WIN              (6)
 * 
 * score = move + condition
 */

public class Part01 {
	public static void main(String[] args) throws FileNotFoundException {
		int score = 0;
		String[] tournament = readFile("day02/input.txt");

		for(String i: tournament) {
			score += getPlayerScore(i) + checkWin(i);
		}

		System.out.println(score);
	}

	public static int getPlayerScore(String round) {
		char player = round.charAt(2);

		if(player == 'X') {
			return 1;
		}

		if(player == 'Y') {
			return 2;
		}

		return 3;
	}

	public static int checkWin(String round) {
		String[] play = round.split(" ");
		String opponent = play[0];
		String player = play[1];

		// tie condition
		if(opponent.equals(player.replace("X", "A").replace("Y", "B").replace("Z", "C"))) {
			return 3;
		}

		// win condition
		if(player.equals("X") && opponent.equals("C")
		|| player.equals("Y") && opponent.equals("A")
		|| player.equals("Z") && opponent.equals("B")) {
			return 6;
		}

		// lose condition
		return 0;
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
