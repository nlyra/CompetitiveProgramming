// Nathaniel Lyra
// UCF ID 4214346
import java.util.*;

public class anya {

    final public static int MIN_WORDS = 2;
    final public static int MIN_LETTERS = 3;
    public static int numWords = 0;

    public static void main(String[] args) {

        // Takes in the user input and intializes it in a string array.
        Scanner sc = new Scanner(System.in);
        String[] input = new String[sc.nextInt()];
        sc.nextLine();

        for (int i = 0; i < input.length; i++)
            input[i] = sc.nextLine();

        sc.close();

        for (String sentence : input)
        {
            //System.out.println(sentence);
            if (isPalindrome(sentence)) System.out.println("Ay");
            else System.out.println("Nap");

            // Reset number of words that are palindromes.
            numWords = 0;
        }
    }

    public static boolean isPalindrome(String sentence) {

        // First check if the whole sentence is a palindrome.
        int i = 0, j = sentence.length() - 1;
        boolean palindrome = true;

        // If the sentence is at least 3 letters long.
        if (sentence.length() >= MIN_LETTERS)
        {
            while (i < j)
            {
                // If either indices are white spaces, increment/decrement and continue.
                if (sentence.charAt(i) == ' ')
                {
                    i++;
                    continue;
                }
                if (sentence.charAt(j) == ' ')
                {
                    j--;
                    continue;
                }

                // If they are not equal, it is not a palindrome.
                if (sentence.charAt(i) != sentence.charAt(j))
                {
                    palindrome = false;
                    break;
                } 
                else {
                    i++;
                    j--;
                }
            }
        }

        // If the sentence was a palindrome, return true.
        if (palindrome) return palindrome; 

        // If it's not the whole sentence, then check word by word separated by spaces.
        String[] words = sentence.split(" ");

        for (String word : words)
        {
            boolean isWord = true;

            // If word contains 3 or more letters.
            if (word.length() >= MIN_LETTERS)
            {
                int x = 0, y = word.length() - 1;
            
                while (x < y)
                {
                    if (word.charAt(x) != word.charAt(y))
                    {
                        isWord = false;
                        break;
                    } 
                    else {
                        x++;
                        y--;
                    }
                }

                // If the word was not a palindrome, onto the next,
                // otherwise, increment our count of palindrome words.
                if (!isWord) continue;
                else numWords++;
            }
        }

        // If at least 2 words in our sentence are palindromes, returns true, otherwise false.
        if (numWords >= MIN_WORDS) return true;
        else return false;
    }
}