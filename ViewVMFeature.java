import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewVMFeature {

    private Scanner st = new Scanner(System.in);
    private Scanner num = new Scanner(System.in);
    private Scanner deci = new Scanner(System.in);
    private ViewVMDeno viewValidVMDeno;

    public ViewVMFeature(RegularVM regularVM){
        this.viewValidVMDeno = new ViewVMDeno(regularVM.getValidDenominations());

    }


    public int printVMFeatureMenu(){
        int choice1;
        System.out.println("\n\n================================\n" +
                "Vending Machine Feature Menu");
        System.out.println("1. Choose Item\n" +
                "2. Produce Change\n");
        System.out.println("Enter the number of Choice: ");
        choice1 = this.num.nextInt();
        return choice1;
    }

    public void chooseItemPanel1(){
        System.out.println("\n\n==================== Welcome Customer ===================");
        System.out.println("(@' ^ '@)/ Here are the products of our Vending Machine: \n");
    }

    public void chooseItemPanel2(){
        System.out.println("\n\n========================== Please Insert Money =========================");
        System.out.println("(@' ^ '@)/: Enter value of denomination and number of pieces.\n" +
                "Valid denominations are: 0.01, 0.05, 0.10, 0.25, 1, 5, 10, 20, 50, 100, 200, 500, 1000\n" +
                "[FORMAT] value pieces [example:] 50 1\n");
    }

    public void chooseItemPanel3(){
        System.out.println("\n\n========================= Choose Your Item ========================");
        System.out.println("(@' ^ '@)/ Enter the index of the slot and enter number of pieces\n" +
                "[FORMAT] index pieces [Example:] 0 3\n");
    }

    public void goodByePanel(){
        System.out.println("\n\n========================= Thank You and Come Again!!! ========================");
        System.out.println("(@' ^ '@)/ bye.. (@' ^ '@)/ bye.. (@' ^ '@)/ bye.. (@' ^ '@)/ bye.. (@' ^ '@)/ \n");
    }

    public void produceChange(){
        System.out.println("Producing Change...");
    }

    public void printSuccessBuy(double customerChange){
        System.out.println("\\\n\nPurchase Successful!");
        this.produceChange();
        System.out.println("Your Change is:" + customerChange);
    }

    public void printNotSuccessBuy(double payment){
        System.out.println("This Vending Machine does not have enough change to give\n" +
                "Payment of: " + payment+ " will be returned.\n" +
                "returning... please get your cash on the change slot below, Thank You!\n");
    }

    public void printReturnCash(double payment){
        System.out.println("Payment of: " + payment+ " will be returned.\n" +
                "returning... please get your cash on the change slot below, Thank You!\n");
        this.goodByePanel();
    }

    public List<String> chooseItem(){
        System.out.println("Your Input: ");
        String stInput;
        int i;
        stInput = this.st.nextLine();
        String[] in = stInput.split(" ");
        List<String> input = new ArrayList<>();
        input = Arrays.asList(in);
        return input;
    }

    public List<String> insertPayment(){
        System.out.println("Your Input: ");
        String stInput;
        int i;
        stInput = this.st.nextLine();
        String[] in = stInput.split(" ");
        List<String> input = new ArrayList<>();
        input = Arrays.asList(in);
        return input;
    }

    public void printNotAccepted(){
        System.out.println("This denomination is not accepted");
    }

    public void printAccepted(){
        System.out.println("This denomination is accepted");
    }

    public void printAdded(){
        System.out.println("Item Added to cart");
    }

    public void printNotAdded(){
        System.out.println("Not added to cart. Item quantity not sufficient");
    }


    public int askIfDone(){
        System.out.println("\n[1] Done\n" +
                "[0] Continue Input");
        return this.num.nextInt();
    }



    public int askPieces(){
        int pieces;
        System.out.println("Pieces: ");
        pieces = this.num.nextInt();
        return pieces;
    }



}