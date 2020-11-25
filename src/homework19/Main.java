package homework19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Methods methods = new Methods();
        Employee employee = new Employee("Petro", 1, 5431);
        System.out.println("----------------Employee deserialize-------------------");
        methods.serialize(employee);
        methods.deserialize();

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Oleg", 9, 3521));
        employees.add(new Employee("Ivan", 15, 7652));
        employees.add(new Employee("Nazar", 2, 14568));
        employees.add(new Employee("Taras", 7, 8671));
        System.out.println("----------------Collection deserialize-------------------");
        methods.serializeCollection(employees);
        methods.deserializeCollection();
    }
}
