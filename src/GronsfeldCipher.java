//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class GronsfeldCipher {
    private String text;
    private String textEncrypt;
    private String textDecrypt;
    private int[] cipherKey;
    private static int sizeAlphabet = 26;
    private static String keyToOut = "";

    GronsfeldCipher(String text, int[] cipherKey) {
        this.text = text;
        this.cipherKey = new int[this.text.length()];

        for(int i = 0; i < cipherKey.length; ++i) {
            this.cipherKey[i] = cipherKey[i];
            keyToOut = keyToOut + cipherKey[i];
        }

        this.generateKey(this.text.toLowerCase(), cipherKey.length);
        if (this.text.length() == this.cipherKey.length) {
            this.textEncrypt = encrypt(this.text.toLowerCase(), this.cipherKey);
            this.textDecrypt = decrypt(this.textEncrypt, this.cipherKey);
            this.writeResult();
        } else {
            System.out.println("\nLength of key cannot be greater than the length of text!");
        }

    }

    public String getEncrypt() { return this.textEncrypt; }

    public String getDecrypt() {
        return this.textDecrypt;
    }

    public void writeResult() {
        System.out.println("\tШифр Гронсфельда:");
        System.out.println(" Текст > " + this.text);
        System.out.println(" Ключ шифрування > " + keyToOut);
        System.out.println(" Зашифрований текст > " + this.textEncrypt);
        System.out.println(" Дешифрований текст > " + this.textDecrypt);
        System.out.println();
    }

    private void generateKey(String str, int period) {
        for(int i = 0; i < this.cipherKey.length; ++i) {
            if (i < period) {
                this.cipherKey[i + period] = this.cipherKey[i];
            } else if (i + period < this.cipherKey.length) {
                this.cipherKey[i + period] = this.cipherKey[i - period];
            }
        }

    }

    public static String encrypt(String text, int[] key) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == ' ' | text.charAt(i) == '.' | text.charAt(i) == ',' | text.charAt(i) == '\'' | text.charAt(i) == '!' | text.charAt(i) == '?' | text.charAt(i) == '-' | text.charAt(i) == ':' | text.charAt(i) == ';' | text.charAt(i) == '(' | text.charAt(i) == ')' | text.charAt(i) == '\n') {
                result.append(text.charAt(i));
            } else {
                int originalAlphabetPosition = text.charAt(i) - 97;
                int newAlphabetPosition = (originalAlphabetPosition + key[i]) % sizeAlphabet;
                char newCharacter = (char)(97 + newAlphabetPosition);
                result.append(newCharacter);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int[] key) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < text.length() && i < key.length; ++i) {
            if (text.charAt(i) == ' ' | text.charAt(i) == '.' | text.charAt(i) == ',' | text.charAt(i) == '\'' | text.charAt(i) == '!' | text.charAt(i) == '?' | text.charAt(i) == '-' | text.charAt(i) == ':' | text.charAt(i) == ';' | text.charAt(i) == '(' | text.charAt(i) == ')' | text.charAt(i) == '\n') {
                result.append(text.charAt(i));
            } else {
                int originalAlphabetPosition = text.charAt(i) - 97;
                int newAlphabetPosition = (originalAlphabetPosition - key[i] + 26) % sizeAlphabet;
                char newCharacter = (char)(97 + newAlphabetPosition);
                result.append(newCharacter);
            }
        }

        return result.toString();
    }
}
