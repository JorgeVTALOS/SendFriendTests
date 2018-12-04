package generator;

import com.mifmif.common.regex.Generex;

public class DataGenerator {

    public static String getValidFullName() {
        return new Generex("[a-zA-Z]{3,}[ ][a-zA-Z]{3,}").random();
    }

    public static String getInvalidFullName() {
        return new Generex("(([a-zA-Z]{3,})|([ ][a-zA-Z]{3,})|([a-zA-Z]{3,}[ ]))").random();
    }

    public static String getValidEmail() {
        return new Generex("([a-z0-9]{3,})[@]([a-z]|([a-z][.][a-z])){2,}").random();
    }

    public static String getInvalidEmail() {
        return new Generex("(([a-z0-9]{3,})(([a-z][.][a-z])){2,}|([@][a-z0-9]{2,})|([a-z0-9]{2,}[@]|[@][a-z0-9]{2,}[.]))").random();
    }

    public static String getValidPassword() {
        return new Generex("([a-z]{5,}[A-Z]{1,1}[0-9]{1,1}[#$%]{1,1})").random();
    }

    public static String getInvalidPassword() {
        return new Generex("([a-zA-Z0-9]{5,})").random();
    }

    public static String getValidPhoneNumber() {
        return new Generex("[0-9]{8,10}").random();
    }

    public static String getInvalidPhoneNumber() {
        return new Generex("([0-9]{2,5})|([a-zA-Z0-9]{6,})").random();
    }

    public static String getValidZipCode() {
        return new Generex("[0-9]{5,5}").random();
    }

    public static String getInvalidZipCode() {
        return new Generex("([0-9]{6,})|([a-zA-Z0-9]{6,})").random();
    }

}
