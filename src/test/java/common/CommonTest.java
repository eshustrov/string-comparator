package common;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class CommonTest {
    private final Comparator<String> comparator;

    public CommonTest(final Comparator<String> comparator) {
        this.comparator = comparator;
    }

    protected Comparator<String> getComparator() {
        return comparator;
    }

    @Test
    public void emptyStrings() {
        assertThat(comparator.compare("", ""), is(0));
    }

    @Test
    public void shorterString() {
        assertThat(comparator.compare("", "a"), is(-1));
    }

    @Test
    public void longerString() {
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
    public void lowerStringByNumberAtEnd() {
        assertThat(comparator.compare("a2", "a10"), is(-1));
    }

    @Test
    public void lowerStringByNumberInside() {
        assertThat(comparator.compare("a3b", "a7b"), is(-1));
    }

    @Test
    public void longerStringByNumberInside() {
        assertThat(comparator.compare("a20b", "a3b"), is(1));
    }

    @Test
    public void lowerStringNotByNumberAtEnd() {
        assertThat(comparator.compare("a10", "b2"), is(-1));
    }

    @Test
    public void longerStringButLowerByNumberInside() {
        assertThat(comparator.compare("a1c", "a8"), is(-1));
    }

    @Test
    public void shorterStringButHigherByNumberInside() {
        assertThat(comparator.compare("a7", "a4e"), is(1));
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

    @Test
    public void imageFileNames() {
        assertThat(comparator.compare("Image_938.jpeg", "Image_1072.jpeg"), is(-1));
    }

    @Test
    public void speed() {
        final long timeStart = System.nanoTime();
        comparator.compare("abcde01234fgh567ij89", "abcde01234fgh567ij88");
        comparator.compare("abcde01234fgh567ij89k", "abcde01234fgh567ij89l");
        final long timeStop = System.nanoTime();
        System.out.println(comparator.getClass().getCanonicalName() + ": " + (timeStop - timeStart) + " nanoseconds");
    }
}
