import java.util.ArrayList;
import java.util.List;

/**
 * controller class for vending machine feature of the vending machine
 */
public class VMFeature {
    private double customerChange;
    private RegularVM curVM;
    private ArrayList<ItemSlot> itemSlots;
    private ArrayList<Transaction> transactions;
    private MoneyHolder moneyHolder;
    private ArrayList<Denomination> validDeno;
    private ArrayList<Denomination> vmChange;
    private ArrayList<Denomination> change;
    private ArrayList<Denomination> vmIncome;
    private StockRoom stockRoom;
    private ViewVMSlots viewVMSlots;
    private ViewTransaction viewTransaction;
    private ViewVMDeno viewDenoChange;
    private ViewVMDeno viewDenoIncome;
    private ViewPayment viewPayment;
    private ViewStockRoom viewStockRoom;
    private Payment payment;
    private Cart cart;
    private ViewCart viewCart;
    private ViewVMFeature viewVMFeature;
    private ViewMenu viewMenu;


    public VMFeature(RegularVM regularVM) {
        this.customerChange = 0;    //change that must be given to customer
        this.curVM = regularVM;     //the vending machine that we are updating
        this.payment = new Payment();   //payment of customer/ bills or cash inserted
        this.cart = new Cart();     //cart to store the items selected by the customer
        this.itemSlots = this.curVM.getItemSlots();     //the vending machine slots of the vending machine
        this.transactions = this.curVM.getTransactions();          //the list for transactions made by different customers
        this.vmChange = this.curVM.getVmChange();       //the available denominations for change to be given to the customer
        this.change = new ArrayList<>();                //the temporary array storing bills to be given as change to the customers
        this.vmIncome = this.curVM.getVmIncome();       //the income storage of the vending machine, stores the payments inserted by customers
        this.validDeno = this.curVM.getValidDenominations();    //the valid denominations accepted by the vending machine
        this.stockRoom = this.curVM.getStockRoom();     //the stockroom of vending machine
        this.viewVMSlots = new ViewVMSlots(this.itemSlots);     //view class to display and print vending machine slots
        this.viewTransaction = new ViewTransaction(this.transactions);  //view class to print and display transactions
        this.viewDenoChange = new ViewVMDeno(this.change);      //view class to display change
        this.viewDenoIncome = new ViewVMDeno(this.vmIncome);    //view class to display income
        this.viewPayment = new ViewPayment(this.payment);       //view class to display payment
        this.viewStockRoom = new ViewStockRoom(this.stockRoom); //view class to display stockroom
        this.viewCart = new ViewCart(this.cart);                //view class to display cart
        this.viewVMFeature = new ViewVMFeature(this.curVM);     //view class to display the menu panels and print all sorts of stuff for vending feature
    }

    //this is a temp logic on how to accept customer payment. in this logic, the program gets every piece input for every denomination that is valid
    //but it's too long and hassle so pass. but not deleted yet.
    /*public boolean itemAmountIsSufficient(){
        boolean sufficient = true;
        boolean found;
        for (int i = 0; i<this.cart.getItemBought().size() && sufficient; i++){

            for (int j = 0; j<this.cart.getItemBought().size() && sufficient; j++){

                if (this.cart.getItemBought().get(i).getItemName().equals(this.itemSlots.get(j).getItemStored().getItemName())){
                    if ((this.cart.getItemBought().get(i).getAmount() > (this.itemSlots.get(j).getItemStored().getAmount()))){
                        sufficient = false;
                    }
                }
            }
        }
        return sufficient;
    }*/


