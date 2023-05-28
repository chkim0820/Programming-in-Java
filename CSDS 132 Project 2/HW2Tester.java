/* Chaehyeon Kim, A class to test methods in HW2 class*/

import org.junit.*;
import static org.junit.Assert.*;

public class HW2Tester {

    /* a testing method for alphabeticalOrder method in HW2 */
    @Test
    public void testAlphabeticalOrder() {
        // Testing an empty string ("0" letters) as an input
        assertTrue("The test for an empty string fails", HW2.alphabeticalOrder(""));
        // Testing a string with 1 letter
        assertTrue("The test for a string with one letter fails", HW2.alphabeticalOrder("a"));
        // Testing a string with many letters
        assertTrue("The test for a string with many letters fails", HW2.alphabeticalOrder("abcdefghi"));
        // Testing a string with capitalized letters in the beginning
        assertTrue("The test for capitalized letters in the beginning fails", HW2.alphabeticalOrder(" ABC defghi"));
        // Testing a string with capitalized letters in the middle
        assertTrue("The test for capitalized letters in the middle fails", HW2.alphabeticalOrder("abcDEF!ghi"));
        // Testing a string with capitalized letters in the back
        assertTrue("The test for capitalized letters in the back fails", HW2.alphabeticalOrder("abcdefGHI!"));
        // Testing to see if the method correctly returns false when the string is not in alphabetical order
        assertFalse("Incorrectly claims the letters are in alphabetical order", HW2.alphabeticalOrder("aBcdxOfe"));
    }

    /* a testing method for caesarCipher method in HW2 */
    @Test
    public void testCaesarCipher() {
        //Testing a string shifted many to the left
        assertEquals("Incorrectly claims letters and digits are shifted many spaces to the left", "Dahhk vaxnw", HW2.caesarCipher("Hello zebra", -4));
        // Testing a string shifted 1 to the left
        assertEquals("Incorrectly claims letters and digits are shifted 1 to the left", "Gdkkn ydaqz", HW2.caesarCipher("Hello zebra", -1));
        // Testing a string shifted 0 spaces (stays where it was)
        assertEquals("Incorrectly claims letters and digits are not shifted", "Hello zebra", HW2.caesarCipher("Hello zebra", 0));
        // Testing a string shifted 1 to the right
        assertEquals("Incorrectly claims letters and digits are shifted 1 to the right", "Ifmmp afcsb", HW2.caesarCipher("Hello zebra", 1));
        // Testing a string shifted many letters to the right
        assertEquals("Incorrectly claims letters and digits are shifted 4 to the left", "Lipps difve", HW2.caesarCipher("Hello zebra", 4));
        // Testing a string with a non-letter in the beginning
        assertEquals("The test for non-letter in the beginning fails", "!!Jgnnq bgdtc", HW2.caesarCipher("!!Hello zebra", 2));
        // Testing a string with a non-letter in the middle
        assertEquals("The test for non-letter in the middle fails", "Jgnnq!!bgdtc", HW2.caesarCipher("Hello!!zebra", 2));
        // Testing a string with a non-letter in the end
        assertEquals("The test for non-letter in the end fails", "Jgnnq bgdtc!!", HW2.caesarCipher("Hello zebra!!", 2));
    }

    /* a testing method for repeatChars method in HW2 */
    @Test
    public void testRepeatChars() {
        // Testing when the input number is negative and has a big value (letters repeated many times from the back)
        assertEquals("The test for big negative int value fails", "!!yyaadd  ddooooGG", HW2.repeatChars("Good day!", -2));
        // Testing when the input number is negative and has a value of 1 (letters repeated 1 time from the back)
        assertEquals("The test for -1 int parameter fails", "!yad dooG", HW2.repeatChars("Good day!", -1));
        // Testing when the input number is 0 (letters repeated 0 times)
        assertEquals("The test for 0 int parameter fails", "", HW2.repeatChars("Good day!", 0));
        // Testing when the input number is 1 (letters repeated 1 time)
        assertEquals("The test for 1 int parameter fails", "Good day!", HW2.repeatChars("Good day!", 1));
        // Testing when the input number is big (letters repeated many times)
        assertEquals("The test for many int parameter fails", "GGGGoooooooodddd    ddddaaaayyyy!!!!", HW2.repeatChars("Good day!", 4));
        // Testing when the non-letter value is in the front
        assertEquals("The test for non-letter value in the front fails", "!!GGoooodd  ddaayy", HW2.repeatChars("!Good day", 2));
        // Testing when the non-letter value is in the middle
        assertEquals("The test for non-letter value in the middle fails", "GGoooodd!!  ddaayy", HW2.repeatChars("Good! day", 2));
        // Non-letter values in the end are already tested with "Good day!" as an input
    }

