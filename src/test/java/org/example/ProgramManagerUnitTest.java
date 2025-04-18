package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class ProgramManagerUnitTest {

    @Test
    void runSuccesfully() {
        //given
        final Student student = new Student("John","Doe",'m', 1921125020070L,1920);
        final Set<Student> students = new TreeSet<>(new StudentComparatorByLastName());
        //when
       students.add(student);
        //then
        assertTrue(students.contains(student));

    }
}