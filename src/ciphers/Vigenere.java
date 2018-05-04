package ciphers;

public class Vigenere {
		
	static String encrypt(String text, String key) {
		
		String encryptedText = "";
		char charCode;
		int charCodeShifted;
		int keypos = 0;
		text = text.toLowerCase();
		text = text.replaceAll("\\s", "");
		for (int i = 0; i < text.length(); i++) {
			charCode = text.charAt(i);
			if (charCode >= 'a' && charCode <= 'z') {
				charCodeShifted = charCode + key.charAt(keypos) - 64;
				keypos++;
				if (charCodeShifted > 'z') {
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