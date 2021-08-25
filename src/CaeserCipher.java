//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class CaeserCipher {
    private String text;
    private String textEncrypt;
    private String textDecrypt;
    private int shift = 0;
    private static int sizeAlphabet = 26;

    CaeserCipher(String text, int shift) {
        this.text = text;
        this.shift = shift;
        this.textEncrypt = encrypt(this.text.toLowerCase(), shift);
        this.textDecrypt = decrypt(this.textEncrypt, shift);
        this.writeResult();
    }

    public String getEncrypt() {
        return this.textEncrypt;
    }

    public String getDecrypt() {
        return this.textDecrypt;
    }

    public void writeResult() {
        System.out.println("\tШифр Цезаря:");
        System.out.println(" Текст > " + this.text);
        System.out.println(" Зсув > " + this.shift);
        System.out.println(" Зашифрований текст > " + this.textEncrypt);
        System.out.println(" Дешифрований текст > " + this.textDecrypt);
        System.out.println();
    }

    private static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        char[] var3 = text.toCharArray();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char c = var3[var5];
            if (c == ' ' | c == '.' | c == ',' | c == '\'' | c == '!' | c == '?' | c == '-' | c == ':' | c == ';' | c == '(' | c == ')' | c == '\n') {
                result.append(c);
            } else {
                int originalAlphabetPosition = c - 97;
                int newAlphabetPosition = (originalAlphabetPosition + shift) % sizeAlphabet;
                char newCharacter = (char)(97 + newAlphabetPosition);
                result.append(newCharacter);
            }
        }

        return result.toString();
    }

    private static String decrypt(String text, int shift) {
        return encrypt(text, sizeAlphabet - shift % sizeAlphabet);
    }
}
