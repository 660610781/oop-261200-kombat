package model;

public class Enemy {

    private int row;
    private int col;
    private int hp;

    public Enemy(int row, int col, int hp) {
        this.row = row;
        this.col = col;
        this.hp = hp;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getHp() {
        return hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(
                "Enemy takes " + damage + " damage (HP = " + hp + ")"
        );

        if (isDead()) {
            System.out.println("Enemy defeated!");
        }
    }
}
