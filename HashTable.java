/**
 * A simple hasht table is an array of linked lists. In its simplest form, a
 * linked list is represented by its first node. Typically we label this node as
 * "head". Here, however, we'll know it's the first node of the list because it
 * will be placed in an array element. For example, if we have 4 linked lists,
 * we know that the "head" of the third one can be found in position [2] of the
 * underlying array.
 */
public class HashTable<E extends Comparable<E>> {

    /**
     * Underlying array of nodes. Each non empty element of this array is the first
     * node of a linked list.
     */
    private Node[] underlying;

    /**
     * Default size for the underlying array. Users may specify any size, but the
     * default constructor will use this size.
     */
    private static final int DEFAULT_SIZE = 4;

    /** Basic constructor with user-specified size */
    public HashTable(int size) {
        this.underlying = new Node[size];
    }

    /** Default constructor, passes defauilt size to basic constructor */
    public HashTable() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adds a node, with the specified content, to a linked list in the underlying
     * array.
     * 
     * @param content E The content of a new node, to be placed in the array.
     */
    public void add(E content) {
        // creates a new node to assign to the list
        Node temp = new Node(content);
        // initialize a variable to assign to some part of the underlying array based on its hash code modulated with
        // the underlying array length
        int nodeIndex = (Math.abs(content.hashCode() % this.underlying.length));
        // if the node's position in underlying array is not empty, the node gets pushed back
        if (this.underlying[nodeIndex] != null) {
            temp.setNext(this.underlying[nodeIndex]);
        }
        // null or not, the temp node becomes the new head.
        this.underlying[nodeIndex] = temp;
    } // method add

    public String toString() {
        // initialze return string
        String reString = "";
        // initialize string that builds each linked list.
        String currentLL = "";
        // this loop builds the whole return string.
        for (int i = 0; i < this.underlying.length; i++) {
            // starts the linked list string with an open bracket.
            currentLL += "[";
            // traverses the linked list.
            Node indexNode = this.underlying[i];
            // integer variable that counts index of linked list
            int j = 0;
            // loop that builds the linked list string.
            while (indexNode != null) {
                // fencepost
                if (j == 0) {
                    currentLL += indexNode.getContent();
                } else {
                    currentLL += ", " + indexNode.getContent();
                }
                indexNode = indexNode.getNext();
                j++;
            }
            // closes string with bracket
            currentLL += "] \n";
            // adds each linked list string to the return string
            reString += currentLL;
        }
        // returns string.
        return reString;
    }

} // class HashTable
