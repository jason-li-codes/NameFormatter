package com.pluralsight;

public class NameFormatterApp {

    public static void main(String[] args) {

        System.out.println(NameFormatter.format("jason", "li"));

        System.out.println(NameFormatter.format("mr.", "jason", "", "li", ""));
        System.out.println(NameFormatter.format("", "jason", "b", "li", ""));
        System.out.println(NameFormatter.format("", "jason", "", "li", "BS"));

        System.out.println(NameFormatter.format("mr.", "jason", "b", "li", ""));
        System.out.println(NameFormatter.format("mr.", "jason", "", "li", "BS"));
        System.out.println(NameFormatter.format("", "jason", "b", "li", "BS"));

        System.out.println(NameFormatter.format("mr.", "jason", "b", "li", "BS"));

        System.out.println(NameFormatter.format("mr. jason b li, BS"));

    }

}
