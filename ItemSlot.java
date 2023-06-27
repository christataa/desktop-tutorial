public class ItemSlot {
    //this is a model class

    private int slotIndex;
    private Item itemStored;
    private int slotItemLimit;

    public ItemSlot(int slotIndex){
        this.slotIndex = slotIndex;
        this.itemStored = null;
        this.slotItemLimit = 10;
    }

    public ItemSlot(int slotIndex, Item itemStored){
        this.slotIndex = slotIndex;
        this.itemStored = itemStored;
        this.slotItemLimit = 10;
    }

    public int getSlotIndex(){
        return this.slotIndex;
    }

    public Item getItemStored() {
        return this.itemStored;
    }

    public int getSlotLimit() {
        return this.slotItemLimit;
    }

    public void setSlotLimit(int slotLimit) {
        this.slotItemLimit = slotLimit;
    }

    public void setSlotIndex(int slotIndex) {
        this.slotIndex = slotIndex;
    }

    public void setItemStored(Item itemStored) {
        this.itemStored = itemStored;
    }
}