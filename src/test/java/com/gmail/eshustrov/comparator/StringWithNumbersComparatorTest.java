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
}
