package ciphers;

public class Caesar {
	
	static String encrypt(String text, int key) {
		String cipherText = "";
		char charCode;
		int charCodeShifted;
		text = text.toUpperCase();
		text = text.replaceAll("\\s", "");
		for (int i = 0; i < text.length(); i++) {
			charCode = text.charAt(i);
			if (charCode >= 'A' && charCode <= 'Z') {
				charCodeShifted = charCode + key;
				if (charCodeShifted > 'Z')
					charCodeShifted -= 26;
				charCode = (char) charCodeShifted;
			}
			cipherText += charCode;
		}
		return cipherText;
	}
	
	static String decipher(String cipherText, int key) {
		String originalText = "";
		char charCode;
		int charCodeShifted;
		for (int i = 0; i < cipherText.length(); i++) {
			charCode = cipherText.charAt(i);
			if (charCode >= 'A' && charCode <= 'Z') {
				charCodeShifted = charCode - key;
				if (charCodeShifted < 'A')
					charCodeShifted += 26;
				charCode = (char) charCodeShifted;
			}
			originalText += charCode;
		}
		return originalText;
	}
}