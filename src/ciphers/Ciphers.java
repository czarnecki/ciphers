package ciphers;

import java.util.Scanner;

public class Ciphers {
	
	static Scanner scanInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		int cipherChoice;
		System.out.println("  1) Caesar  2) Vigenere");
		System.out.println();
		cipherChoice = takeChoiceInt("Enter a selection: ");
		System.out.println();
		switch (cipherChoice) {
		case 1:
			caesarChoice();
			break;
		case 2:
			vigenereChoice();
			break;
		}
	}
	
	private static void caesarChoice() {
		System.out.println("  1) Cipher  2) Decipher");
		System.out.println();
		switch (takeChoiceInt("Enter a selection: ")) {
		case 1:
			String text;
			int intKey;
			System.out.print("Text to cipher: ");
			text = scanInput.nextLine();
			intKey = takeChoiceInt("Shift amount: ");
			System.out.println(Caesar.encrypt(text, intKey));
			break;
		case 2:
			String cipherText;
			int cipherKey;
			System.out.print("Ciphertext: ");
			cipherText = scanInput.nextLine();
			cipherKey = takeChoiceInt("Used key: ");
			System.out.println(Caesar.decipher(cipherText, cipherKey));
			break;
		
		}
	}
	
	private static void vigenereChoice() {
		System.out.println("  1) Cipher 2) Decipher");
		System.out.println();
		switch (takeChoiceInt("Enter a selection: ")) {
		case 1:
			String text;
			String stringKey;
			System.out.print("Text to cipher: ");
			text = scanInput.nextLine();
			System.out.print("Key as string: ");
			stringKey = scanInput.nextLine();
			while(!stringKey.matches("[A-Za-z]+")) {
				System.out.println(stringKey + " is not a valid key");
				System.out.print("Key as string: ");
				stringKey = scanInput.nextLine();
			}
			System.out.println(Vigenere.encrypt(text, stringKey));
			break;
		case 2:
			String cipherText;
			String cipherKey;
			System.out.print("Ciphertext: ");
			cipherText = scanInput.nextLine();
			System.out.print("Key as string: ");
			cipherKey = scanInput.nextLine();
			while(!cipherKey.matches("[A-Za-z]+")) {
				System.out.println(cipherKey + " is not a valid key"); 
				System.out.print("Key as string: ");
				cipherKey = scanInput.nextLine();
			}
			System.out.println(Vigenere.decipher(cipherText, cipherKey));
			break;
		}
	}

	private static int takeChoiceInt(String response) {
		int intSelection;
		System.out.print(response);
		while (!scanInput.hasNextInt()) {
			System.out.println(scanInput.nextLine() + " is not a valid input");
			System.out.print(response);
		}
		intSelection = scanInput.nextInt();
		scanInput.nextLine();
		return intSelection;
	}
}
