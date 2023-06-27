public class ViewStockRoom {
    private StockRoom stockRoom;

    public ViewStockRoom(StockRoom stockRoom){
        this.stockRoom = stockRoom;
    }

    public int displayItemByName(String itemName){
        int i;
        boolean found = false;
        for (i=0; i<this.stockRoom.getItems().size()&&!found; i++){
            if (this.stockRoom.getItems().get(i)!=null) {
                if (this.stockRoom.getItems().get(i).getItemName().contains(itemName)) {
                    System.out.println(this.stockRoom.getItems().get(i).getItemName());
                    System.out.println("quantity: " + this.stockRoom.getItems().get(i).getAmount());
                    System.out.println("Cost: " + this.stockRoom.getItems().get(i).getCost());
                    System.out.println("Calories: " + this.stockRoom.getItems().get(i).getCalories());
                    System.out.println("item at Slot index: " + i);
                    found = true;
                }
            }
        }
        if (found == false){
            System.out.println("This Item does not exist in vending machine slots.");
            i = -1;
        }
        return i;
    }

    public void displayItem(int index){
        System.out.println("[index:" + index + "]\tItem name: " + this.stockRoom.getItems().get(index).getItemName());
        System.out.println("stock amount: " + this.stockRoom.getItems().get(index).getAmount()
        + "\nitem Cost: " + this.stockRoom.getItems().get(index).getCost()
        + "\nitem Calories: " + this.stockRoom.getItems().get(index).getCalories()+ "\n");
    }

    public void displayAllItems(){
        System.out.println("All Items in Stockroom: \n");
        int i;
        if (this.stockRoom.getItems() != null){
            for (i=0; i<this.stockRoom.getItems().size(); i++){
                this.displayItem(i);
            }
        }
        else if(this.stockRoom.getItems() == null){
            System.out.println("There is nothing in the Stock Room");
        }

    }

}