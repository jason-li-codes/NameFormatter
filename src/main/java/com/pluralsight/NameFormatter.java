package com.pluralsight;

public class NameFormatter {

    private NameFormatter() {
    }

    // private method for proper capitalization
    private static String properCasing(String namePart) {
        if (!namePart.isEmpty()) {
            return Character.toUpperCase(namePart.charAt(0)) + namePart.substring(1).toLowerCase();
        } else {
            return namePart;
        }
    }

    // first format method with 5 parameters
    public static String format(String prefix, String firstName,
                                String middleName, String lastName, String suffix) {
        // trims each parameter name
        prefix = prefix.trim();
        firstName = firstName.trim();
        middleName = middleName.trim();
        lastName = lastName.trim();
        suffix = suffix.trim();
        // starts with last name, which we assume will never be empty
        String formattedName = NameFormatter.properCasing(lastName).replace(",", "") + ", ";
        // only adds prefix if prefix String is not empty, with proper formatting
        if (!prefix.isEmpty()) {
            formattedName += NameFormatter.properCasing(prefix).replace(".", "") + ". ";
        }
        // adds first name, which we assume will never be empty, with proper formatting
        formattedName += NameFormatter.properCasing(firstName);
        // adds middle and last name with proper formatting if they are not empty Strings
        if (!middleName.isEmpty()) {
            formattedName += " " + NameFormatter.properCasing(middleName);
        }
        if (!suffix.isEmpty()) {
            formattedName += ", " + suffix;
        }
        // returns formattedName
        return formattedName;
    }

    // format method can take only 2 parameters and calls on overloaded method to format
    public static String format(String firstName, String lastName) {
        return NameFormatter.format("", firstName, "", lastName, "");
    }

    // format with only one parameter takes in a full name and reformats it
    public static String format(String fullName) {
        // splits fullName into its parts with " "
        String[] nameParts = fullName.split(" ");
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";
        // assigns parsed Strings depending on how many there are
        switch (nameParts.length) {
            case 2:
                firstName = nameParts[0];
                lastName = nameParts[1];
                break;
            case 3:
                if (nameParts[0].contains(".")) { // checks if first part contains ".", which would make it a prefix
                    prefix = nameParts[0];
                    firstName = nameParts[1];
                    lastName = nameParts[2];
                } else if (nameParts[1].contains(",")) { // checks if second part contains ",", which would make it a last name
                    firstName = nameParts[0];
                    lastName = nameParts[1];
                    suffix = nameParts[2];
                } else { // otherwise, the middle element is a middleName
                    firstName = nameParts[0];
                    middleName = nameParts[1];
                    lastName = nameParts[2];
                }
                break;
            case 4:
                if (!nameParts[0].contains(".")) { // checks if first part contains ".", otherwise there is no prefix
                    firstName = nameParts[0];
                    middleName = nameParts[1];
                    lastName = nameParts[2];
                    suffix = nameParts[3];
                } else if (!nameParts[2].contains(",")) { // checks if third part contains ",", otherwise there is no suffix
                    prefix = nameParts[0];
                    firstName = nameParts[1];
                    middleName = nameParts[2];
                    lastName = nameParts[3];
                } else { // otherwise, there is no middleName
                    prefix = nameParts[0];
                    firstName = nameParts[1];
                    lastName = nameParts[2];
                    suffix = nameParts[3];
                }
                break;
            case 5: // if there are 5 Strings, all possible name parts are present
                prefix = nameParts[0];
                firstName = nameParts[1];
                middleName = nameParts[2];
                lastName = nameParts[3];
                suffix = nameParts[4];
                break;
        }
        // returns formatted name by calling on overloaded format method
        return NameFormatter.format(prefix, firstName, middleName, lastName, suffix);
    }

}
