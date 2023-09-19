package com.gusta.passwordgenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class PasswordGenerator {
    private static final String[] chars = {
            "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z"
    };
    private static final String[] numbersChars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] upperCaseChars = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    private static final String[] specialChars = {
            "!", "@", "#", "$", "%", "&", "*", "(", ")", "-", "=",
            "_", "+", "{", "[", "]", "}", ".", ",", ":", "/", "?", "'", "<", ">", "|"
    };

    public static String generate(int size, boolean upperCase, boolean numbers, boolean special) {
        StringBuilder password = new StringBuilder();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(chars));

        if (upperCase) {
            list.addAll(Arrays.asList(upperCaseChars));
        }
        if (numbers) {
            list.addAll(Arrays.asList(numbersChars));
        }
        if (special) {
            list.addAll(Arrays.asList(specialChars));
        }

        for (int i = 0; i < size; i++) {
            int position = (int) (Math.random() * list.size());
            password.append(list.get(position));
        }
        return password.toString();
    }
}
