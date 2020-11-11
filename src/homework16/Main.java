package homework16;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Human human = new Human("Aaaa", 42);
        Field ageField = human.getClass().getDeclaredField("age");
        ageField.setAccessible(true);
        int age = 26;
        ageField.setInt(human, age);
        Field nameField = human.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        String name = "Petro";
        nameField.set(human, name);
        System.out.println(human);

        Method changeHuman = human.getClass().getMethod("changeHuman", String.class, int.class);
        changeHuman.setAccessible(true);
        changeHuman.invoke(human, "Ivan", 24);
        System.out.println(human);
    }
}
