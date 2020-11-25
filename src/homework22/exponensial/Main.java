package homework22.exponensial;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<Double> consumer = (x) -> System.out.println(Math.exp(x));
        consumer.accept(Double.MIN_VALUE);
        consumer.accept(Double.MAX_VALUE);
        Consumer<Float> floatConsumer = (x) -> System.out.println(Math.exp(x));
        floatConsumer.accept(Float.MIN_VALUE);
        floatConsumer.accept(Float.MAX_VALUE);
    }
}
