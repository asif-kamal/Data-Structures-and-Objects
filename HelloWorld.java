public class HelloWorld {

    public static void main(String[] args) {
        // System.out.println("Hello, world!");

        String words[] = new String[] { "money", "position", "sex", "animal", "drives", "four" };
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 4) {
                System.out.println(word);
            }

        }
    }

}
