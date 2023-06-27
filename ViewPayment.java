public class ViewPayment {
    private Payment payment;
    //private Cart cart;

    public ViewPayment(Payment payment){
        this.payment = payment;
    }

    public void printBills(){
        int i;
        System.out.println("\n\nDenomination Inserted: ");
        for (i=0; i<this.payment.getPayment().size(); i++){
            System.out.println(this.payment.getPayment().get(i).getValue() + " Pieces: " +
                    this.payment.getPayment().get(i).getPieces());
        }
    }

    public void printTotalAmount(){
        double total=0;
        int i;
        total = this.payment.getBillTotal();
        System.out.println("You inserted: "+ total + " pesos");
    }


    /*public void printChange(){
        double change = this.payment.getBillTotal() - this.cart.genTotalCost();
        if (change >= 0){
            System.out.println("Your Change is: "+change);
        }
        else System.out.println("Insufficient Amount Inserted");
    }*/

}