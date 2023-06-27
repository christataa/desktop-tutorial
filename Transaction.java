public class Transaction {
    private Cart boughtItems;
    private Payment payment;


    public Transaction (Cart boughtItems, Payment payment){
        this.boughtItems = boughtItems;
        this.payment = payment;
    }

    public Cart getBoughtItems() {
        return this.boughtItems;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setBoughtItems(Cart boughtItems) {
        this.boughtItems = boughtItems;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}