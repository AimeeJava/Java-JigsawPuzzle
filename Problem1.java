/**
 * Assignment2 problem1
 * Aimee Li
 * 6-09-2023
 */
package Assignment.A2;
import java.util.Scanner;

public class Problem1 {
    private static int W;
    private static int H;
    //adjust the first and the last row to make top and bottom is 0
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt();
        H = in.nextInt();
        in.nextLine();
        //create an array to store input
        Piece[] puzzle = new Piece[W * H];
        for (int i = 0; i < W * H; i++) {
            String word = in.next();
            int[] tabs = new int[4];
            for (int j = 0; j < 4; j++) {
                tabs[j] = in.nextInt();
            }
            Piece p = new Piece(word, tabs);
            puzzle[i] = p;
        }
        in.close();
        //use method to put pieces together
        assemble(puzzle);
    }

    //adjust the first and the last row
    public static void adjust(Piece p, int row) {
        //side: first row top index is 0, last row bottom index is 2, else -1
        int side = (row == 0)? 0: (row == H - 1)? 2: -1;
        int[] tabs = p.getTabs();
        //rotate the first piece of each row
        while (tabs[3] != 0 || (side != -1 && tabs[side] != 0)) {
            p.rotate();
        }
    }

    public static boolean match(Piece p, Piece q, int side) {
        int count = 0;
        while (count < 4) {
            if (p.matches(q, side)) {
                return true;
            }
            q.rotate();
            count++;
        }
        return false;
    }

    public static void assemble(Piece[] puzzle) {
        //create a String array to store output
        String[] words = new String[H];
        for (int i = 0; i < H; i++) {
            //create the first piece of each row and get the letter
            Piece p = puzzle[i * W];
            String word = p.getWord();
            adjust(p, i);
            //pieces other than the first one of each row
            for (int j = 1; j < W; j++) {
                //q is pieces other than the first one of each row
                Piece q = puzzle[i * W + j];
                //if not match after rotate, print error
                if (!match(p, q, 1)) {
                    System.out.printf("Wrong piece %s at (%d, %d).", q.toString(q), j + 1, i + 1);
                    return;
                }
                //put word of each row together
                word += q.getWord();
                p = q;
            }
            words[i] = word;
        }
        for (int j = 0; j < words.length; j++) {
            System.out.println(words[j]);
        }
    }
}
