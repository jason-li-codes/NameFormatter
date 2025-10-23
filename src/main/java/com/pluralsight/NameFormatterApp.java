package com.pluralsight;

public class NameFormatterApp {

    public static void main(String[] args) {

        // test case with 2 parameters
        System.out.println(NameFormatter.format("jason", "li"));

        // test cases with any combination of 3 parameters, with empty Strings for 2 of the optional name parts
        System.out.println(NameFormatter.format("mr.", "jason", "", "li", ""));
        System.out.println(NameFormatter.format("", "jason", "b", "li", ""));
        System.out.println(NameFormatter.format("", "jason", "", "li", "BS"));

        // test cases with any combination of 4 parameters, with an empty String for the optional name part
        System.out.println(NameFormatter.format("mr.", "jason", "b", "li", ""));
        System.out.println(NameFormatter.format("mr.", "jason", "", "li", "BS"));
        System.out.println(NameFormatter.format("", "jason", "b", "li", "BS"));

        // test case for all 5 parameters
        System.out.println(NameFormatter.format("mr.", "jason", "b", "li", "BS"));

        // test case for 1 full name parameter
        System.out.println(NameFormatter.format("mr. jason b li, BS"));

    }

}
