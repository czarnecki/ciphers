package ciphers;

public class Caesar {
	
	static String encrypt(String text, int key) {
		
		String encryptedText = "";
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
			encryptedText += charCode;
		}
		return encryptedText;
	}
}