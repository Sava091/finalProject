package com.vitaliy.training.finalProject.service;

import com.vitaliy.training.finalProject.model.Client;
import com.vitaliy.training.finalProject.model.Meal;
import com.vitaliy.training.finalProject.model.Sex;

import java.util.Date;
import java.util.List;

public class CaloriesService {
    /*
    Мужчина
    BMR = 88.36 + (13.4 x вес, кг) + (4.8 х рост, см) – (5.7 х возраст, лет)
    BMR = 88.36 + (13.4 x 72) + (4.8 x 178) – (5.7 x 25) = 1765 ккал
    Женщина
    BMR = 447.6 + (9.2 x вес, кг) + (3.1 х рост, cм) – (4.3 х возраст, лет)
    BMR = 447.6 + (9.2 x 50) + (3.1 x 172) – (4.3 x 25) = 1333 ккал

     */
    public double calcCaloriesOverhead(Client client, Date date, List<Meal> meal) {
        double coef0 = 88.36;
        double coef1 = 13.4;
        double coef2 = 4.8;
        double coef3 = 5.7;

        if (client.getSex() == Sex.WOMAN) {
            coef0 = 447.6;
            coef1 = 9.2;
            coef2 = 3.1;
            coef3 = 4.3;
        }
        double maxDailyBmr = coef0 + (coef1 * client.getWeight()) + (coef2 * client.getHeight()) - (coef3 * client.getAge());
        double maxCalories = maxDailyBmr * client.getActivity().getValue();
        double dateCaloriesCount = meal.stream()
                .filter(m -> m.getDate().equals(date))
                .mapToDouble(m -> m.getProduct().getCaloriesPer100gr() * m.getQuantityOf100grPortions())
                .sum();
        return dateCaloriesCount - maxCalories;
    }
}
