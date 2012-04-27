package com.gmail.eshustrov.comparator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringWithNumbersComparatorTest {
    private final StringWithNumbersComparator comparator = new StringWithNumbersComparator();

    @Test
    public void emptyStrings() {
        assertThat(comparator.compare("", ""), is(0));
    }

    @Test
    public void shorterStrings() {
        assertThat(comparator.compare("", "a"), is(-1));
    }

    @Test
    public void longerStrings() {
        assertThat(comparator.compare("a", ""), is(1));
    }

    @Test
    public void equalStrings() {
        assertThat(comparator.compare("a", "a"), is(0));
    }

    @Test
    public void lowerString() {
        assertThat(comparator.compare("a", "b"), is(-1));
    }

    @Test
    public void higherString() {
        assertThat(comparator.compare("b", "a"), is(1));
    }

    @Test
    public void lowerStringByNumber() {
        assertThat(comparator.compare("a2", "a10"), is(-1));
    }

    @Test
    public void lowerStringNotByNumber() {
        assertThat(comparator.compare("a10", "b2"), is(-1));
    }

    @Test
    public void shorterStringAfterNumber() {
        assertThat(comparator.compare("a0", "a0a"), is(-1));
    }

    @Test
    public void lowerStringAfterNumber() {
        assertThat(comparator.compare("a0a", "a0b"), is(-1));
    }

    @Test
    public void lowerNumber() {
        assertThat(comparator.compare("0", "1"), is(-1));
    }

    @Test
    public void higherNumber() {
        assertThat(comparator.compare("10", "2"), is(1));
    }
}
