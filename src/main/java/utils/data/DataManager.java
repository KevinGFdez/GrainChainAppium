package utils.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataManager {
    private static Faker faker = new Faker(new Locale("es-MX"));

    public static String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    public static String getRandomNumber(int digits){
        return faker.number().digits(digits);
    }
}
