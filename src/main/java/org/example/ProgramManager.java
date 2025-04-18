package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class ProgramManager {

    private static Logger logger = Logger.getLogger(ProgramManager.class.getName());
    void run() {
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1-Add Student");
            System.out.println("2-Delete Student by ID");
            System.out.println("3-Retrieve students by age");
            System.out.println("4-List students alphabetically by last name");
            System.out.println("0-Exit");

            int inputType;
            try {
                inputType = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                logger.log(Level.INFO, "Invalid input");
                System.out.println("Please enter a valid number.");
                continue;
            }


            if (inputType == 0) {
                break;
            }

            switch (inputType) {
                case 1:
                    repository.addStudent(scanner);
                    break;
                case 2:
                    repository.deleteStudent(scanner);
                    break;
                case 3:
                    repository.retrieveStudentByAge(scanner);
                    break;
                case 4:
                    repository.displayStudents();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
