public class Denomination {
    //this is a model class
    private double value;
    private int pieces;

    public Denomination(double value){
        this.value = value;
        this.pieces = 0;
    }

    public Denomination(double value, int pieces){
        this.value = value;
        this.pieces = pieces;
    }

    public double getValue() {
        return this.value;
    }

    public int getPieces() {
        return this.pieces;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

}