//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class MonoalphabeticCipher {
    private String text;
    private String textEncrypt;
    private String textDecrypt;
    private static char[] p = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char[] ch = new char[]{'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
    private static int sizeAlphabet = 26;

    MonoalphabeticCipher(String text) {
        this.text = text;
        this.textEncrypt = encrypt(this.text.toLowerCase());
        this.textDecrypt = decrypt(this.textEncrypt);
        this.writeResult();
    }

    public void writeResult() {
        System.out.println("\tШифр багатоалфавітної заміни::");
        System.out.println(" Текст > " + this.text);
        System.out.println(" Зашифрований текст > " + this.textEncrypt);
        System.out.println(" Дешифрований текст > " + this.textDecrypt);
        System.out.println();
    }

    public String getEncrypt() {
        return this.textEncrypt;
    }

    public String getDecrypt() {
        return this.textDecrypt;
    }

    private static String encrypt(String text) {
        char[] c = new char[text.length()];

        for(int i = 0; i < text.length(); ++i) {
            for(int j = 0; j < sizeAlphabet; ++j) {
                if (p[j] == text.charAt(i)) {
                    c[i] = ch[j];
                    break;
                }

                if (text.charAt(i) == ' ' | text.charAt(i) == '.' | text.charAt(i) == ',' | text.charAt(i) == '\'' | text.charAt(i) == '!' | text.charAt(i) == '?' | text.charAt(i) == '-' | text.charAt(i) == ':' | text.charAt(i) == ';' | text.charAt(i) == '(' | text.charAt(i) == ')' | text.charAt(i) == '\n') {
                    c[i] = text.charAt(i);
                }
            }
        }

        return new String(c);
    }

    private static String decrypt(String text) {
        char[] c = new char[text.length()];

        for(int i = 0; i < text.length(); ++i) {
            for(int j = 0; j < sizeAlphabet; ++j) {
                if (ch[j] == text.charAt(i)) {
                    c[i] = p[j];
                    break;
                }

                if (text.charAt(i) == ' ' | text.charAt(i) == '.' | text.charAt(i) == ',' | text.charAt(i) == '\'' | text.charAt(i) == '!' | text.charAt(i) == '?' | text.charAt(i) == '-' | text.charAt(i) == ':' | text.charAt(i) == ';' | text.charAt(i) == '(' | text.charAt(i) == ')' | text.charAt(i) == '\n') {
                    c[i] = text.charAt(i);
                }
            }
        }

        return new String(c);
    }
}