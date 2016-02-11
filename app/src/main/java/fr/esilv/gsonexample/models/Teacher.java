package fr.esilv.gsonexample.models;

import com.google.gson.annotations.SerializedName;

public class Teacher {
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;

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
}
