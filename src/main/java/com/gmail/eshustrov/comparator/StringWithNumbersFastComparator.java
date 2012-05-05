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
        boolean wasDigit = false;
        int numberComparison = 0;
        for (int index = 0; index < minLength; index++) {
            final char oneSymbol = one.charAt(index);
            final char anotherSymbol = another.charAt(index);
            if (isDigit(oneSymbol) && isDigit(anotherSymbol)) {
                if (numberComparison != 0) {
                    continue;
                }
                wasDigit = true;
                if (oneSymbol == anotherSymbol) {
                    continue;
                }
                numberComparison = oneSymbol < anotherSymbol ? -1 : 1;
            } else {
                if (wasDigit) {
                    if (isDigit(oneSymbol)) {
                        return 1;
                    }
                    if (isDigit(anotherSymbol)) {
                        return -1;
                    }
                    if (numberComparison != 0) {
                        return numberComparison;
                    }
                    wasDigit = false;
                }
                if (oneSymbol < anotherSymbol) {
                    return -1;
                }
                if (oneSymbol > anotherSymbol) {
                    return 1;
                }
            }
        }

        if (oneLength < anotherLength) {
            if (!isDigit(another.charAt(minLength)) && numberComparison != 0) {
                return numberComparison;
            }
            return -1;
        }
        if (oneLength > anotherLength) {
            if (!isDigit(one.charAt(minLength)) && numberComparison != 0) {
                return numberComparison;
            }
            return 1;
        }
        if (numberComparison != 0) {
            return numberComparison;
        }
        return 0;
    }

    private static boolean isDigit(final char symbol) {
        return '0' <= symbol && symbol <= '9';
    }
}
