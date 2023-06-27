import java.util.ArrayList;

public class Payment {
    private ArrayList<Denomination> payment;
    private double billTotal;
    //private double totalCost;

    public Payment(){
        this.payment = new ArrayList<>();
        this.billTotal = 0;


       // for (i = 0; i<this.bills.size(); i++){
       //     this.bills.get(i).setDenoIndex(this.bills.size()-1);
       // }
    }

    public ArrayList<Denomination> getPayment() {
        return this.payment;
    }

    public double getBillTotal() {
        int i = 0;
        double total = 0;
        for (i = 0; i<this.getPayment().size(); i++){
            total = total + (this.getPayment().get(i).getPieces() * this.getPayment().get(i).getValue());
        }
        return total;
    }

    /*public double getTotalCost(Cart cart) {
        return cart.genTotalCost();
    }*/

    public void setPayment(ArrayList<Denomination> payment) {
        this.payment = payment;
    }
}