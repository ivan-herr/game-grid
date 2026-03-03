public class LinkedList {

    Node headNode;

    /**
     * Method to add a new Node class for the LinkedList. Sets newNode to headNode.
     * @param x Integer for x-coordinate.
     * @param y Integer for y-coordinate.
     */
    public void addNode(int x, int y){
        Node newNode = new Node();

        newNode.xPosition = x;
        newNode.yPosition = y;

        this.headNode = newNode;
    }

    public void removeNode(){

    }

    // --- Getter ---
    public Node getHeadNode(){
        return this.headNode;
    }
}
