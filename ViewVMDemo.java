import java.util.ArrayList;

public class ViewVMDeno {
    private ArrayList<Denomination> denominations;

    public ViewVMDeno(ArrayList<Denomination> denominations){
        this.denominations = denominations;
    }

    public void printDenoForChange(){
        int i;
        System.out.println("Denomination for change contains: ");
        for (i=0; i<this.denominations.size(); i++){
            System.out.println(this.denominations.get(i).getValue() + " Pesos:\t" + this.denominations.get(i).getPieces()+ " pieces");
        }
    }

    public void printDenoIncome(){
        int i;
        for (i=0; i<this.denominations.size(); i++){
            System.out.println("income contains: ");
            System.out.println(this.denominations.get(i).getValue() + "Pesos: ");
            System.out.println(this.denominations.get(i).getPieces() + " pieces\n");
        }
    }

    public void printDenoInfo(int index){
        System.out.println(this.denominations.get(index).getValue());
    }

    public void printNumOfDeno(){
        System.out.println(this.denominations.size());
    }
}