package com.gmail.eshustrov.comparator;

import common.CommonTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringWithNumbersComparatorTest extends CommonTest {
    public StringWithNumbersComparatorTest() {
        super(new StringWithNumbersComparator());
    }

    @Test
    public void nullStrings() {
        assertThat(getComparator().compare(null, null), is(0));
    }

    @Test
    public void lowerNullString() {
        assertThat(getComparator().compare(null, ""), is(-1));
    }

    @Test
    public void higherNonNullString() {
        assertThat(getComparator().compare("", null), is(1));
    }
}
