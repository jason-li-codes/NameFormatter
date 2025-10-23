package com.pluralsight;

public class NameFormatter {

    private NameFormatter() {}

    private static String properCasing(String namePart) {
        namePart = namePart.trim();
        if (!namePart.isEmpty()) {
            return Character.toUpperCase(namePart.charAt(0)) + namePart.substring(1).toLowerCase();
        } else {
            return namePart;
        }
    }

    public static String format(String prefix, String firstName,
                                String middleName, String lastName, String suffix) {
        String formattedName = NameFormatter.properCasing(lastName).replace(",", "") + ", ";
        if (!prefix.isEmpty()) {
            formattedName += NameFormatter.properCasing(prefix).replace(".", "") + ". ";
        }
        formattedName += NameFormatter.properCasing(firstName);
        if (!middleName.isEmpty()) {
            formattedName += " " + NameFormatter.properCasing(middleName);
        }
        if (!suffix.isEmpty()) {
            formattedName += ", " + suffix;
        }
        return formattedName;
    }

    public static String format(String firstName, String lastName) {
        return NameFormatter.properCasing(lastName) + ", " + NameFormatter.properCasing(firstName);
    }

    public static String format(String fullName) {
        String[] nameParts = fullName.split(" ");
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";

        switch (nameParts.length) {
            case 2:
                firstName = nameParts[0];
                lastName = nameParts[1];
                return NameFormatter.format(firstName, lastName);
            case 3:
                if (nameParts[0].contains(".")) {
                    prefix = nameParts[0].trim();
                    firstName = nameParts[1].trim();
                    lastName = nameParts[2].trim();
                } else if (nameParts[1].contains(",")) {
                    firstName = nameParts[0].trim();
                    lastName = nameParts[1].trim();
                    suffix = nameParts[2].trim();
                } else {
                    firstName = nameParts[0].trim();
                    middleName = nameParts[1].trim();
                    lastName = nameParts[2].trim();
                }
                break;
            case 4:
                if (!nameParts[0].contains(".")) {
                    firstName = nameParts[0].trim();
                    middleName = nameParts[1].trim();
                    lastName = nameParts[2].trim();
                    suffix = nameParts[3].trim();
                } else if (!nameParts[2].contains(",")) {
                    prefix = nameParts[0].trim();
                    firstName = nameParts[1].trim();
                    middleName = nameParts[2].trim();
                    lastName = nameParts[3].trim();
                } else {
                    prefix = nameParts[0].trim();
                    firstName = nameParts[1].trim();
                    lastName = nameParts[2].trim();
                    suffix = nameParts[3].trim();
                }
                break;
            case 5:
                prefix = nameParts[0].trim();
                firstName = nameParts[1].trim();
                middleName = nameParts[2].trim();
                lastName = nameParts[3].trim();
                suffix = nameParts[4].trim();
                break;
        }
        return NameFormatter.format(prefix, firstName, middleName, lastName, suffix);
    }

}
