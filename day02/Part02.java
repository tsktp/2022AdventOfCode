package day02;
import day02.Part01;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/***
 * A = ROCK      (1)
 * B = PAPER     (2)
 * C = SCISSORS  (3)
 * 
 * X = LOSE
 * Y = TIE
 * Z = WIN
 * 
 * LOSE             (0)
 * TIE              (3)
 * WIN              (6)
 * 
 * score = move + condition
 */
public class Part02 {
	public static void main(String[] args) throws Exception{
		int score = 0;
		String[] tournament = Part01.readFile("day02/input.txt");
		
		for(String i: tournament) {
			score += result(i) + move(i);
		}

		System.out.println(score);
	}

	public static int result(String round) {
		if(round.charAt(2) == 'X') {
			return 0;
		}

		if(round.charAt(2) == 'Y') {
			return 3;
		}

		return 6;
	}

	public static int move(String round) throws Exception{
		String[] play = round.split(" ");
		String opponent = play[0];
		String player = play[1];

		// lose
		if(player.equals("X")) {
			if (opponent.equals("A")) {
				return 3;
			}

			if (opponent.equals("B")) {
				return 1;
			}

			return 2;
		}

		if(player.equals("Y")) {
			if (opponent.equals("A")) {
				return 1;
			}

			if (opponent.equals("B")) {
				return 2;
			}

			return 3;
		}

		if(player.equals("Z")) {
			if (opponent.equals("A")) {
				return 2;
			}

			if (opponent.equals("B")) {
				return 3;
			}

			return 1;
		}

		throw new Exception("Reached End Condition");
	}
}
