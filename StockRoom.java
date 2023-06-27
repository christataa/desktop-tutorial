import java.util.ArrayList;

public class StockRoom {
    private ArrayList<Item> items;
    //private int itemIndex;

    public StockRoom(){
        this.items = new ArrayList<>();
        this.items.clear();
        //this.itemIndex=this.items.size()-1;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = this.items;
    }

    //public int getItemIndex() {
    //    return this.itemIndex;
    //}

    //public void setItemIndex(int itemIndex) {
    //    this.itemIndex = itemIndex;
    //}
}