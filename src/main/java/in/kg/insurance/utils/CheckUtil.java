package in.kg.insurance.utils;

import java.lang.module.Configuration;

public class CheckUtil {

    public static boolean isMale(String gender) {
        return Constants.MaleGender.contains(gender.toUpperCase());
    }

    public static boolean isAgeBelow18(int age) {
        return age <= 18;
    }

    public static boolean isAgeBetween18To25(int age) {
        return age > 18 && age <= 25;
    }

    public static boolean isAgeBetween25To30(int age) {
        return age > 25 && age <= 30;
    }

    public static boolean isAgeBetween30To35(int age) {
        return age > 30 && age <= 35;
    }

    public static boolean isAgeBetween35To40(int age) {
        return age > 35 && age <= 40;
    }

    public static boolean isAgeAbove40(int age) {
        return age > 40;
    }

    public static boolean isTrue(String value) {
        return Constants.True.contains(value.toUpperCase());
    }

    public static int calculatePercentage(int pay, int percentage) {
        double per = (percentage / 100d);
        percentage = (int) (pay * per);
        return percentage;

    }

    public static int getPercentage(int age) {
        int limit = 40;
        int percentage = 40;

        while (age > limit) {
            percentage += 20;
            limit += 5;
        }
        return percentage;
    }
}
