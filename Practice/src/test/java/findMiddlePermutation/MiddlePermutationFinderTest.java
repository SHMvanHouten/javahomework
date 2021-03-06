package findMiddlePermutation;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

//You are given a string s. Every letter in s appears once.

//  Consider all strings formed by rearranging the letters in s. After ordering these strings in dictionary order,
//  return the middle term. (If the sequence has a even length n, define its middle term to be the (n/2)th term.)

public class MiddlePermutationFinderTest {
    @Test
    public void itShouldFindTheMiddlePermutationOfAllPermutationsOfABC() throws Exception {
        MiddlePermutationFinder finder = new MiddlePermutationFinder();
        assertThat(finder.getMiddlePermutation("abc"), is("bac"));
    }

    @Test
    public void itShouldFindTheMiddlePermutationOfAllPermutationsOfABCD() throws Exception {
        MiddlePermutationFinder finder = new MiddlePermutationFinder();
        assertThat(finder.getMiddlePermutation("abcd"), is("bdca"));
    }

    @Test
    public void itShouldFindTheMiddlePermutationOfAllPermutationsOfABCDE() throws Exception {
        MiddlePermutationFinder finder = new MiddlePermutationFinder();
        assertThat(finder.getMiddlePermutation("abcde"), is("cbeda"));
    }

    @Test
    public void itShouldWorkForAnUnsortedStringToo() throws Exception {
        MiddlePermutationFinder finder = new MiddlePermutationFinder();
        assertThat(finder.getMiddlePermutation("abdxgc"), is("cxgdba"));
    }
}