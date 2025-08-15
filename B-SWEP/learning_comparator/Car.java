public class Car
{
    int price;
    int rarity;

    public Car(int price, int rarity)
    {
        this.price = price;
        this.rarity = rarity;

    }

    public int getPrice()
    {
        return this.price;
    }
    public int getRarity()
    {
        return this.rarity;
    }

    @Override
    public String toString()
    {
        return "Price: " + price + ", Rarity: " + rarity;
    }




}