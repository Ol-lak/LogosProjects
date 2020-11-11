package homework14;

import java.util.Objects;

public class Commodity implements Comparable<Commodity> {
    private String name;
    private int length;
    private int height;
    private int weight;

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Commodity(String name, int length, int height, int weight) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.weight = weight;
    }

    public Commodity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return length == commodity.length &&
                height == commodity.height &&
                weight == commodity.weight &&
                name.equals(commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, height, weight);
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Commodity o) {
        int nameComp = this.name.compareTo(o.name);
        if (nameComp == 0) {
            int lengthComp = this.length - o.length;
            if (lengthComp == 0) {
                int heightComp = this.height - o.height;
                if (heightComp == 0) {
                    return this.weight - o.weight;
                } else {
                    return heightComp;
                }
            } else {
                return lengthComp;
            }
        } else {
            return nameComp;
        }
    }
}
