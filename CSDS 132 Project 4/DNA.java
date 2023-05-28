import java.lang.IllegalArgumentException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * A class that contains the properties of DNA
 * @author Chaehyeon Kim
 */

public class DNA extends LinkedList < DNA.Base > implements Comparable < DNA > {

    /**
     * Creates a class for DNA bases using enum shortcut
     */
    public enum Base {
        /** Represents DNA Base A */
        A("A"),
            /** Represents DNA Base C */
            C("C"),
            /** Represents DNA Base C */
            G("G"),
            /** Represents DNA Base T */
            T("T");

        /** Field to store the String values of the Base */
        private String base;

        /** A constructor for Base that takes String as an input */
        private Base(String base) {
            this.base = base;
        }
    }

    /**
     * Returns a String representation of the DNA comprised of the bases
     * @return a String representation of the DNA comprised of the bases
     */
    public String toString() {
        StringBuilder builder = new StringBuilder(); // a StringBuilder to use when appending
        /** A loop that goes through each Base of this DNA and converts to String */
        for (Base b: this) {
            if (b == Base.A)
                builder.append("A");
            else if (b == Base.C)
                builder.append("C");
            else if (b == Base.G)
                builder.append("G");
            else if (b == Base.T)
                builder.append("T");
        }
        return builder.toString();
    }

    /**
     * Removes the first numbases bases of input dna and splices it onto this DNA
     * @param dna  the DNA sequence to be spliced onto this DNA
     * @param numbases  the number of bases to be removed at the front of dna
     */
    public void splice(DNA dna, int numbases) {
        // A loop to remove "numbases" number of bases from the input DNA dna
        for (int i = 0; i < numbases; i++)
            dna.removeFirst();
        ListIterator < DNA.Base > it = dna.listIterator(); // stores Iterator of input DNA's list
        /** A loop that goes through what's remaining in the input dna and adds to the end of this DNA */
        for (DNA.Base b: dna)
            this.add(b);
    }

    /**
     * Compares this DNA and the input DNA by length or by alphabet if same in length
     * @param o  input DNA that is compared to this DNA
     * @return less than, equal to, or greater than 0 returned, and this is ordered before, the same as, or after the input
     */
    @Override
    public int compareTo(DNA o) {
        return this.toString().compareTo(o.toString());
    }

    /**
     * Returns the DNA sequence String that matches the input String
     * @param s  String to be converted to DNA
     * @return the DNA sequence String that matches the input String
     */
    public static DNA string2DNA(String s) throws IllegalArgumentException {
        if (s != null) {
            DNA dna = new DNA(); // variable to store the DNA instance to be returned
            ListIterator < DNA.Base > it = dna.listIterator(); // stores Iterator of dna's list
            /** A loop that goes through each letter of the input string and append to StringBuilder*/
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'A')
                    it.add(Base.A);
                else if (s.charAt(i) == 'C')
                    it.add(Base.C);
                else if (s.charAt(i) == 'G')
                    it.add(Base.G);
                else if (s.charAt(i) == 'T')
                    it.add(Base.T);
                else
                    throw new IllegalArgumentException();
            }
            return dna;
        } else
            throw new IllegalArgumentException();
    }

    /**
     * Checks if the two input DNA's have n number of matching bases
     * @return  whether the two input DNA's have n number of matching bases
     * @param dna1  The DNA that will have its last n bases evaluated
     * @param dna2  The DNA that will have its first n bases evaluated
     * @param n     The number of bases the input DNA's will be evaluated at
     */
    public static boolean overlaps(DNA dna1, DNA dna2, int n) {
        boolean answer = false;
        if (n != 0) {
            ListIterator < DNA.Base > it1 = dna1.listIterator(); // stores dna1's ListIterator
            DNA dna1a = new DNA(); // stores the last n bases of dna1
            ListIterator < DNA.Base > it2 = dna2.listIterator(); // stores dna2's ListIterator
            DNA dna2a = new DNA(); // stores the first n bases of dna2
            /** A loop that adds n number of dna2's front bases to dna1a and dna1's back bases to dna1a */
            for (int i = 0; i < n; i++) {
                dna2a.add(dna2.get(i));
                dna1a.addFirst(dna1.get(dna1.size() - i - 1));
            }
            answer = dna1a.equals(dna2a);
        }
        return answer;
    }

    /**
     * The main method that will run the program to perform appropriate splicing of DNA's
     * @param args  The string arrays containing two strings of DNA sequences
     */
    public static void main(String[] args) {
      if (args.length > 0) {
        // first compare the two strings of DNA sequences with their overlap
        int dna1back = 0;
        int dna2back = 0; 
        DNA dna1 = string2DNA(args[0]);
        DNA dna2 = string2DNA(args[1]);
        /** A loop to compare which way the overlap is greater */
        for (int i = 0;
             (dna1back < args[0].length()) && (dna2back < args[1].length()); i++) {
               if (overlaps(dna1, dna2, i))
                 dna1back = dna1back + 1;
               else if (overlaps(dna2, dna1, i))
                 dna2back = dna2back + 1;
             }
             // then splice with the greatest overlap
             if ((dna1back - dna2back) < 0) { // dna1's back overlaps less than the dna2's
               dna2.splice(dna1, dna2back);
               System.out.println("The spliced DNA is " + dna2.toString());
             }
             else { // dna1's back overlaps less than the dna2's OR it's the same
               dna1.splice(dna2, dna1back);
               System.out.println("The spliced DNA is " + dna2.toString());
             }
      }
      else if (args.length == 0)
        System.out.println("The DNA class doesn't have enough DNA strands");
    }
}