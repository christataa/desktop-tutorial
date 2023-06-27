import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewMenu {

    public Scanner st = new Scanner(System.in);
    public Scanner num = new Scanner(System.in);
    public Scanner deci = new Scanner(System.in);

    public ViewMenu(){
    }

    public int MainMenu(){
        int choice1;
        System.out.println("Main Menu");
        System.out.println("1. Create a Vending Machine\n" +
                "2. Test the Vending Machine Features\n" +
                "3. Exit\n");
        choice1 = this.st.nextInt();
        return choice1;
    }

    public void printTestMenu(){
        int choice1;
        System.out.println("Feature Menu");
        System.out.println("1. Test Vending Machine Features\n" +
                "2. Test Maintenance Feature\n" +
                "3. Exit\n");
        System.out.println("Enter the number of the choice: ");
    }


    public int maintenanceFeaturePanel(){
        int choice1;
        System.out.println("Maintenance Feature Menu");
        System.out.println("1. Restock\n" +
                "2. Change Price of Items\n" +
                "3. View Transaction summary\n" +
                "4. Replenish Money for change\n" +
                "5. View starting and ending inventory\n" +
                "6. Exit\n");
        System.out.println("Enter the number of Choice: ");
        choice1 = this.num.nextInt();
        return choice1;
    }

    public int restockPanel(){
        int choice1;
        System.out.println("Do you want to:");
        System.out.println("1. See Stock Room Items and choose index to restock\n" +
                "2. Search Item by name in Stock Room to restock\n" +
                "3. add new Item in Stock Room\n" +
                "4. Replenish item stock in Vending Machine\n" +
                "5. Assign new item to empty Slot in Vending Machine\n" +
                "6. Delete an item in the Vending Machine slot\n" +
                "7. Delete an item in the Vending Machine slot\n" +
                "8. back\n");
        choice1 = this.num.nextInt();
        return choice1;
    }

    public int restockPanel1(){
        int choice1;
        System.out.println("Enter the index of Choice to Restock: ");
        choice1 = this.num.nextInt();
        return choice1;
    }

    public int restockPanel2(){
        int choice1;
        System.out.println("Enter the index of Choice to Replenish: ");
        choice1 = this.num.nextInt();
        return choice1;
    }

    public List<String> restockPanel3(){
        System.out.println("type 0 for item cost or calories that is undecided\n" +
                "Type in [Format] Item name(string),Amount(integer),Cost(can be decimal),Calories:");
        String stInput;
        int i;
            stInput = this.st.nextLine();
            String[] in = stInput.split(",");
        List<String> input = new ArrayList<>();
        input = Arrays.asList(in);

        return input;
    }

    public int changePricePanel(){
        int choice;
        System.out.println("Change Price of Items\n" +
                "1. [Change Price in Item slots]\tPrint all Item then select index to change price\n" +
                "2. [Change Price in Item slots]\tSearch Item in vending machine slots by name and change price\n" +
                "3. [Change Price in Stockroom]\tPrint all Item then select index to change price\n" +
                "4. [Change Price in Stockroom]\tSearch Item in vending machine slots by name and change price\n" +
                "5. back");
        choice = this.num.nextInt();
        return choice;
    }

    public void incomeCollectPanel(double previous, double currIncome){
        System.out.println("\n=============================\nPrevious Income: " +previous + " Pesos\n" +
                "Current Income(starting from last restocking): " + currIncome + " Pesos\n");
        System.out.println("Printing Summary: \n");
    }

    public List<String> addToSlot(){
        System.out.println("type 0 for item cost or calories that is undecided\n" +
                "Type in [Format] Item name(string),Amount(integer),Cost(can be decimal),Calories:");
        String stInput;
        int i;
        stInput = this.st.nextLine();
        String[] in = stInput.split(",");
        List<String> input = new ArrayList<>();
        input = Arrays.asList(in);

        return input;
    }

    public int askInputNum(){
        System.out.println("Enter the item quantity: ");
        int input;
        input = this.num.nextInt();
        return input;
    }

    public int askInputIndex(){
        System.out.println("Enter index of choice: ");
        int input = this.num.nextInt();
        return input;
    }

    public String askInputString(){
        System.out.println("Enter the item name to search: ");
        String name = this.st.nextLine();
        return name;
    }

    public double askInputCost(){
        System.out.println("Enter new cost: ");
        double cost = this.deci.nextDouble();
        return cost;
    }

    public boolean askIfDone(){
        boolean done = false;
        System.out.println("Done?\t[NO] - 0\n\t\t[YES] - 1");
        if (this.num.nextInt() ==1)
        {
            done = true;
        }
        return done;
    }

    public void printEmpty(){
        System.out.println("error [This slot is empty]");
    }

    public void printStarting(){
        System.out.println("\nStarting Inventory: \n===========================================================\n");
    }
    public void printEnding(){
        System.out.println("\nEnding Inventory: \n===========================================================\n");
    }

    public void printStartAndEndSame(){
        System.out.println("\nDid not restock yet, Inventory from last restock: \n" +
                "===========================================================\n");
    }

    public void printChooseChoice(){
        System.out.println("Enter the number of Choice: ");
    }

    public void printAskName(){
        System.out.println("Enter item name: ");
    }

    public void printUpdateMessage(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\nUpdated: ");
    }

    public void printDisectLine(){
        System.out.println("====================================\n");
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
