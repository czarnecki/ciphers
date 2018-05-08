package ciphers;

public class Vigenere {
		
	static String encrypt(String text, String key) {
		
		String encryptedText = "";
		char charCode;
		int charCodeShifted;
		int keypos = 0;
		text = text.toUpperCase();
		text = text.replaceAll("\\s", "");
		key = key.toUpperCase();
		for (int i = 0; i < text.length(); i++) {
			charCode = text.charAt(i);
			if (charCode >= 'A' && charCode <= 'Z') {
				charCodeShifted = charCode + key.charAt(keypos) - 64;
				keypos++;
				if (charCodeShifted > 'Z') {
					charCodeShifted -= 26;
				}
				charCode = (char) charCodeShifted;
				if (keypos == key.length()) {
					keypos = 0;
				}
			}
			encryptedText += charCode;
		}
		return encryptedText;
	}
}