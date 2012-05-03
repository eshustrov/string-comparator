package net.nowhere.maxim.comparator;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class NumericStringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.equals(o2) || o1.contentEquals(o2)) {
            return 0;
        }

        int minStringLength;
        if (o1.length() <= o2.length()) {
            minStringLength = o1.length();
        } else {
            minStringLength = o2.length();
        }

        for (AtomicInteger index = new AtomicInteger(0); index.get() < minStringLength; index.incrementAndGet()) {
            if (Character.isDigit(o1.charAt(index.get())) && Character.isDigit(o2.charAt(index.get()))) {
                int initIndex1 = index.get();
                int numberWeight1 = getNumberFromString(o1, index);
                int numberWeight2 = getNumberFromString(o2, new AtomicInteger(initIndex1));
                if (numberWeight1 != numberWeight2) {
                    return numberWeight1 > numberWeight2 ? 1 : -1;
                }
            } else {
                int result = Character.valueOf(o1.charAt(index.get())).compareTo(o2.charAt(index.get()));
                if (result != 0) {
                    return result;
                }
            }
        }
        return o1.compareTo(o2);
    }

    private int getNumberFromString(String stringWithNumbers, AtomicInteger index) {
        int begin = index.intValue();
        int stringLength = stringWithNumbers.length();
        while (Character.isDigit(stringWithNumbers.charAt(index.get()))) {
            if (stringLength <= index.incrementAndGet()) break;
        }

        return Integer.parseInt(stringWithNumbers.substring(begin, index.intValue()));
    }
}