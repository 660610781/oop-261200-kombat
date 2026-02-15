package Model.Game;

public class Hexagon {
    private int row;
    private int col;

    //private Player owner;
    private Minion minion;

    public Hexagon(int r , int c){
        this.row = r;
        this.col = c;
        this.minion = null;
    }

    public boolean isEmpty(){
        return minion == null;
    }

    public void setMinion(Minion minion){
        this.minion = minion;
    }

    public Minion getMinion(){
        return minion;
    }
    public String getName(){
        return minion.getName();
    }


}
