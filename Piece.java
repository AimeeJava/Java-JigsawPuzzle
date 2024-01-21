/**
 * Assignment2 Piece class
 * Aimee Li
 * 6-09-2023
 */
package Assignment.A2;
public class Piece {
    private String word;
    private int[] tabs;
    //constructor of Piece class
    public Piece(String word, int[] tabs){
        this.word = word;
        this.tabs = tabs;
    }
    //Instance methods
    public String getWord(){return word;}
    public int[] getTabs() {return tabs;}

    public void rotate(){
        int temp = tabs[this.tabs.length - 1];
        for (int i = this.tabs.length - 1; i > 0; i--) {
            this.tabs[i] = this.tabs[i-1];
        }
        this.tabs[0] = temp;
    }

    public boolean matches(Piece piece, int side){
        //compare the current object with the parameter piece
        int[] targetTabs = piece.getTabs();
            if((this.tabs[side] + targetTabs[(side+2)%4]) == -1){
                return true;
            }
        return false;
    }
    public String toString(Piece piece){
        String output = "[" + piece.getWord() + ", ";
        for (int i = 0; i < piece.getTabs().length; i++) {
            if(i == 3){
                output += piece.getTabs()[i] + "]";
            }else {
                output += piece.getTabs()[i] + ", ";
            }
        }
        return output;
    }
}
