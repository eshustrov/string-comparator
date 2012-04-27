package com.gmail.eshustrov.comparator;

import java.util.Comparator;

public class StringWithNumbersComparator implements Comparator<String> {
    @Override
    public int compare(final String one, final String another) {
        return one.compareTo(another);
    }
}
