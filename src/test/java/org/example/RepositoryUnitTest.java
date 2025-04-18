package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
class RepositoryUnitTest {


    @Test
    void AddStudentSuccessfully() {
        // given
        final Student student1 = new Student("John","Doe",'m', 1921125020070L,1920);
        final Set<Student> students = new TreeSet<>(new StudentComparatorByLastName());

        // when
        students.add(student1);

        // then
        assertTrue(students.contains(student1));
    }




    @Test
    void displayStudentsByLastName() {
        // given
        final Student student1 = new Student("John","Doe",'m', 1921125020070L,1920);
        final Student student2 = new Student("Jane","Maine",'f', 1921125020071L,1921);

        final Set<Student> students = new TreeSet<>(new StudentComparatorByLastName());
        students.add(student1);
        students.add(student2);
        //when
        final List<Student> sortedStudents = new ArrayList<>(students);
        //then
        assertEquals(sortedStudents.get(0),student1);
    }

    @Test
    void deleteStudentSuccessfully() {
        //given
final Student student1 = new Student("John","Doe",'m', 1921125020070L,1920);
final Set<Student> students = new TreeSet<>(new StudentComparatorByLastName());
students.add(student1);

//when
students.remove(student1);
//then
assertFalse(students.contains(student1));

    }

    @Test
    void retrieveStudentByAgeSuccessfully() {
        //given
        final Student student1 = new Student("John","Doe",'m', 1921125020070L,1990);
        final Set<Student> students = new TreeSet<>(new StudentComparatorByLastName());
        students.add(student1);

        //then
        assertEquals(student1.getAge(),35);
    }
}