    public void vendingFeatureMenu() {
        int choice1;            //choice of user
        boolean done = false;   //boolean to determine if user is done inputting stuff
        boolean done2 = false;  //boolean to determine if user is done inputting stuff
        boolean found = false;  //boolean to determine if user inputted denomination is found in the list of valid denominations
        List<String> userInput = new ArrayList<>();     //stores user input

        this.viewVMFeature.chooseItemPanel1();
        this.viewVMSlots.printAllSlots();
        this.viewVMFeature.chooseItemPanel2();

        /*
            while the user is not yet done on inputting denominations for his payment, the program will keep on
            accept input. for every input, it will be checked if it is valid, if not valid, will not be added to the payment
            arraylist, if valid, then will be added to the list of denominations (payment)
         */
        while(!done){
            found = false;
            userInput = this.viewVMFeature.insertPayment();
            Denomination input = new Denomination(Double.parseDouble(userInput.get(0)), Integer.parseInt(userInput.get(1)));
            for (int i =0; i<this.validDeno.size()&&!found; i++) {
                if (this.validDeno.get(i).getValue()==(input.getValue())) {
                    found = true;
                    this.payment.getPayment().add(input);
                    this.viewVMFeature.printAccepted();
                }
            }
            if (!found){
                this.viewVMFeature.printNotAccepted();
            }

            int j = this.viewVMFeature.askIfDone();
            if(j==1){
                done = true;
            }
            else done = false;
        }

        /*
            when the user is done with the input, will print the denominations that he inserted, pieces and the total amount
            and will proceed to let user choose if he wishes to choose item or produce change(give back the payment)
         */
        if (done){
            this.viewPayment.printBills();
            this.viewPayment.printTotalAmount();

            choice1 = this.viewVMFeature.printVMFeatureMenu();
            switch (choice1){
                case 1: //choose items
                    int j;
                    this.viewPayment.printBills();
                    this.viewPayment.printTotalAmount();
                    this.viewVMFeature.chooseItemPanel3();

                    /*
                        while the user is not yet done inputting the items that he wants to buy, will keep on asking. for each input, will check if
                        the item quantity user wants to buy is available. if available then will be added to cart, if not then it will not be added to cart
                     */
                    while (!done2)
                    {
                        userInput = this.viewVMFeature.chooseItem();
                        int index = Integer.parseInt(userInput.get(0));
                        int quantity = Integer.parseInt(userInput.get(1));

                        if ((this.itemSlots.get(index).getItemStored().getAmount()>=quantity)){
                            Item item = new Item(this.itemSlots.get(index).getItemStored().getItemName(),
                                    quantity, this.itemSlots.get(index).getItemStored().getCost(),
                                    this.itemSlots.get(index).getItemStored().getCalories());
                            this.cart.getItemBought().add(item);
                            this.viewVMFeature.printAdded();
                        }
                        else {
                            this.viewVMFeature.printNotAdded();
                        }
                        j = this.viewVMFeature.askIfDone();
                        if(j==1){
                            done2 = true;
                        }
                        else done2=false;
                    }

                    /*
                        if user is done inputting the items, then will proceed to produce change
                     */
                    if (done2){
                        this.viewCart.printItems();
                        this.viewCart.printTotalCost();
                        this.viewCart.printTotalCalories();
                        this.produceChange();
                        Transaction t = new Transaction(this.cart, this.payment);
                        this.transactions.add(t);
                        this.payment.getPayment().clear();
                        this.cart.getItemBought().clear();
                    }
                    break;
                case 2: //produce change (give back money)
                    this.viewVMFeature.printReturnCash(this.payment.getBillTotal());
                    this.payment.getPayment().clear();
            }


        }



    }

    /*
        this method here is a logic used to produce the change of customer. first will check if chang divide by denomination is 0, if its 0 then it
        means the value of denomination is larger than the change, thus this denomination will not be used to give as change toi customer.
        if not zero, then means that the change is larger than this denomination and this denomination can be used to produce change.
        to know how many pieces should be given to the customer, pieces = change/value. then this pieces of denomination(bill) will be stored
        to a temporary arrayList(this.change) if the pieces of this denomination is not enough, the program will just store the remaining pieces of
        this denomination in thi.change. after storing, the customerChange will be deducted, minus the amount to the bills stored in this.change.
        so when the program checks for next denomination, it will know the change left that must be given.
     */
    public void produceChangeByDeno(Payment payment, ArrayList<Denomination> vmChange, double value){
        double payed = this.payment.getBillTotal();
        double cost = this.cart.genTotalCost();
        int pieces = (int)(this.customerChange/value);
        boolean found = false;


        if (pieces !=0){
            found = false;
            for (int i =0; i<this.vmChange.size()&&!found; i++){
                if(this.vmChange.get(i).getValue()==value){
                    found = true;
                    if(this.vmChange.get(i).getPieces()>=pieces){
                        Denomination bill = new Denomination(value, pieces);
                        this.change.add(bill);
                        this.customerChange = (this.customerChange - (pieces*value));
                    }
                    else{
                        Denomination bill = new Denomination(value, this.vmChange.get(i).getPieces());
                        this.change.add(bill);
                        this.customerChange = (this.customerChange - (this.vmChange.get(i).getPieces()*value));
                    }
                }
            }
        }
    }


