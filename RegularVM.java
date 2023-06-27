import java.util.ArrayList;

public class RegularVM {
    private String vmName;
    private Cart vmCart;
    private Payment payment;
    private ArrayList<ItemSlot> itemSlots;
    private MoneyHolder moneyHolder;
    private ArrayList<Denomination> vmChange;
    private ArrayList<Denomination> validDenominations;
    private ArrayList<Denomination> vmIncome;
    private ArrayList<Transaction> transactions;
    private StockRoom stockRoom;
    private int slotLimit;

    public RegularVM(){
        this.slotLimit = 8;
        this.vmName = "Regular VM";
        this.vmCart = new Cart();
        this.itemSlots = new ArrayList<>();
        //this.itemSlots.clear();
        for (int i = 0; i<this.getSlotLimit(); i++){
            ItemSlot slot = new ItemSlot(i);
            this.itemSlots.add(slot);
        }
        this.validDenominations = new ArrayList<>();
        this.initializeValidDeno(this.validDenominations);
        this.vmIncome = new ArrayList<>();
        this.vmChange = new ArrayList<>();
        this.initializeDenoForChange(this.vmChange);
        this.stockRoom = new StockRoom();
        this.payment = new Payment();
        this.transactions = new ArrayList<>();
    }

    public RegularVM(String vmName){
        this.slotLimit = 8;
        this.vmName = vmName;
        this.vmCart = new Cart();
        this.itemSlots = new ArrayList<>();
        //this.itemSlots.clear();
        for (int i = 0; i<this.getSlotLimit(); i++){
            ItemSlot slot = new ItemSlot(i);
            this.itemSlots.add(slot);
        }
        this.validDenominations = new ArrayList<>();
        this.initializeValidDeno(this.validDenominations);
        this.vmIncome = new ArrayList<>();
        this.vmChange = new ArrayList<>();
        this.initializeDenoForChange(this.vmChange);
        this.stockRoom = new StockRoom();
        this.payment = new Payment();
        this.transactions = new ArrayList<>();
    }

    public String getVmName() {
        return this.vmName;
    }

    public ArrayList<Denomination> getVmChange() {
        return vmChange;
    }

    public ArrayList<Denomination> getVmIncome() {
        return vmIncome;
    }

    public Cart getVmCart() {
        return this.vmCart;
    }

    public StockRoom getStockRoom() {
        return this.stockRoom;
    }

    public ArrayList<ItemSlot> getItemSlots() {
        return this.itemSlots;
    }

    public ArrayList<Denomination> getValidDenominations() {
        return validDenominations;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public int getSlotLimit() {
        return this.slotLimit;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public void setItemSlots(ArrayList<ItemSlot> itemSlots) {
        this.itemSlots = itemSlots;
    }

    public void setVmCart(Cart vmCart) {
        this.vmCart = vmCart;
    }

    public void setStockRoom(StockRoom stockRoom) {
        this.stockRoom = stockRoom;
    }

    public void setVmChange(ArrayList<Denomination> vmChange) {
        this.vmChange = vmChange;
    }

    public void setVmIncome(ArrayList<Denomination> vmIncome) {
        this.vmIncome = vmIncome;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setSlotLimit(int slotLimit) {
        this.slotLimit = slotLimit;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    private void initializeValidDeno(ArrayList<Denomination> valid){
        Denomination a = new Denomination(1000);
        Denomination b = new Denomination(500);
        Denomination c = new Denomination(200);
        Denomination d = new Denomination(100);
        Denomination e = new Denomination(50);
        Denomination f = new Denomination(20);
        Denomination g = new Denomination(10);
        Denomination h = new Denomination(5);
        Denomination i = new Denomination(1);
        Denomination j = new Denomination(0.25);
        Denomination k = new Denomination(0.10);
        Denomination l = new Denomination(0.05);
        Denomination m = new Denomination(0.01);
        valid.add(a);
        valid.add(b);
        valid.add(c);
        valid.add(d);
        valid.add(e);
        valid.add(f);
        valid.add(g);
        valid.add(h);
        valid.add(i);
        valid.add(j);
        valid.add(k);
        valid.add(l);
        valid.add(m);
    }

    private void initializeDenoForChange(ArrayList<Denomination> vmChange){
        Denomination a = new Denomination(20, 50);
        Denomination b = new Denomination(50, 50);
        Denomination c = new Denomination(100, 50);
        Denomination d = new Denomination(200, 50);
        Denomination e = new Denomination(500, 50);
        Denomination f = new Denomination(1000, 50);
        Denomination g = new Denomination(10, 50);
        Denomination h = new Denomination(5, 50);
        Denomination i = new Denomination(1, 50);
        Denomination j = new Denomination(0.25, 50);
        Denomination m = new Denomination(0.10, 50);
        Denomination k = new Denomination(0.05, 50);
        Denomination l = new Denomination(0.01, 50);
        vmChange.add(a);
        vmChange.add(b);
        vmChange.add(c);
        vmChange.add(d);
        vmChange.add(e);
        vmChange.add(f);
        vmChange.add(g);
        vmChange.add(h);
        vmChange.add(i);
        vmChange.add(j);
        vmChange.add(k);
        vmChange.add(l);
        vmChange.add(m);
    }
}