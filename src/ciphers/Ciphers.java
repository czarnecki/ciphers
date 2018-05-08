package ciphers;

import java.util.Scanner;

public class Ciphers {
	
	static Scanner scanInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("  1) Caesar  2) Vigenere");
		System.out.println();
		System.out.print("Enter a selection: ");
		while (!scanInput.hasNextInt()) {
			System.out.println(scanInput.nextLine() + " is not a valid input");
			System.out.print("Enter a selection: ");
		}
		int cipherChoice = scanInput.nextInt();
		scanInput.nextLine();
		String text = " ";
		int intKey;
		String stringKey;
		switch (cipherChoice) {
		case 1:
			System.out.print("Text to cipher: ");
			text = scanInput.nextLine();
			System.out.print("Shift amout: ");
			while (!scanInput.hasNextInt()) {
				System.out.println(scanInput.nextLine() + " is not a valid input");
				System.out.print("Shift amount: ");
			}
			intKey = scanInput.nextInt();
			System.out.println(Caesar.encrypt(text, intKey));
			break;
		case 2:
			System.out.print("Text to cipher: ");
			text = scanInput.nextLine();
			System.out.print("Key as string: ");
			stringKey = scanInput.nextLine();
			while(!stringKey.matches("[A-Za-z]*")) {
				System.out.println(stringKey + " is not a valid key");
				System.out.print("Key as string: ");
				stringKey = scanInput.nextLine();
			}
			System.out.println(Vigenere.encrypt(text, stringKey));
			break;
		}
	}
}
