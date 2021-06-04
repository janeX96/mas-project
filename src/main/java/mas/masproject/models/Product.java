package mas.masproject.models;

public abstract class Product {
    private double prize;
    private static int count;

    public Product(double prize) {
        this.prize = prize;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }
}
