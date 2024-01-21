package Assignment.A2;

import java.util.Scanner;

public class PieceRunner {

  public static void main(String[] args) {
    final int TOP = 0;
    final int RIGHT = 1;
    final int BOTTOM = 2;
    final int LEFT = 3;

    Scanner in = new Scanner(System.in);

    String testCaseName = in.next();

    if (testCaseName.equals("Make&Print")) {
      // Instantiate and use getter and print
      int[] pieceTabs = new int[] {4, -5, 12, -87};
      Piece piece = new Piece("Simple", pieceTabs);

      System.out.println(piece.getWord());
      System.out.println(piece.toString(piece));
    } else if (testCaseName.equals("Rotation")) {
      // Rotate piece entirely
      int[] pieceTabs = new int[] {4, -5, 12, -87};
      Piece piece = new Piece("Simple", pieceTabs);

      System.out.println(piece.toString(piece));
      piece.rotate();
      System.out.println(piece.toString(piece));
      piece.rotate();
      System.out.println(piece.toString(piece));
      piece.rotate();
      System.out.println(piece.toString(piece));
      piece.rotate();
      System.out.println(piece.toString(piece));
    } else if (testCaseName.equals("PieceMatching")) {
      // Check all sides of two pieces to see if they match in current rotation
      int[] pieceTabs1 = new int[] {0, 3, 0, 0};
      Piece piece1 = new Piece("first", pieceTabs1);

      int[] pieceTabs2 = new int[] {0, 0, 0, -4};
      Piece piece2 = new Piece("second", pieceTabs2);

      System.out.println(piece1.matches(piece2, TOP));
      System.out.println(piece1.matches(piece2, RIGHT));
      System.out.println(piece1.matches(piece2, BOTTOM));
      System.out.println(piece1.matches(piece2, LEFT));
    } else if (testCaseName.equals("Comprehensive")) {
      // Using two pieces we will rotate the piece and see if any rotation of piece2 matches piece1
      int[] pieceTabs1 = new int[] {0, 3, 0, 0};
      Piece piece1 = new Piece("first", pieceTabs1);

      int[] pieceTabs2 = new int[] {0, 0, 0, -4};
      Piece piece2 = new Piece("second", pieceTabs2);

      System.out.println(piece1.matches(piece2, RIGHT));
      piece2.rotate();
      System.out.println(piece1.matches(piece2, RIGHT));
      piece2.rotate();
      System.out.println(piece1.matches(piece2, RIGHT));
      piece2.rotate();
      System.out.println(piece1.matches(piece2, RIGHT));
      piece2.rotate();
      System.out.println(piece1.matches(piece2, RIGHT));
    } else {
      System.out.println("This should never be printed...");
    }
  }
}
// FREEZE CODE END