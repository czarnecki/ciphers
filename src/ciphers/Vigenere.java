package ciphers;

public class Vigenere {

    static String encrypt(String text, String key) {

        String encryptedText = "";
        char charCode;
        int charCodeShifted;
        int keyPos = 0;
        text = text.toUpperCase();
        text = text.replaceAll("\\s", "");
        key = key.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            charCode = text.charAt(i);
            if (charCode >= 'A' && charCode <= 'Z') {
                charCodeShifted = charCode + key.charAt(keyPos) - 64;
                keyPos++;
                if (charCodeShifted > 'Z')
                    charCodeShifted -= 26;
                charCode = (char) charCodeShifted;
                if (keyPos == key.length())
                    keyPos = 0;
            }
            encryptedText += charCode;
        }
        return encryptedText;
    }

    static String decipher(String ciphertext, String key) {
        String originalText = "";
        char charCode;
        int charCodeShifted;
        int keyPos = 0;
        key = key.toUpperCase();
        for (int i = 0; i < ciphertext.length(); i++) {
            charCode = ciphertext.charAt(i);
            if (charCode >= 'A' && charCode <= 'Z') {
                charCodeShifted = charCode - (key.charAt(keyPos) - 64);
                keyPos++;
                if (charCodeShifted < 'A')
                    charCodeShifted += 26;
                charCode = (char) charCodeShifted;
            } else if (charCode >= 'a' && charCode <= 'z') {
                charCodeShifted = charCode - (key.charAt(keyPos) - 64);
                keyPos++;
                if (charCodeShifted < 'a')
                    charCodeShifted += 26;
                charCode = (char) charCodeShifted;
            }
            if (keyPos == key.length())
                keyPos = 0;
            originalText += charCode;
        }
        return originalText;
    }
}
