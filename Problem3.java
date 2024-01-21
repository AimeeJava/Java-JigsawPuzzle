/**
 * Assignment2 problem3
 * Aimee Li
 * 6-09-2023
 */
package Assignment.A2;
import java.util.Scanner;
public class Problem3 {
    private static int W;
    private static int H;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt();
        H = in.nextInt();
        in.nextLine();
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
    public static void adjust(Piece p, int row){
        int side = (row==0)?0:(row==H-1)?2:-1;
        int[] tabs = p.getTabs();
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
    //use boolean valid to check if it's the right piece
    public static boolean validate(Piece p, Piece top, int hedge, int vedge){
        boolean valid = true;
        //if pieces are in the first and last row, top and bottom side should be 0
        if(hedge != -1){
            valid = valid && p.getTabs()[hedge] == 0;
            //if not, top and bottom side are not 0
        }else{
            valid = valid && p.getTabs()[0] != 0 && p.getTabs()[2] != 0;
        }
        //if pieces are in the first and last column, left and right side should be 0
        if(vedge != -1){
            valid = valid && p.getTabs()[vedge] == 0;
            //if not, right and left side are not 0
        }else{
            valid = valid && p.getTabs()[1] != 0 && p.getTabs()[3] != 0;
        }
        //if pieces has a piece on top of it, they should match
        if(top != null){
            valid = valid && p.matches(top, 0);
        }
        return valid;
    }

    public static Piece find(Piece[] puzzles, Piece p, int side, Piece top, int row, int col){
        //index 0--first row, 2--last row, else -1
        int hedge = (row == 0)? 0: (row == H-1)?2: -1;
        //index 3--first column, 1--right column, else -1
        int vedge = (col == 0)? 3: (col == W-1)?1: -1;
        //loop through puzzle to find the matching piece q, using validate method to check if it meets conditions
        for(Piece q: puzzles){
            if(match(p, q, side)){
                if(!validate(q, top, hedge, vedge)){continue;}
                return q;
            }
        }
        return null;
    }
    public static void assemble(Piece[] puzzles){
        Piece[][] assembled = new Piece[H][];
        //p is the first piece
        Piece p = puzzles[0];
        for (int i = 0; i < H; i++) {
            if(i > 0){
                p = find(puzzles, p, 2, null, i, 0);
            }
            if(assembled[i] == null){
                assembled[i] = new Piece[W];
            }
            assembled[i][0] = p;
            adjust(p, i);
            Piece nextp = p;
            for (int j = 1; j < W; j++) {
                Piece top = (i==0)? null: assembled[i-1][j];
                Piece q = find(puzzles, nextp, 1, top, i, j);
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
