package Model.Game;

public class Board {
    private int row;
    private int col;

    private Hexagon[][] grid;

    public Board(int r , int c){
        this.row = r;
        this.col = c;
        this.grid = new Hexagon[r+1][c+1];

        for(int rw = 1;rw<=row;rw++){
            for(int cl = 1;cl<=col;cl++){
                grid[rw][cl] = new Hexagon(rw,cl);
            }
        }
    }

    public void putMinion(Minion m, int r, int c){
        if((r>=1&&r<=row)&&(c>=1&&c<=col)){
            grid[r][c].setMinion(m);
            m.setPosition(r,c);
            IO.println("Put - " + m.getName() + " - in (" + r + "," + c + ")");
        }
    }

    public void printBoard(){
        for(int rw = 1;rw<=row;rw++){
            for(int cl = 1;cl<=col;cl++){
               Hexagon hex = grid[rw][cl];
               //if(hex.getMinion() != null) IO.print("[ " + hex.getName() + " ] ");
                if(hex.getMinion() != null) IO.print("[M] ");
               else IO.print("[ ] ");
            }
            IO.println();
        }
    }
}
