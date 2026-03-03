import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {
    public void run(){
        int[][] aiGrid = new int[10][10];

        SecureRandom oRandom = new SecureRandom();
        Scanner oScanner = new Scanner(System.in);
        LinkedList oLinkedList = new LinkedList();

        int iWallChance = 30; // Used to determine chance for there to be a "1".

        // Randomly puts "0" or "1" in each element of the array.
        // 30% chance for there to be a "1'.
        for(int y = 0; y < aiGrid[0].length; y++){
            for(int x = 0; x < aiGrid.length; x++){

                int iChance = oRandom.nextInt(100);

                if (iChance < iWallChance){
                    aiGrid[y][x] = 1;
                } else {
                    aiGrid[y][x] = 0;
                }
            }
        }

        // Starting position will always be 0 to prevent insta-death.
        aiGrid[0][0] = 0;

        int iUserRow = 0;
        int iUserCol = 0;

        System.out.println("Welcome to Escape the Maze! Escape a 10x10 maze to win!");

        // Continuous loop until the player hits a wall ("1" inside an element)
        boolean bKeepPlaying = true;
        while(bKeepPlaying){
            System.out.print("Would you like to move down or right?" +
                    "\n Press 'd' for down, 'r' for right: ");
            String sInput =  oScanner.next();

            // Player's position is affected depending on their decision.
            // "D" or "d" moves player down one row.
            // "R" or "r" moves player to the right one column.
            if (sInput.equalsIgnoreCase("D")){
                iUserRow++;
            } else if (sInput.equalsIgnoreCase("R")){
                iUserCol++;
            }

            oLinkedList.addNode(iUserRow, iUserCol);

            // If there is a "1" in space, player loses.
            // If there is a "0" in space, player continues.
            // Player wins after they hit "0" in last row or column.
            if (aiGrid[iUserRow][iUserCol] == 1){
                System.out.println("You hit a wall! Game over!");
                bKeepPlaying = false;
            } else if (iUserRow == 9 || iUserCol == 9){
                System.out.println("You escaped the maze! You win!");
                bKeepPlaying = false;
            } else {
                System.out.println("Safe! Keep on moving.");
            }
        }

        int iMoveCount = 0;
        Node oTempNode = oLinkedList.removeNode();

        while (oTempNode != null) {
            aiGrid[oTempNode.xPosition][oTempNode.yPosition] = 5;

            iMoveCount++;
            oTempNode = oLinkedList.removeNode();
        }

        // Prints the grid after the game is over.
        // "X" marks where player was at.
        for(int y = 0; y < aiGrid[0].length; y++){
            for(int x = 0; x < aiGrid.length; x++){
                if(y == iUserRow && x == iUserCol){
                    System.out.print("X ");
                } else {
                    System.out.print(aiGrid[y][x] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Total player moves: " + iMoveCount);

        // Added as per instructions of the assignment.
        LinkedList oTestLL = oLinkedList;
        try {
            oTestLL.addNode(124,0);
            System.out.println("***test-add-" + oTestLL.headNode.xPosition);
        } catch(Exception ex) {
            System.out.println("###test-add");
        }

        try {
            if(oTestLL.removeNode().xPosition == 124) {
                System.out.println("***test-remove");
            } else {
                throw new Exception();
            }
        } catch(Exception ex) {
            System.out.println("###test-remove");
        }

        try {
            int i = oTestLL.removeNode().xPosition;
            System.out.println("###test-empty");
        } catch(Exception ex) {
            System.out.println("***test-empty");
        }
    }
}
