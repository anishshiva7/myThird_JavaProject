public class StringMethodsDemo {
    public static void main(String[] args) {
        String original = "abcde";

        for (int i = 0; i < original.length(); i++) {
            System.out.println("the character at index " + i + " is " + original.charAt(i));
        }

        System.out.println("the letter 'a' is at index " + original.indexOf('a'));
        System.out.println("the letter 'e' is at index " + original.indexOf('e'));
        System.out.println("the letter 'A' is at index " + original.indexOf('A'));

        original = original.toUpperCase();

        System.out.println(original);
        System.out.println("the letter 'A' is at index " + original.indexOf('A'));
        String s = "hello world";
        char result = s.charAt(5);
        System.out.println(result);

    }
}
