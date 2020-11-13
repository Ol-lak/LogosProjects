package homework17;

public class Main {
    public static void main(String[] args) {

        Number[] nums = {1,2,4,6};
        Collection collection = new Collection(nums);
        System.out.println("-------------------First inner collection----------------");
        collection.showFirstInnerCollection();
        System.out.println("-------------------Second inner collection----------------");
        Number[] numbers = {1,2,5,6,7};
        Collection collection1 = new Collection(numbers);
        collection1.showSecondInnerCollection();
    }
}
