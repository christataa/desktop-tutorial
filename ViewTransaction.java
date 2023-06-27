import java.util.ArrayList;

public class ViewTransaction {
    private ArrayList<Transaction> transactions;
    private ViewCart viewCart;
    //private ViewPayment viewPayment;

    public ViewTransaction(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    public void printAllTransactions(){
        int i;
        for (i=0; i<this.transactions.size(); i++){
            System.out.println("Transaction "+(i+1)+" :");
            this.viewCart = new ViewCart(this.transactions.get(i).getBoughtItems());
            this.viewCart.printItems();
            this.viewCart.printTotalCost();
            this.viewCart.printTotalCalories();
            System.out.println("----------------------------\n");
        }
    }

    public void printTransactionTotal(){
        double total = 0;
        int i;
        for (i=0; i<this.transactions.size(); i++){
            total = total + this.transactions.get(i).getBoughtItems().genTotalCost();
        }
        System.out.println("Transaction total income: " + total);
    }
}