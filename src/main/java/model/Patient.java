package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jackson.BooleanHealthyDeserializer;
import jackson.BooleanHealthySerializer;

import java.util.Date;
import java.util.Objects;

public class Patient implements Comparable<Patient> {
    private String name;
    private String surName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthDate;
    @JsonSerialize(using = BooleanHealthySerializer.class)
    @JsonDeserialize(using = BooleanHealthyDeserializer.class)
    private boolean health;

    public Patient() {
    }

    public Patient(String name, String surName, Date birthDate, boolean health) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDate=" + birthDate +
                ", health=" + health +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(getName(), patient.getName()) && Objects.equals(getSurName(), patient.getSurName()) && Objects.equals(getBirthDate(), patient.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurName(), getBirthDate());
    }
    @Override
    public int compareTo(Patient other) {
        return this.birthDate.compareTo(other.birthDate);
    }
}
