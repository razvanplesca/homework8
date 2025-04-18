package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {

    private static Logger logger = Logger.getLogger(Student.class.getName());
    private String firstName;
    private String lastName;
    private char gender;
    private long id;
    private int yearOfBirth;

    public int getAge() {
        return 2025-yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%c) %d (%d)", lastName, firstName, gender, id, getAge());
    }
}
