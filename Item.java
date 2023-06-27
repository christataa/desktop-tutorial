public class Item {
    //this is a model class

    private String itemName;
    private int amount;
    private double cost;
    private int calories;

    public Item(String itemName, int amount, double cost, int calories){
        this.itemName = itemName;
        this.amount = amount;
        this.cost = cost;
        this.calories = calories;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getAmount() {
        return this.amount;
    }

    public double getCost() {
        return this.cost;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}