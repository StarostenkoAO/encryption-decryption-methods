public class Main {
    public static void main(String[] args) {
        new TranspositionCipher("No one can make you feel inferior without your consent. Eleanor Roosevelt");
        new ColumnarTranspositionCipher("Genius is one percent inspiration and ninety-nine percent perspiration.\n\t Thomas Edison", "star");
        new CaeserCipher("Work hard to get what you like, otherwise you'll be forced to just like what you get.\n Bernard Show", 13);
        new GronsfeldCipher("And now here is my secret, a very simple secret:\n it's only with the heart that one can see rightly, what is essential is invisible to the eye.\n (The Little Prince, Antoine de Saint-Exupery)", new int[]{1, 1, 8, 9, 3, 5, 9, 9});
        new MonoalphabeticCipher("The weak can never forgive. Forgiveness is the attribute of the strong.\n Mahatma Gandhi");
    }
}
