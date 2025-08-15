import java.util.*;
public class main
{
    public static void main(String[] args)
    {
        // Initialize List of Car objects

        List<Car> cars = Arrays.asList(
            new Car(5000,5),
            new Car(10000,10),
            new Car(100, 12),
            new Car(100, 13),
            new Car(100, 14),
            new Car(1000000,100000)
        );

        // Sort by price
        List<Car> sorted_by_price = new ArrayList<>(cars);
        sorted_by_price.sort(Comparator.comparing(Car::getPrice));
        printList(sorted_by_price);

        // Sort by rarity
        List<Car> sorted_by_rarity = new ArrayList<>(cars);
        sorted_by_rarity.sort(Comparator.comparing(Car::getRarity));
        printList(sorted_by_rarity);

        // Most Expensive Car
        System.out.println(" I want the most expensive car");
        List<Car> descending_price = new ArrayList<>(cars);
        descending_price.sort(Comparator.comparing(Car::getPrice).reversed());
        System.out.println(descending_price.get(0).toString());


        // Price then Rarity
        System.out.println(" I want the most affordable car, but also the most rare for that price.");
        List<Car> price_rarity_sorted = new ArrayList<>(cars);
        price_rarity_sorted.sort(Comparator.comparing(Car::getPrice).thenComparing(Comparator.comparing(Car::getRarity).reversed()));
        System.out.println(price_rarity_sorted.get(0).toString());

        


    }

    public static void printList(List<Car> car_list)
    {
        for (Car car : car_list)
        {
            System.out.println(car.toString());
        }
    }

}