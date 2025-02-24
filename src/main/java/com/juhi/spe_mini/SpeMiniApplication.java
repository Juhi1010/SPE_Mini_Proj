package com.juhi.spe_mini;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//public class SpeMiniApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpeMiniApplication.class, args);
//    }
//
//}


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Scanner;

//public class SpeMiniApplication implements CommandLineRunner {

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpeMiniApplication {

    public static void main(String[] args) {
        // Skip execution during Jenkins build
        if (System.getenv("JENKINS_HOME") != null) {
            return;
        }

        // CLI menu logic (only runs when executed manually)
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter value x: ");
            double x = scanner.nextDouble();

            switch (choice) {
                case 1 -> System.out.println("√" + x + " = " + Math.sqrt(x));
                case 2 -> System.out.println(x + "! = " + factorial((int) x));
                case 3 -> System.out.println("ln(" + x + ") = " + Math.log(x));
                case 4 -> {
                    System.out.print("Enter value b: ");
                    double b = scanner.nextDouble();
                    System.out.println(x + "^" + b + " = " + Math.pow(x, b));
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }

    private static long factorial(int num) {
        if (num == 0 || num == 1) return 1;
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}


//    public static void main(String[] args) {
//        SpringApplication.run(SpeMiniApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\n--- Scientific Calculator ---");
//            System.out.println("1. Square Root (√x)");
//            System.out.println("2. Factorial (x!)");
//            System.out.println("3. Natural Logarithm (ln x)");
//            System.out.println("4. Power Function (x^b)");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//
//            if (choice == 5) {
//                System.out.println("Exiting...");
//                break;
//            }
//
//            System.out.print("Enter value x: ");
//            double x = scanner.nextDouble();
//
//            switch (choice) {
//                case 1 -> System.out.println("√" + x + " = " + Math.sqrt(x));
//                case 2 -> System.out.println(x + "! = " + factorial((int) x));
//                case 3 -> System.out.println("ln(" + x + ") = " + Math.log(x));
//                case 4 -> {
//                    System.out.print("Enter value b: ");
//                    double b = scanner.nextDouble();
//                    System.out.println(x + "^" + b + " = " + Math.pow(x, b));
//                }
//                default -> System.out.println("Invalid choice! Try again.");
//            }
//        }
//        scanner.close();
//    }
//
//    private static long factorial(int num) {
//        if (num == 0 || num == 1) return 1;
//        long result = 1;
//        for (int i = 2; i <= num; i++) {
//            result *= i;
//        }
//        return result;
//    }
//}

