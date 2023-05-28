/**
 * A class containing test codes for the DNA class.
 * @author Chaehyeon Kim
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class DNATester {

    /**
     * Tests overridden toString method of DNA class
     */
    @Test
    public void testToString() {

        // a null DNA
        DNA dna1 = new DNA();
        // a DNA containing one base A
        DNA dna2 = new DNA();
        dna2.add(DNA.Base.A);
        // a DNA containing 4 bases AGCT
        DNA dna3 = new DNA();
        dna3.add(DNA.Base.A);
        dna3.add(DNA.Base.G);
        dna3.add(DNA.Base.C);
        dna3.add(DNA.Base.T);

        /* test inputting no letter */
        assertEquals("The test for toString() method fails when the input String is null", new String(""), dna1.toString());
        /* test inputting a single letter */
        assertEquals("The test for toString() method fails when the input String has one letter", new String("A"), dna2.toString());
        /* test inputting multiple letters */
        assertEquals("The test for toString() method fails when the input String has many letters", new String("AGCT"), dna3.toString());
    }

    /**
     * Tests string2DNA method of DNA class
     */
    @Test
    public void testString2DNA() {

        // a null DNA
        DNA dna1 = new DNA();
        // a DNA containing one base A
        DNA dna2 = new DNA();
        dna2.add(DNA.Base.A);
        // a DNA containing 4 bases AGCT
        DNA dna3 = new DNA();
        dna3.add(DNA.Base.A);
        dna3.add(DNA.Base.G);
        dna3.add(DNA.Base.C);
        dna3.add(DNA.Base.T);

        /* test inputting no letter */
        assertEquals("The test for string2DNA() method fails when the input String is null", dna1, DNA.string2DNA(""));
        /* test inputting single letter */
        assertEquals("The test for string2DNA() method fails when the input String has one letter", dna2, DNA.string2DNA("A"));
        /* test inputting multiple letters */
        assertEquals("The test for string2DNA() method fails when the input String has many letters", dna3, DNA.string2DNA("AGCT"));
        /* test inputting letters that have no corresponding bases */
        try {
            DNA.string2DNA("ABCD");
        } catch (IllegalArgumentException e) {
            // correctly throws IllegalArgumentException since trying to input non-base letters
        }
    }

    /**
     * Tests splice method of DNA class
     */
    @Test
    public void testSplice() {

        // a DNA with bases A, T, G, C, C, T.
        DNA dna1 = new DNA();
        dna1 = DNA.string2DNA("ATGCCT");

        // a DNA with bases G, A, C, A, G, T.
        DNA dna2 = new DNA();
        dna2 = DNA.string2DNA("GACAGT");

        /* Test removing no base */
        dna1.splice(dna2, 0);
        assertEquals("Test for splice() method fails when removing no base", new String("ATGCCTGACAGT"), dna1.toString());

        /* Test removing one base */
        dna1 = DNA.string2DNA("ATGCCT");
        dna2 = DNA.string2DNA("GACAGT");
        dna1.splice(dna2, 1);
        assertEquals("Test for splice() method fails when removing one base", new String("ATGCCTACAGT"), dna1.toString());

        /* Test removing multiple bases */
        dna1 = DNA.string2DNA("ATGCCT");
        dna2 = DNA.string2DNA("GACAGT");
        dna1.splice(dna2, 3);
        assertEquals("Test for splice() method fails when removing one base", new String("ATGCCTAGT"), dna1.toString());

        /* Test when the input DNA has fewer than numbases bases */
        dna1 = DNA.string2DNA("ATGCCT");
        dna2 = DNA.string2DNA("GACAGT");
        assertEquals("Test for splice() method fails when input DNA has fewer bases than numbases", new String("ATGCCT"), dna1.toString());
    }

    /**
     * Tests overlaps method of DNA class
     */
    @Test
    public void testOverlaps() {
        DNA dna1 = new DNA();
        DNA dna2 = new DNA();

        /* Tests 0 overlap (both true & false) */
        dna1 = DNA.string2DNA("ATGCCT");
        dna2 = DNA.string2DNA("GACAGT");
        assertEquals("Test for overlaps() with zero overlap falsely returns true", false, DNA.overlaps(dna1, dna2, 0));
        assertEquals("Test for overlaps() with zero overlap falsely returns true", false, DNA.overlaps(dna2, dna1, 0));

        /* Tests 1 overlap (both true & false) */
        dna1 = DNA.string2DNA("ATGCCT");
        dna2 = DNA.string2DNA("TACAGT");
        assertEquals("Test for overlaps() with one overlap falsely returns false", true, DNA.overlaps(dna1, dna2, 1));
        assertEquals("Test for overlaps() with zero overlap falsely returns true", false, DNA.overlaps(dna2, dna1, 1));

        /* Tests many overlaps (both true & false) */
        dna1 = DNA.string2DNA("ATGCCT");
        dna2 = DNA.string2DNA("CCTAGT");
        assertEquals("Test for overlaps() with many overlap falsely returns false", true, DNA.overlaps(dna1, dna2, 3));
        assertEquals("Test for overlaps() with zero overlap falsely returns true", false, DNA.overlaps(dna2, dna1, 3));
    }

    /**
     * Tests compareTo method of DNA class
     */
    @Test
    public void testCompareTo() {
        // DNA containing no base
        DNA dna1 = new DNA();
        dna1 = DNA.string2DNA("");
        // another DNA containing no base
        DNA dna1a = new DNA();
        dna1a = DNA.string2DNA("");

        // DNA containing a single base
        DNA dna2 = new DNA();
        dna2 = DNA.string2DNA("A");
        // another DNA containing a single base with the same base as above
        DNA dna2a = new DNA();
        dna2a = DNA.string2DNA("A");

        // DNA containing multiple bases
        DNA dna3 = new DNA();
        dna3 = DNA.string2DNA("ATCG");
        // DNA containing multiple bases with the same bases as above
        DNA dna3a = new DNA();
        dna3a = DNA.string2DNA("ATCG");

        // a DNA containing no base 
        DNA dna4 = new DNA();
        dna4 = DNA.string2DNA("");
        // a DNA containing a single base different from above
        DNA dna5 = new DNA();
        dna5 = DNA.string2DNA("C");
        // a DNA containing multiple bases different from above
        DNA dna6 = new DNA();
        dna6 = DNA.string2DNA("TGAC");

        /* this DNA is shorter than the input DNA (compare with 0, 1, and many bases) */
        assertTrue("Wrong return value with shorter this DNA", dna1.compareTo(dna2) < 0);
        assertTrue("Wrong return value with shorter this DNA", dna1.compareTo(dna3) < 0);
        assertTrue("Wrong return value with shorter this DNA", dna2.compareTo(dna3) < 0);

        /* this DNA has the same length as the input DNA */
        assertTrue("Wrong return value with two DNA with same length", dna2.compareTo(dna5) < 0);
        assertTrue("Wrong return value with two DNA with same length", dna3.compareTo(dna6) < 0);

        /* this DNA is longer than the input DNA (compare with 0, 1, and many bases) */
        assertTrue("Wrong return value with longer this DNA", dna3.compareTo(dna1) > 0);
        assertTrue("Wrong return value with longer this DNA", dna3.compareTo(dna2) > 0);
        assertTrue("Wrong return value with longer this DNA", dna2.compareTo(dna1) > 0);

        /* this DNA is equal to the input DNA (0, 1, and many bases) */
        assertTrue("Wrong return value with longer this DNA", dna1.compareTo(dna1a) == 0);
        assertTrue("Wrong return value with longer this DNA", dna2.compareTo(dna2a) == 0);
        assertTrue("Wrong return value with longer this DNA", dna3.compareTo(dna3a) == 0);
    }
}