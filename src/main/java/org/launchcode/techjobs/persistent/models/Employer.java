package org.launchcode.techjobs.persistent.models;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

@Entity
public class Employer extends AbstractEntity {

    // Ensures location is not blank
    @NotBlank
    @Size(min=3)
    private String location;

    // Constructor
    public Employer() {}

    // Get/Setters
    public String getLocation() {return this.location;}
    public void setLocation(String location) {this.location = location;}
}
