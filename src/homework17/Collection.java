package homework17;

import java.util.Arrays;

public class Collection implements Iterator{

    Number[] numbers;

    public Collection(Number[] numbers) {
        this.numbers = numbers;
    }

    public Number[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Number[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    @Override
    public boolean hasNext() {
        
        return false;
    }

    @Override
    public Number[] next() {
        return numbers;
    }
}
