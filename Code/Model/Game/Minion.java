package Model.Game;

public class Minion {
    private String name;
    private int hp;
    private int row, col;

    public Minion(String n , int  hp){
        this.name = n ;
        this.hp = hp;
    }

    public void setPosition(int r, int c){
        this.row = r;
        this.col = c;
    }

    public String getName(){
        return this.name;
    }

    public void showInfo(){
        IO.println("Name: " + name);
        IO.println("HP: " + hp);
        if(row!=0&&col!=0) IO.println("(row,col): " + "(" + row + "," + col + ")");
    }

}
