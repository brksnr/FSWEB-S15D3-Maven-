package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        List<Employee> duplicatedEmployees = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("null record");
                continue;
            }
            employeeMap.putIfAbsent(employee.getId(), employee);
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();
        Set<Integer> duplicateIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("null record");
                continue;
            }
            if (duplicateIds.contains(employee.getId())) {
                continue;
            }
            if (uniques.containsKey(employee.getId())) {
                uniques.remove(employee.getId());
                duplicateIds.add(employee.getId());
            } else {
                uniques.put(employee.getId(), employee);
            }
        }
        return new ArrayList<>(uniques.values());
    }


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "berk", "sener"));
        employees.add(new Employee(1, "berke", "sener"));
        employees.add(new Employee(3, "berkem", "sener"));
        employees.add(new Employee(4, "berkel", "sener"));
        employees.add(new Employee(5, "berkes", "sener"));
        employees.add(new Employee(1, "berk", "sener"));
        employees.add(new Employee(2, "berkem", "sener"));
        employees.add(new Employee(6, "berke", "sener"));
        employees.add(new Employee(4, "bersdskel", "sener"));
        employees.add(new Employee(5, "berdskes", "sener"));
    }
}
