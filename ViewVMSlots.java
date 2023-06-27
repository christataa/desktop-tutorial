import java.util.ArrayList;

public class ViewVMSlots {
    private ArrayList<ItemSlot> slots;

    public ViewVMSlots(ArrayList<ItemSlot> slots)
    {
        this.slots = slots;
    }

    public void printEmptySlots(int slotLimit){
        int i;
        System.out.println("Empty Slots:");
        for (i=0; i<slotLimit; i++){
            if (this.slots.get(i).getItemStored()==null){
                System.out.println("Empty at Index: "+i);
            }
        }
    }

    public void printSlot(int index){
        if (this.slots.get(index).getItemStored()!=null){
            System.out.println("Slot " + index + " contains: ");
            System.out.println("Item name: " + this.slots.get(index).getItemStored().getItemName());
            System.out.println("Item pieces: " + this.slots.get(index).getItemStored().getAmount());
            System.out.println("Item cost: " + this.slots.get(index).getItemStored().getCost());
            System.out.println("Item calories: " + this.slots.get(index).getItemStored().getCalories()+"\n------------------");
        }
       else System.out.println("slot "+index+" is empty\n------------------");
    }

    public void printAllSlots(){
        System.out.println("All Slots in the Vending Machine: \n");
        int i;
        for (i=0; i<this.slots.size(); i++){
            if(this.slots.get(i).getItemStored()!=null)
            this.printSlot(i);
            else System.out.println("slot "+i+" is empty\n------------------");
        }
    }

    public int displayItemByName(String itemName){
        int i;
        boolean found = false;
        for (i=0; i<this.slots.size()&&!found; i++){
            if (this.slots.get(i).getItemStored()!=null) {
                if (this.slots.get(i).getItemStored().getItemName().contains(itemName)) {
                    System.out.println(this.slots.get(i).getItemStored().getItemName());
                    System.out.println("quantity: " + this.slots.get(i).getItemStored().getAmount());
                    System.out.println("Cost: " + this.slots.get(i).getItemStored().getCost());
                    System.out.println("Calories: " + this.slots.get(i).getItemStored().getCalories());
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
}