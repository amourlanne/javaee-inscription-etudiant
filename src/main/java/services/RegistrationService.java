package services;

import entity.Registration;
import exception.InvalidFormException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class RegistrationService
 * Created by Alexis on 10/04/2019
 */
public class RegistrationService {

    public static Registration register(String firstName, String lastName, String level) throws InvalidFormException {
        InvalidFormException ex = new InvalidFormException();

        if(firstName  == null || firstName.equals("")) {
            ex.addMessage("firstName","Firstname is required.");
        }

        if(lastName == null || lastName.equals("")) {
            ex.addMessage("lastName", "Lastname is required.");
        }

        if(level == null || level.equals("")) {
            ex.addMessage("level", "Level is required.");
        }

        if (ex.mustBeThrown()) {
            throw ex;
        }

        return new Registration(firstName, lastName, level);
    }

    public static List<String> getLevels(){
       return new ArrayList<>() {{
           add("Bachelor - Niveau 1");
           add("Bachelor - Niveau 2");
           add("Bachelor - Niveau 3");
           add("Ingénieur - Niveau 1");
           add("Ingénieur - Niveau 2");
       }};
    }


}
