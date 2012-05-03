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

        return 0;
    }
}
