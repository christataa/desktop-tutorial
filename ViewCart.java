public class ViewCart {
    Cart cart;

    public ViewCart(Cart cart){
        this.cart = cart;
    }

    public void printItems(){
        int i;
        System.out.println("\n\nItems Selected: ");
        for (i =0; i<this.cart.getItemBought().size(); i++)
        {
            System.out.println("[ITEM"+ (i+1)+"] "+this.cart.getItemBought().get(i).getItemName()
            + ": " + this.cart.getItemBought().get(i).getAmount() + " pieces");
            System.out.println(" price per piece: "+ this.cart.getItemBought().get(i).getCost() +" Pesos");
            System.out.println(" Calories per piece: " + this.cart.getItemBought().get(i).getCalories());
            System.out.println("-------------------------");
        }
    }

    public void printTotalCalories(){
        System.out.println("Total Calories: " + this.cart.genTotalCalories());
    }

    public void printTotalCost(){
        System.out.println("Total Cost:" + this.cart.genTotalCost());
    }
}