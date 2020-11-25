package homework23;

import java.util.Objects;

public class Pet {
    private String type;
    private String name;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pet(String type, String name) {
        this.type = type;
        this.name = name;
    }
    public Pet() {

    }
    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return type.equals(pet.type) &&
                name.equals(pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