    public void produceChange(){
        double payed = this.payment.getBillTotal();
        double cost = this.cart.genTotalCost();
        this.customerChange = payed - cost;
        double customerChange = this.customerChange;
        boolean removed = false;

        /*
            this loop here checks for every valid denomination to produce change
         */
        for (int i =0; i<this.validDeno.size(); i++){
            this.produceChangeByDeno(this.payment, this.vmChange, this.validDeno.get(i).getValue());
        }

        /*
            if the change is sufficient the customerChange will result to 0(meaning all the bills are available to give as change,
            else it means there is no sufficient bills to give as change and the order will not be successful
         */
        if (this.customerChange == 0/*&& this.itemAmountIsSufficient()*/){
            for (int i =0; i<this.payment.getPayment().size(); i++){
                this.vmIncome.add(this.payment.getPayment().get(i));
            }

            for (int i =0; i<this.change.size(); i++){
                removed = false;
                for (int j = 0; j<this.vmChange.size() && !removed; j++){
                    if (this.vmChange.get(j).getValue() == this.change.get(i).getValue()){
                        this.vmChange.get(j).setPieces(this.vmChange.get(i).getPieces()-this.change.get(i).getPieces());
                        removed = true;
                    }
                }
            }
            /*
                if there is sufficient change then, the purchase is successful, the items must be dispensed from the vending machine (deduct the quantity of
                items bought by customers)
             */
            for (int i = 0; i<this.cart.getItemBought().size(); i++){
                removed = false;
                for (int j = 0; j<this.curVM.getSlotLimit() && !removed; j++){
                    if (this.itemSlots.get(j).getItemStored() !=null){
                        if (this.cart.getItemBought().get(i).getItemName() == this.itemSlots.get(j).getItemStored().getItemName()){
                            int prevAmount = this.itemSlots.get(j).getItemStored().getAmount();
                            this.itemSlots.get(j).getItemStored().setAmount(prevAmount - this.cart.getItemBought().get(i).getAmount());
                            removed = true;
                        }
                    }

                }
            }
            this.viewVMFeature.printSuccessBuy(customerChange);
            this.viewDenoChange.printDenoForChange();
            this.viewVMFeature.goodByePanel();
        }
        else{
            this.viewVMFeature.printNotSuccessBuy(this.payment.getBillTotal());
            this.viewVMFeature.printVMFeatureMenu();
        }



    }



    public static void main(String[] args){
        //notes to coder: 1. error checking for an item if it is stored already in another slot
        //                2. error checking if an item has the same name
        //                3. error checking for entering an item slot that is null
        RegularVM vm = new RegularVM();
        VMFeature vf = new VMFeature(vm);
        MaintenanceFeature mf = new MaintenanceFeature(vm);
        Item a = new Item("Corn Flakes",10,25,120);
        Item b = new Item("Vanilla Popcorn",10,15,140);
        Item c = new Item("Chocolate cookie",10,10,60);
        Item d = new Item("Cereal crackers",10,15,40);
        Item e = new Item("Frozen berries",10,30,60);
        vm.getItemSlots().get(1).setItemStored(a);
        vm.getItemSlots().get(4).setItemStored(b);
        vm.getItemSlots().get(5).setItemStored(c);
        vm.getItemSlots().get(7).setItemStored(d);
        vm.getItemSlots().get(2).setItemStored(e);
        vf.vendingFeatureMenu();
        mf.maintenanceMenu();
    }
}