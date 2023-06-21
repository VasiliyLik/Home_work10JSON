package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jackson.BooleanHealthyDeserializer;
import jackson.BooleanHealthySerializer;

import java.util.Date;
import java.util.Objects;

public record Patient(String name, String surName, @JsonFormat(pattern = "dd-MM-yyyy") Date birthDate,
                      @JsonSerialize(using = BooleanHealthySerializer.class) @JsonDeserialize(using = BooleanHealthyDeserializer.class) boolean health) implements Comparable<Patient> {
    public Patient(String name, String surName, Date birthDate, boolean health) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.health = health;
    }

    @Override
    public Date birthDate() {
        return birthDate;
    }

    @Override
    public boolean health() {
        return health;
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
        return Objects.equals(name(), patient.name()) && Objects.equals(surName(), patient.surName()) && Objects.equals(birthDate(), patient.birthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name(), surName(), birthDate());
    }

    @Override
    public int compareTo(Patient other) {
        return this.birthDate.compareTo(other.birthDate);
    }
}
