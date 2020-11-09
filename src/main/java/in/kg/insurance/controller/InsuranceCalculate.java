package in.kg.insurance.controller;

import in.kg.insurance.model.GeneralInfo;
import in.kg.insurance.utils.CheckUtil;
import in.kg.insurance.utils.Constants;

public class InsuranceCalculate {

    public int calculate(GeneralInfo generalInfo) {
        int pay = Constants.basicPremium;
        if (CheckUtil.isAgeBetween18To25(generalInfo.getAge())) {
            pay += CheckUtil.calculatePercentage(pay, 10);
        } else if (CheckUtil.isAgeBetween25To30(generalInfo.getAge())) {
            pay += CheckUtil.calculatePercentage(pay, 20);
        } else if (CheckUtil.isAgeBetween30To35(generalInfo.getAge())) {
            pay += CheckUtil.calculatePercentage(pay, 30);
        } else if (CheckUtil.isAgeBetween35To40(generalInfo.getAge())) {
            pay += CheckUtil.calculatePercentage(pay, 40);
        } else if (CheckUtil.isAgeAbove40(generalInfo.getAge())) {
            int percentage = CheckUtil.getPercentage(generalInfo.getAge());
            pay += CheckUtil.calculatePercentage(pay, percentage);
        }

        // 2% increase for Male
        if (CheckUtil.isMale(generalInfo.getGender())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 2);
        }

        // 1 % increase for each Condition
        if (CheckUtil.isTrue(generalInfo.getCurrentHealth().getHypertension())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 1);
        }
        if (CheckUtil.isTrue(generalInfo.getCurrentHealth().getBloodPressure())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 1);
        }
        if (CheckUtil.isTrue(generalInfo.getCurrentHealth().getBloodSugar())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 1);
        }
        if (CheckUtil.isTrue(generalInfo.getCurrentHealth().getOverweight())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 1);
        }

        // BAD Habit 3% increase
        if (CheckUtil.isTrue(generalInfo.getHabits().getSmoking())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 3);
        }
        if (CheckUtil.isTrue(generalInfo.getHabits().getAlcohol())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 3);
        }
        if (CheckUtil.isTrue(generalInfo.getHabits().getDrugs())) {
            pay += CheckUtil.calculatePercentage(Constants.basicPremium, 3);
        }

        // GOOD Habit 3% Decrease
        if (CheckUtil.isTrue(generalInfo.getHabits().getDailyExercise())) {
            pay -= CheckUtil.calculatePercentage(Constants.basicPremium, 3);
        }
        return pay;
    }

}
