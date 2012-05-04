package com.gmail.eshustrov.comparator;

import java.util.Comparator;

public class StringWithNumbersFastComparator implements Comparator<String> {
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

        final int oneLength = one.length();
        final int anotherLength = another.length();
        final int minLength = oneLength < anotherLength ? oneLength : anotherLength;
        for (int index = 0; index < minLength; index++) {
            final char oneSymbol = one.charAt(index);
            final char anotherSymbol = another.charAt(index);
            if (oneSymbol < anotherSymbol) {
                return -1;
            }
            if (oneSymbol > anotherSymbol) {
                return 1;
            }
        }

        if (oneLength < anotherLength) {
            return -1;
        }
        if (oneLength > anotherLength) {
            return 1;
        }
        return 0;
    }
}
