/**
 * Assignment2 problem2
 * Aimee Li
 * 6-09-2023
 */
package Assignment.A2;
import java.util.Scanner;
public class Problem2 {
    private static int W;
    private static int H;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt();
        H = in.nextInt();
        in.nextLine();
        //create an array to store input
        Piece[] puzzles = new Piece[W * H];
        for (int i = 0; i < W * H; i++) {
            String word = in.next();
            int[] tabs = new int[4];
            for (int j = 0; j < 4; j++) {
                tabs[j] = in.nextInt();
            }
            Piece p = new Piece(word, tabs);
            puzzles[i] = p;
        }
        in.close();
        assemble(puzzles);
    }
    //adjust the first piece of each row
    public static void adjust(Piece p, int row){
        //side: 0--first row top index or 2--last row bottom index, else -1
        int side = (row == 0)? 0:(row == H-1 )? 2: -1;
        int[] tabs = p.getTabs();
        //if the edge side is not 0, rotate
        while(tabs[3] != 0 || (side != -1 && tabs[side] != 0)){
            p.rotate();
        }
    }
    public static boolean match(Piece p, Piece q, int side){
        int count = 0;
        while(count < 4){
            if(p.matches(q, side)){
                return true;
            }
            q.rotate();
            count++;
        }
        return false;
    }
    //return the piece that matches p
    public static Piece find(Piece[] puzzles, Piece p, int side){
        for(Piece q: puzzles){
            if(match(p, q, side)){
                return q;
            }
        }
        return null;
    }
    public static void assemble(Piece[] puzzles){
        //create a 2D array to store final pieces
        Piece[][] assembled = new Piece[H][];
        //p is the first piece
        Piece p = puzzles[0];
        for (int i = 0; i < H; i++) {
            if(i > 0){
                //start from second row, find p to match the bottom of the one above it
                //update p each time
                p = find(puzzles, p, 2);
            }
            if(assembled[i] == null){
                assembled[i] = new Piece[W];
            }
            //store p to the first position of each row
            assembled[i][0] = p;
            //adjust the first piece into right direction
            adjust(p, i);
            //use nextp to find the piece that matches the right side and iterate it
            Piece nextp = p;
            for (int j = 1; j < W; j++) {
                Piece q = find(puzzles, nextp, 1);
                assembled[i][j] = q;
                nextp = q;
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(assembled[i][j].getWord());
            }
            System.out.println();
        }
    }
}
