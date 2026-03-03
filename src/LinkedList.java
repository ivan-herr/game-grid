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

        newNode.nextNode = this.headNode;

        this.headNode = newNode;
    }

    /**
     * Method to remove the Node from the LinkedList.
     * Uses a tempNode to hold the reference of current coordinates of headNode.
     * Sets headNode's coordinates to the nextNode.
     * @return tempNode Node class that contains the original coordinates of headNode.
     */
    public Node removeNode(){
        if (this.headNode == null) {
            return null;
        }

        Node tempNode = this.headNode;
        this.headNode = this.headNode.nextNode;

        return tempNode;
    }

    // --- Getter ---
    public Node getHeadNode(){
        return this.headNode;
    }
}
