package org.example;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

class Repository {

    private static Logger logger = Logger.getLogger(Repository.class.getName());
    private final Set<Student> students;

    public Repository() {
        students = new TreeSet<>(new StudentComparatorByLastName());

        students.add(new Student("razvan", "plesca", 'm', 1821125020070L, 1982));
        students.add(new Student("mirela", "mirel", 'f', 1871125020071L, 1984));
        students.add(new Student("george", "george", 'm', 1881125020072L, 1986));
        students.add(new Student("dana", "dana", 'f', 1891125020073L, 1988));
    }

    void addStudent(Scanner scanner) {
        try {
            System.out.println("Enter first name:");
            String firstName = scanner.nextLine();
            if (firstName.trim().isBlank()) {
                logger.log(Level.INFO, "First name is blank");
                throw new IllegalArgumentException("First name cannot be null");
            }

            System.out.println("Enter last name:");
            String lastName = scanner.nextLine();
            if (lastName.trim().isBlank()) {
                logger.log(Level.INFO, "Last name is blank");
                throw new IllegalArgumentException("Last name cannot be null");
            }

            System.out.println("Enter gender (m/f):");
            String genderInput = scanner.nextLine().toLowerCase();
            if (genderInput.isEmpty()) {
                logger.log(Level.INFO, "Gender is blank");
                throw new IllegalArgumentException("Gender cannot be null");
            }
            char gender = genderInput.charAt(0);
            if (gender != 'm' && gender != 'f') {
                logger.log(Level.INFO, "Gender is not valid");
                throw new IllegalArgumentException("Gender must be 'm' or 'f'");
            }

            System.out.println("Enter id (13-digit number):");
            String idInput = scanner.nextLine();
            long id;
            try {
                id = Long.parseLong(idInput);
                if (String.valueOf(id).length() != 13) {
                    logger.log(Level.INFO, "ID is not valid");
                    throw new IllegalArgumentException("ID must be a 13-digit number");
                }
            } catch (NumberFormatException e) {

                throw new IllegalArgumentException("ID must be a valid number");
            }

            System.out.println("Enter year of birth:");
            String yearInput = scanner.nextLine();
            int yearOfBirth;
            try {
                yearOfBirth = Integer.parseInt(yearInput);
                if (yearOfBirth < 1900 || yearOfBirth > 2007) {
                    logger.log(Level.INFO, "Year of birth is not valid");
                    throw new MyCustomException("Year of birth must be between 1900 and 2007");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Year must be a valid number");
            }

            Student student = new Student(firstName, lastName, gender, id, yearOfBirth);
            students.add(student);
            System.out.println("Student added successfully!");

        } catch (IllegalArgumentException | MyCustomException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    void displayStudents() {
        if (students.isEmpty()) {
            logger.log(Level.INFO, "No students found");
            System.out.println("No students found!");
        }
        for (Student student : students) {
            System.out.println(student);
        }

    }

    void deleteStudent(Scanner scanner) {
        try {
            System.out.println("Enter id (13-digit number):");
            String idInput = scanner.nextLine();
            checkId(idInput);
        } catch (IllegalArgumentException e) {
            throw new MyCustomException(e.getMessage());
        }
    }

    private void checkId(String idInput) {
        if (idInput == null) {
            logger.log(Level.INFO, "ID is null");
            throw new MyCustomException("ID cannot be null");
        }

        long id;
        try {
            id = Long.parseLong(idInput);
            if (id <= 0) {
                logger.log(Level.INFO, "ID is not valid");
                throw new MyCustomException("ID must be a positive number");
            }
            if (String.valueOf(id).length() != 13) {
                logger.log(Level.INFO, "ID is not valid");
                throw new MyCustomException("ID must be a 13-digit number");
            }

            boolean found = false;
            for (Student student : students) {
                if (student.getId() == id) {
                    students.remove(student);
                    System.out.println("Student deleted successfully!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                logger.log(Level.INFO, "No student with ID " + id);
                throw new IllegalArgumentException("No student with ID " + id);
            }
        } catch (NumberFormatException e) {
            throw new MyCustomException("ID must be a valid number");
        }
    }


    void retrieveStudentByAge(Scanner scanner) {
        try {
            System.out.println("Enter age:");
            if(Integer.parseInt(scanner.nextLine()) <=0 ){
                logger.log(Level.INFO, "Age is not valid");
                throw new MyCustomException("Age must be a positive number");
            }
            int age = Integer.parseInt(scanner.nextLine());
            boolean found = false;

            if (students == null) {
                logger.log(Level.INFO, "No students found");
                throw new IllegalArgumentException("No students found!");
            }

            for (Student student : students) {
                if (student.getAge() == age) {
                    System.out.println(student);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No students with age " + age);
            }
        } catch (NumberFormatException e) {
            logger.log(Level.INFO, "Age is not valid");
            throw new MyCustomException("Age must be a valid number");
        }
    }

}
