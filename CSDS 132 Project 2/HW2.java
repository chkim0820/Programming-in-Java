/* Chaehyeon Kim, class HW2 for CSDS 132 project #2 */

public class HW2 {

    /* 1) a method that evluates if the letters are in alphabetical order */
    public static boolean alphabeticalOrder(String s) {
        StringBuilder builder = new StringBuilder(); // a StringBuilder variable for the loop
        /* a loop that capitalizes all letters and adds to the builder */
        for (int i = 0; i < s.length(); i = i + 1) {
            char c = s.charAt(i); // a variable that stores char @ i
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 'a' + 'A');
                builder.append(c);
            } else if (c >= 'A' && c <= 'Z')
                builder.append(c);
        }
        /* for loop that examines alphabetical order*/
        for (int i = 0; i < (builder.length() - 1); i = i + 1) {
            if (builder.charAt(i) > builder.charAt(i + 1))
                return false;
        }
        return true;
    }

    /* 2) a method that performs a Caesar cipher on the String */
    public static String caesarCipher(String s, int i) {
        StringBuilder builder = new StringBuilder(); // a StringBuilder variable to store new strings
        /* Loop goal: append an appropriate character according to the caesar cipher rule */
        for (int index = 0; index < s.length(); index = index + 1) {
            char c = s.charAt(index); // a char variable to store the char at the index
            if (i > 25 || i < -25) { // if parameter input i is bigger than 25 (more than 1 rotation)
                i = i % 26;
            }
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) { // if letter or number
                if (((char)(c + i) > 'Z' && (c >= 'A' && c <= 'Z')) || (char)(c + i) > 'z') { // 1) if rotating
                    if (i > 0)
                        c = (char)(c - 26 + i);
                    else if (i < 0)
                        c = (char)(c - 26 - i);
                } else if ((char)(c + i) < 'A' || ((char)(c + i) < 'a' && (c >= 'a' && c <= 'z'))) { // 2) if rotating
                    if (i > 0)
                        c = (char)(c + 26 - i);
                    else if (i < 0)
                        c = (char)(c + 26 + i);
                } else
                    c = (char)(c + i);
                builder.append(c);
            } else
                builder.append(c);
        }
        return builder.toString();
    }

    /* 3) a method that creates a string with char repeated i number of times */
    public static String repeatChars(String s, int i) {
        StringBuilder builder = new StringBuilder(); // a StringBuilder variable to store the repeated chars
        if (i > 0) { // if repeated positive number of times
            /* for loop for repeating letters & adding to the builder*/
            for (int index = 0; index < s.length(); index = index + 1) {
                char c = s.charAt(index); // variable c stores the char value at index
                for (int number = 0; number < i; number = number + 1)
                    builder.append(c);
            }
        } else if (i < 0) { // if repeated negative number of times
            /* for loop for repeating letters & adding to the builder*/
            for (int index = s.length() - 1; index >= 0; index = index - 1) {
                char c = s.charAt(index); // variable c stores the char value at index
                for (int number = 0; number < -i; number = number + 1)
                    builder.append(c);
            }
        }
        return builder.toString();
    }

    /* 4) a method that creates a string with repeated words */
    public static String repeatWords(String s, int times) {
        StringBuilder builder = new StringBuilder(); // StringBuilder variable that stores a string with repeated words
        int i = 0; // int variable to remember which letter of the input string the loop is on
        /* while loop that goes through all indexes of the input string*/
        while (i < s.length()) {
            char c = s.charAt(i); // char variable to store the char at i
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') && times != 0) { // if letter & not repeated 0 times
                int start = i; // int variable that stores the start of the word
                /* while loop to determine where the words end*/
                while (((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) && i < s.length()) {
                    c = s.charAt(i);
                    i = i + 1;
                    if (i < s.length())
                        c = s.charAt(i);
                }
                int end = i; // int variable that stores where the word ends
                /* for loop to add the words "times" many times to the builder*/
                for (int number = 0; number < times; number = number + 1) {
                    int startSave = start; // int variable that starts at where the word starts & move along the string
                    int endSave = end; // int variable that stores where the word ends
                    /* while loop that adds the letters of the words each time*/
                    while (startSave < endSave) {
                        builder.append(s.charAt(startSave));
                        startSave = startSave + 1;
                    }
                    if (number < times - 1)
                        builder.append(" ");
                }
            } else if (times != 0) { // if c not letter & not repeated 0 times
                builder.append(c);
                i = i + 1;
            } else if (times == 0) // if c repeated 0 times
                i = s.length() + 1;
        }
        return builder.toString();
    }

    /* 5) a method that returns array with repeated elements */
    public static double[] repeatValues(double[] array, int repeat) {
        double[] newArray = new double[repeat * array.length]; // new array that will store the repeated values
        int index = 0; // int variable that stores where on the array the loop is on
        /* for loop that goes through the elements of the input array*/
        for (int i = 0; i < array.length; i = i + 1) {
            double number = array[i]; // double variable that stores the value in the array at i
            int times = 0; // int variable that stores how many times the number has been added to the array
            /* while loop that repeats the array element "repeat" number of times*/
            while (times < repeat) {
                newArray[index] = number;
                times = times + 1;
                index = index + 1;
            }
        }
        return newArray;
    }

    /* 6) a method that examines whether the input array has a "winding path" */
    public static boolean isWindingPath(double[][] array) {
        double value = array[0][0]; // saves the smallest value after the first loop & later, value of current index
        int i = 0; // int variable that stores the current column of the array 
        int j = 0; // int variable that stores the current row of the array
        int saveI = 0; // int variable that stores the column of the smallest element
        int saveJ = 0; // int variable that stores the row of the smallest element
        /* while loop to find the smallest value in the array */
        while (i < array.length) {
            j = 0;
            while (j < array[i].length) {
                if (array[i][j] < value) {
                    value = array[i][j];
                    saveI = i;
                    saveJ = j;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        int total = 0; // int variable that stores the total number of elements in the array
        /* for loop to determine how many numbers there are in the array */
        for (i = 0; i < array.length; i = i + 1) {
            for (j = 0; j < array[i].length; j = j + 1) {
                total = total + 1;
            }
        }
        int times = 0; // int variable that counts the number of rotation through the next loop
        /* while loop that goes through the array to determine whether the array is a winding path or not */
        while (times < total) {
            double diff = 0.0; // int variable that remembers the difference between the current index element & local element it's being compared to
            i = saveI;
            j = saveJ;
            if (((j + 1) < array[i].length) && // if statement to check the value to the right
                (value < array[i][j + 1])) {
                diff = array[i][j + 1] - value;
                saveJ = j + 1;
            }
            if (((j - 1) >= 0) && // if statement to check the value to the left
                (value < array[i][j - 1]) && (diff > (array[i][j - 1] - value))) {
                diff = array[i][j - 1] - value;
                saveJ = j + 1;
            }
            if (((i + 1) < array.length) && // if statement to check the value above
                (value < array[i + 1][j]) && (diff > (array[i + 1][j] - value))) {
                diff = array[i + 1][j] - value;
                saveJ = j;
                saveI = i + 1;
            }
            if (((i - 1) >= 0) && // if statement to check the value below
                (value < array[i - 1][j]) && (diff > (array[i - 1][j] - value))) {
                diff = array[i - 1][j] - value;
                saveJ = j;
                saveI = i - 1;
            }
            if (saveI == i && saveJ == j) { // if statement that terminates the loop if the element has not moved
                times = total + 1;
            }
            i = saveI;
            j = saveJ;
            value = array[i][j];
            times = times + 1;
        }
        return (times == (total - 1));
    }

    /* 7) a method that replaces each letter to another letter */
    public static String cryptoquip(String s) {
        StringBuilder builder = new StringBuilder(); // StringBuilder variable that stores the new string with changed letters
        /* a loop to change the letters of the input string */
        for (int i = 0; i < s.length(); i = i + 1) {
            char c = s.charAt(i); // char variable that stores the letter at the current index
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) { // if statement to evaluate if c is a letter
                // a new letter is assigned for each letter
                if (c == 'a' || c == 'A')
                    c = 'U';
                else if (c == 'b' || c == 'B')
                    c = 'D';
                else if (c == 'c' || c == 'C')
                    c = 'O';
                else if (c == 'd' || c == 'D')
                    c = 'Z';
                else if (c == 'e' || c == 'E')
                    c = 'S';
                else if (c == 'f' || c == 'F')
                    c = 'G';
                else if (c == 'g' || c == 'G')
                    c = 'C';
                else if (c == 'h' || c == 'H')
                    c = 'L';
                else if (c == 'i' || c == 'I')
                    c = 'T';
                else if (c == 'j' || c == 'J')
                    c = 'K';
                else if (c == 'k' || c == 'K')
                    c = 'J';
                else if (c == 'l' || c == 'L')
                    c = 'P';
                else if (c == 'm' || c == 'M')
                    c = 'V';
                else if (c == 'n' || c == 'N')
                    c = 'R';
                else if (c == 'o' || c == 'O')
                    c = 'A';
                else if (c == 'p' || c == 'P')
                    c = 'N';
                else if (c == 'q' || c == 'Q')
                    c = 'M';
                else if (c == 'r' || c == 'R')
                    c = 'W';
                else if (c == 's' || c == 'S')
                    c = 'Y';
                else if (c == 't' || c == 'T')
                    c = 'Q';
                else if (c == 'u' || c == 'U')
                    c = 'B';
                else if (c == 'v' || c == 'V')
                    c = 'I';
                else if (c == 'w' || c == 'W')
                    c = 'X';
                else if (c == 'x' || c == 'X')
                    c = 'E';
                else if (c == 'y' || c == 'Y')
                    c = 'H';
                else if (c == 'z' || c == 'Z')
                    c = 'F';
            }
            builder.append(c);
        }
        return builder.toString();
    }

}