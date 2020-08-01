import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to encrypt? ");
        String text = input.nextLine();

        System.out.println("What would you like your value to be for the string? ");
        int shiftValue = input.nextInt();

        System.out.println("What size groups would you like the text split into? ");
        int sizeGroups = input.nextInt();

        System.out.println("Here is your text: ");
    }

    public static String normalizeText(String normal) {
        normal = normal.replaceAll("\\s", " ");
        normal = normal.replaceAll("\\p{Punct}", " ");
        normal = normal.toUpperCase();
        return normal;
    }

    public static String obifiedText(String normal) {
        String vowel = "[AaEeIiOoUu]";
        String obify;
        obify = normal.replaceAll(vowel, "OB");
        return obify;
    }

    public static String caesarify(String normal, int shiftValue) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = shiftAlphabet(shiftValue);
    }

    public static String shiftAlphabet(int shiftValue) {
        int start;
        if (shiftValue < 0) {
            start = (int) 'Z' + shiftValue + 1;
        } else {
            start = 'A' + shiftValue;
        }
        StringBuilder result = new StringBuilder();
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result.append(currChar);
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result.append(currChar);
            }
        }
        return result.toString();
    }

    public static String groupify(String group, int sizeGroups) {
        String result = "";
        for (int i = 0; i < group.length(); i++) {
            if (i % sizeGroups == 0 && i != 0) {
                result = result + " ";
            }
            result = result + group.charAt(i);
        }
        if (group.length() % sizeGroups == 0) {
            return result;
        }
        else {
            for(int i = 0; i<(sizeGroups-group.length()%sizeGroups); i++){
                result = result + "x";
            }
        }
        return result;
    }
    }
}


