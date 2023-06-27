import java.util.ArrayList;
//this is a model class

public class Cart {
    private ArrayList<Item> itemBought;
    private int numOfItems;
    private boolean paid;

    public Cart(){
        this.itemBought = new ArrayList<>();
        this.itemBought.clear();
        this.paid = false;
    }

    public void addItems(Item item) {
        for (Item i : itemBought) {
            if (i.getItemName().equals(item.getItemName())) {
                i.setAmount(i.getAmount() + item.getAmount());
            } else {
                this.itemBought.add(item);
            }
        }
    }

    public int NumOfItems() {
        return this.itemBought.size();
    }
    public Item getItemBought(String name){
        int i =0;
        boolean found = false;
        for (i =0; i<this.itemBought.size() && !found; i++){
            if (this.itemBought.get(i).getItemName().equals(name)){
                found = true;
            }
        }
        return this.itemBought .get(i);
    }

    public ArrayList<Item> getItemBought() {
        return this.itemBought;
    }

    public  double genTotalCalories(){
        int i = 0;
        double total = 0;
        for (i =0; i<this.itemBought.size(); i++){
            total = total + this.itemBought.get(i).getCalories()*this.itemBought.get(i).getAmount();
            }
        return total;
    }

    public double genTotalCost(){
        int i = 0;
        double total = 0;
        for (i =0; i<this.itemBought.size(); i++){
            total = total + this.itemBought.get(i).getCost()*this.itemBought.get(i).getAmount();
        }
        return total;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}