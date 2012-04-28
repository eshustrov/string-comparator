package com.gmail.eshustrov.comparator;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringWithNumbersComparator implements Comparator<String> {
    private static final Pattern PATTERN = Pattern.compile("(\\D*)(\\d*)");

    @Override
    public int compare(final String one, final String another) {
        if (one == null && another == null) {
            return 0;
        }
        if (one == null) {
            return -1;
        }
        if (another == null) {
            return 1;
        }

        final Matcher oneMatcher = PATTERN.matcher(one);
        final Matcher anotherMatcher = PATTERN.matcher(another);
        for (; ; ) {
            oneMatcher.find();
            anotherMatcher.find();

            final String oneGroup = oneMatcher.group();
            final String anotherGroup = anotherMatcher.group();
            if (oneGroup.isEmpty() || anotherGroup.isEmpty()) {
                return oneGroup.compareTo(anotherGroup);
            }

            final String oneTextGroup = oneMatcher.group(1);
            final String anotherTextGroup = anotherMatcher.group(1);
            if (!oneTextGroup.equals(anotherTextGroup)) {
                return oneGroup.compareTo(anotherGroup);
            }

            final String oneNumberGroup = oneMatcher.group(2);
            final String anotherNumberGroup = anotherMatcher.group(2);
            if (oneNumberGroup.isEmpty() || anotherNumberGroup.isEmpty()) {
                return oneNumberGroup.compareTo(anotherNumberGroup);
            }

            final BigInteger oneNumber = new BigInteger(oneNumberGroup);
            final BigInteger anotherNumber = new BigInteger(anotherNumberGroup);
            final int result = oneNumber.compareTo(anotherNumber);
            if (result != 0) {
                return result;
            }
        }
    }
}
