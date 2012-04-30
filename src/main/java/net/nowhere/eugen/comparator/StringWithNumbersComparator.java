package net.nowhere.eugen.comparator;

import java.util.Comparator;

public class StringWithNumbersComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        char[] str1 = o1.toCharArray();
        char[] str2 = o2.toCharArray();

        int i = 0;
        StringBuilder number1 = new StringBuilder();
        StringBuilder number2 = new StringBuilder();
        while (i < str1.length && i < str2.length) {
            if (Character.isDigit(str1[i]) && Character.isDigit(str2[i])) {
                number1.append(str1[i]);
                number2.append(str2[i]);
            } else {
                if (number1.length() > 0 || number2.length() > 0) {
                    int n1 = Integer.parseInt(number1.toString());
                    int n2 = Integer.parseInt(number2.toString());
                    if (n1 != n2) return n1 - n2;

                    number1.setLength(0);
                    number2.setLength(0);
                }
                if (str1[i] != str2[i]) return str1[i] - str2[i];
            }
            i++;
        }

        return str1.length - str2.length;
    }
}
