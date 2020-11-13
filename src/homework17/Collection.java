package homework17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection implements Iterator {

    Number[] numbers;
    int index = 0;

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
        return index != numbers.length;
    }

    @Override
    public Number next() {
        return numbers[index++];
    }

    public void showFirstInnerCollection() {
        FirstInnerCollection firstInnerCollection = new FirstInnerCollection(numbers);
        while (firstInnerCollection.hasNext()) {
            if (firstInnerCollection.index % 2 == 0) {
                System.out.println(firstInnerCollection.next());
            } else {
                firstInnerCollection.numbers[firstInnerCollection.index] = 0;
                System.out.println(firstInnerCollection.next());
            }
        }
    }

    public static class FirstInnerCollection implements Iterator {

        Number[] numbers;
        int index = 0;

        public FirstInnerCollection(Number[] numbers) {
            this.numbers = numbers;
        }

        public Number[] getNumbers() {
            return numbers;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "FirstInnerCollection{" +
                    "numbers=" + Arrays.toString(numbers) +
                    '}';
        }

        @Override
        public boolean hasNext() {
            return index != numbers.length;
        }

        @Override
        public Number next() {
            return numbers[index++];
        }
    }

    public void showSecondInnerCollection() {
        SecondInnerCollection secondInnerCollection = new SecondInnerCollection(numbers);
        int length = secondInnerCollection.nums.length;
        if (length % 2 == 1) {
            while (secondInnerCollection.hasNext()) {
                if (secondInnerCollection.index == length -1 || secondInnerCollection.index % 2 == 0) {
                    System.out.println(secondInnerCollection.next());
                } else {
                    secondInnerCollection.next();
                }
            }
        } else {
            while (secondInnerCollection.hasNext()) {
                if (secondInnerCollection.index == length -1 || secondInnerCollection.index % 2 == 1) {
                    System.out.println(secondInnerCollection.next());
                } else  {
                    secondInnerCollection.next();
                }
            }
        }
    }

    public class SecondInnerCollection implements Iterator {

        Number[] nums;
        int index;

        public SecondInnerCollection(Number[] numbers) {
            this.nums = numbers;
            this.index = numbers.length - 1;
        }

        public Number[] getNumbers() {
            return numbers;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "SecondInnerCollection{" +
                    "numbers=" + Arrays.toString(numbers) +
                    '}';
        }

        @Override
        public boolean hasNext() {
            return index != -1;
        }

        @Override
        public Number next() {
            return numbers[index--];
        }
    }
}
