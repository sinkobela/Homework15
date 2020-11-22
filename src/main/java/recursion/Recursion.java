package recursion;

public class Recursion {

    public int sumOfFirstN(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            throw new IllegalArgumentException("Invalid negative number!");
        } else {
            return sumOfFirstN(n - 1) + n;
        }
    }

    public int sumOfFirstNEven(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            throw new IllegalArgumentException("Invalid negative number!");
        } else {
            return n + sumOfFirstNEven(n - 2);
        }
    }

    public boolean isPalindrome(String word) {
        return word.equals(palindromeReverse(word));
    }

    public String palindromeReverse(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Invalid word!");
        } else if (word.length() <= 1) {
            return word;
        } else {
            char last = word.charAt(word.length() - 1);
            String rest = word.substring(0, word.length() - 1);
            return last + palindromeReverse(rest);
        }
    }

    public boolean palindromeCheckLetters(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Invalid word!");
        } else if (word.length() <= 1) {
            return true;
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return palindromeCheckLetters(word.substring(1, word.length() - 1));
        } else {
            return false;
        }
    }

    public int sumOfDigits(int number) {
        if (number > -10 && number < 10) {
            return number;
        } else {
            return sumOfDigits(number / 10) + number % 10;
        }
    }

}
