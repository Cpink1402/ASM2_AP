/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author khanh
 */

import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Employee[] employees = new Employee[100];
        int numOfEmployees = 0;

        while (!exit) {
            System.out.println("***********************************");
            System.out.println("*           Main Menu             *");
            System.out.println("*   1. Add Employee               *");
            System.out.println("*   2. Edit Employee              *");
            System.out.println("*   3. Delete Employee            *");
            System.out.println("*   4. Display Employees          *");
            System.out.println("*   5. Exit                       *");
            System.out.println("***********************************");
            System.out.print("      Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading integer input
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Adding an Employee..");
System.out.print("Enter Employee ID: ");
int id;
try {
    id = Integer.parseInt(scanner.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Invalid input for Employee ID! Please try again.");
    break;
}

System.out.print("Enter Employee Name: ");
String name = scanner.nextLine();
System.out.print("Enter Employee Position: ");
String position = scanner.nextLine();
System.out.print("Enter Employee Salary: ");
double salary;
try {
    salary = Double.parseDouble(scanner.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Invalid input for Employee Salary! Please try again.");
    break;
}

System.out.println("Select Employee Type:");
System.out.println("1.Manager");
System.out.println("2. SalesPerson");
System.out.println("3. Baker");
int empType;
try {
    empType = Integer.parseInt(scanner.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Invalid input for Employee Type! Please try again.");
    break;
}

switch(empType) {
    case 1:
        System.out.print("Enter Manager Bonus: ");
        double bonus;
        try {
            bonus = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Manager Bonus! Please try again.");
            break;
        }
        employees[numOfEmployees++] = new Manager(id, name, position, salary, bonus);
        System.out.println("Manager added successfully!");
        break;
    case 2:
        System.out.print("Enter SalesPerson Commission Rate: ");
        double commissionRate;
        try {
            commissionRate = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for SalesPerson Commission Rate! Please try again.");
            break;
        }
        System.out.print("Enter SalesPerson Total Sales: ");
        double totalSales;
        try {
            totalSales = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for SalesPerson Total Sales! Please try again.");
            break;
        }
        employees[numOfEmployees++] = new SalesPerson(id, name, position, salary, commissionRate, totalSales);
        System.out.println("SalesPerson added successfully!");
        break;
    case 3:
        System.out.print("Enter Baker Specialty: ");
        String specialty = scanner.nextLine();
        employees[numOfEmployees++] = new Baker(id, name, position, salary, specialty);
        System.out.println("Baker added successfully!");
        break;
    default:
        System.out.println("Invalid input! Please try again.");
}

                    break;
                case 2:
                    if (numOfEmployees == 0) {
                        System.out.println("No employees to edit.");
                        break;
                    }
                    System.out.print("Enter Employee ID to edit: ");
                    int editId = Integer.parseInt(scanner.nextLine());
                    boolean found = false;
                    for (int i = 0; i < numOfEmployees; i++) {
                        if (employees[i].getId() == editId) {
                            System.out.println("Employee found!");
                            System.out.print("Enter new Employee Name: ");
                            employees[i].setName(scanner.nextLine());
                            System.out.print("Enter new Employee Position: ");
                            employees[i].setPosition(scanner.nextLine());
                            System.out.print("Enter new Employee Salary: ");
                            employees[i].setSalary(Double.parseDouble(scanner.nextLine()));
                            found = true;
                            System.out.println("Employee details updated successfully!");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    if (numOfEmployees == 0) {
                        System.out.println("No employees to delete.");
                        break;
                    }
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    found = false;
                    for (int i = 0; i < numOfEmployees; i++) {
                        if (employees[i].getId() == deleteId) {
                            System.out.println("Employee found!");
                            for (int j = i; j < numOfEmployees - 1; j++) {
                                employees[j] = employees[j + 1];
                            }
                            numOfEmployees--;
                            found = true;
                            System.out.println("Employee deleted successfully!");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    // Display Employees
                    System.out.println("**************************************************************************");
                    System.out.println("*                           Displaying Employees                         *");
                    System.out.println("*------------------------------------------------------------------------*");
                    System.out.println("|  Employee ID | Employee Name   | Employee Position | Employee Salary   |");
                    System.out.println("*------------------------------------------------------------------------*");
                    for (int i = 0; i < numOfEmployees; i++) {
                        Employee employee = employees[i];
                        System.out.printf("|  %-12d| %-15s | %-18s| %.1f             |\n", employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary());
                    }
                    System.out.println("*------------------------------------------------------------------------*");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input! Please try again.");
            }
        }

        scanner.close();
    }
}





