package org.example;

import org.apache.commons.lang3.StringUtils;

public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private static int counter = 0;
    private int id;


    public Employee(String fullName, int department, int salary) {
        if (StringUtils.isAnyBlank(fullName)) {
            throw new IllegalArgumentException("Full name cannot be blank");
        }

        String[] nameParts = fullName.split(" ");
        StringBuilder formattedName = new StringBuilder();

        for (String part : nameParts) {
            if (StringUtils.isNotBlank(part)) {
                formattedName.append(StringUtils.capitalize(part.trim())).append(" ");
            }
        }

        if (formattedName.length() == 0) {
            throw new IllegalArgumentException("Invalid full name");
        }

        this.fullName = formattedName.toString().trim();
        this.department = department;
        this.salary = salary;
        this.id = counter++;

    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void SetDepartment(int department) {
        this.department = department;
    }

    public void SetSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final String s = "Employee " +
                "fullName='" + fullName + '\'' + ", " +
                "department=" + department +
                ", salary=" + salary +
                ", id=" + id;
        return s;
    }

    public static void getAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }
}