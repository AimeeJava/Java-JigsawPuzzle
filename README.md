Each puzzle piece can be represented by five pieces of information:
1. a word, representing the content of the piece; and
2. four (4) integers representing the shape of the top, right, bottom, and left sides of the piece.
For example, the puzzle piece containing L in Figure 1 is represented by
L 41 -25 27 -21
Two puzzle pieces fit together, if the sum of the integers representing the adjacent sides sum to -1. For example, in Figure 1, “Z” is adjacent to “L” because 20 + -21 = -1. Similarly, “L” is adjacent to “A” on top because -42 + 41 = -1. If the sum is not -1, then the two pieces cannot be adjacent. The edge side of edge pieces is denoted by 0.
Puzzle pieces can rotate through four different orientations.


• Word is the word in the puzzle piece;
• Top is the integer representing the top side of the piece;
• Right is the integer representing the right side of the piece;
• Bottom is the integer representing the bottom side of the piece; and
• Left is the integer representing the left side of the piece.

Processing
The program must determine if the puzzle is ordered. An ordered puzzle satisfies the following conditions:
• Pieces adjacent to each other fit together. Two adjacent pieces fit together if the integers repre- senting the adjacent sides sum to -1.
• Each row contains W pieces and there are H rows.
• All pieces are used.
• The puzzle is checked in the order the pieces are read in. I.e., first row, then second row, etc.

Reorder the pieces in the correct order. This can be done by selecting one piece at a time, using a nested loop, after the first piece is in place, find the next piece and add it to the puzzle. Repeat. Assemble the puzzle one row at a time, starting with the first row, then the second, etc.
• Puzzle pieces may need to be rotated.
• All the pieces must be used.
• The puzzle is complete. There are no missing pieces.
• There is only one unique solution, so you will never need to decide be-
tween two pieces.
Recall that first piece in the input is the top-left corner. This will help you get started.
some pieces may have at most two sides that are the same as other pieces.

![Screenshot 2024-01-21 at 01 27 05](https://github.com/AimeeJava/Java-JigsawPuzzle/assets/107523986/d011b64f-0351-4460-b7fe-d1879571ee12)
