package com.gmail.eshustrov.comparator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringWithNumbersComparatorTest {
    private final StringWithNumbersComparator comparator = new StringWithNumbersComparator();

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
}