    /* a testing method for repeatWords method in HW2 */
    @Test
    public void testRepeatWords() {
        // Testing when the words are repeated 0 times
        assertEquals("Test for repeating words 0 times failed", "", HW2.repeatWords("Hello, how are you?", 0));
        // Testing when the words are repeated 1 time
        assertEquals("Test for repeating words 1 times failed", "Hello, how are you?", HW2.repeatWords("Hello, how are you?", 1));
        // Testing when the words are repeated many times
        assertEquals("Test for repeating words many times failed", "Hello Hello Hello, how how how are are are you you you?", HW2.repeatWords("Hello, how are you?", 3));
        // Testing when the non-letters are in the beginning
        assertEquals("Test for non-letters in the beginning failed", "!!Hi Hi hello hello", HW2.repeatWords("!!Hi hello", 2));
        // Testing when the non-letters are in the middle
        assertEquals("Test for non-letters in the middle failed", "Hi Hi!!hello hello", HW2.repeatWords("Hi!!hello", 2));
        // Testing when the non-letters are in the end
        assertEquals("Test for non-letters in the end failed", "Hi Hi hello hello!!", HW2.repeatWords("Hi hello!!", 2));
    }

    /* a testing method for repeatValues method in HW2 */
    @Test
    public void testRepeatValues() {
        // an array for testing
        double[] array = new double[] {
            1.1,
            2.2,
            3.3,
            4.4
        };
        // Testing the array elements repeated 0 time
        assertEquals("Test for repeating values 0 time failed", new double[] {}, HW2.repeatValues(array, 0));
        // Testing the array elements repreated 1 time
        assertEquals("Test for repeating values 1 time failed", new double[] {
            1.1,
            2.2,
            3.3,
            4.4
        }, HW2.repeatValues(array, 1));
        // Testing the array elements repeated many times
        assertEquals("Test for repeating values many times failed", new double[] {
            1.1,
            1.1,
            1.1,
            2.2,
            2.2,
            2.2,
            3.3,
            3.3,
            3.3,
            4.4,
            4.4,
            4.4
        }, HW2.repeatValues(array, 3));
    }

    /* a testing method for isWindingPath method in HW2 */
    @Test
    public void testIsWindingPath() {
        // a double array with zero row
        double[][] a = new double[0][];
        // a double array with one row
        double[][] b = new double[1][];
        b[0] = new double[] {
            1.0
        };
        // a double array with multiple rows & smallest value in the middle
        double[][] c = new double[3][];
        c[0] = new double[] {
            3.0,
            2.0
        };
        c[1] = new double[] {
            4.0,
            1.0,
            8.0
        };
        c[2] = new double[] {
            5.0,
            6.0,
            7.0
        };
        // a double array with non-winding path
        double[][] d = new double[3][];
        d[0] = new double[] {
            3.0,
            2.0
        };
        d[1] = new double[] {
            4.0,
            10.0,
            8.0
        };
        d[2] = new double[] {
            5.0,
            6.0,
            7.0
        };
        // a double array with smallest value in the beginning
        double[][] e = new double[3][];
        e[0] = new double[] {
            1.0,
            2.0,
            3.0
        };
        e[1] = new double[] {
            6.0,
            5.0,
            4.0
        };
        e[2] = new double[] {
            7.0,
            8.0,
            9.0
        };
        // a double array with smallest value in the end
        double[][] f = new double[3][];
        f[0] = new double[] {
            9.0,
            8.0,
            7.0
        };
        f[1] = new double[] {
            4.0,
            5.0,
            6.0
        };
        f[2] = new double[] {
            3.0,
            2.0,
            1.0
        };
        // Testing winding path method for an empty array (0)
        assertTrue("Incorrectly claims the array is not a winding path", HW2.isWindingPath(a));
        // Testing winding path method for an array with a single element (1)
        assertTrue("Incorrectly claims the array is not a winding path", HW2.isWindingPath(b));
        // Testing winding path method for an array with many elements & smallest value in the middle
        assertTrue("Incorrectly claims the array is not a winding path", HW2.isWindingPath(c));
        // Testing winding path method for smallest value in the beginning
        assertTrue("Incorrectly claims the array is not a winding path", HW2.isWindingPath(e));
        // Testing winding path method for smallest value in the end
        assertTrue("Incorrectly claims the array is not a winding path", HW2.isWindingPath(f));
        // Testing winding path method for a non-winding path array
        assertFalse("Incorrectly claims the array is a winding path", HW2.isWindingPath(d));
    }

    /* a testing method for cryptoquip method in HW2 */
    @Test
    public void testCryptoquip() {
        // Testing when the string is empty (0)
        assertEquals("The test unsuccessfully converts letters", "", HW2.cryptoquip(""));
        // Testing when the string has 1 letter
        assertEquals("The test unsuccessfully converts letters", "U", HW2.cryptoquip("a"));
        // Testing when the string has many letters
        assertEquals("The test unsuccessfully converts letters", "UDOZS", HW2.cryptoquip("abcde"));
        // Testing when the string has non-letters in the beginning
        assertEquals("The test unsuccessfully converts letters", "!!U FSDWU TY SYOUNTRC", HW2.cryptoquip("!!A Zebra is escaping"));
        // Testing when the string has non-letters in the middle
        assertEquals("The test unsuccessfully converts letters", "U FSDWU!! TY SYOUNTRC", HW2.cryptoquip("A zebra!! is escaping"));
        // Testing when the string has non-letters in the end
        assertEquals("The test unsuccessfully converts letters", "U FSDWU TY SYOUNTRC!!", HW2.cryptoquip("A zebra is escaping!!"));
    }

}