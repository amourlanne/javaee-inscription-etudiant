package entity;

import java.util.Date;
import java.util.List;

/**
 * Class Registration
 * Created by Alexis on 28/03/2019
 */
public class Registration {

    private String firstName;
    private String lastName;
    private String level;

    public Registration(String firstName, String lastName, String level) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
