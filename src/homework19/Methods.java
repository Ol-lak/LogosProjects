package homework19;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Methods {

    public void serialize(Employee employee) {

        try {
            OutputStream outputStream = new FileOutputStream("resourses//employee.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserialize() {
        try {
            InputStream inputStream = new FileInputStream("resourses//employee.txt");
            ObjectInput objectInput = new ObjectInputStream(inputStream);

            Employee readEmployee = (Employee) objectInput.readObject();
            System.out.println(readEmployee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void serializeCollection(List<Employee> employee) {

        try {
            OutputStream outputStream = new FileOutputStream("resourses//list-employee.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserializeCollection() {
        List<Employee> employees = new ArrayList<>();
        try {
            InputStream inputStream = new FileInputStream("resourses//list-employee.txt");
            ObjectInput objectInput = new ObjectInputStream(inputStream);

            employees = (ArrayList) objectInput.readObject();
            Iterator<Employee> iterator = employees.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
