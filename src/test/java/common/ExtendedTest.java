package common;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class ExtendedTest extends CommonTest {
    public ExtendedTest(final Comparator<String> comparator) {
        super(comparator);
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
