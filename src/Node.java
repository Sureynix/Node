/**
 * Class Node implements a basic Linked List structure
 * with some additional functionality.
 * AP Computer Science
 * 11-30-2016
 * [NAME]
 */
public class Node
{
    //Private String data stores Node data
    private String data;

    //Private Node next stores a reference to the next node in the list
    private Node next;

    //Constructor sets data = myData and next = nextNode
    public Node(String myData, Node nextNode)
    {
        data = myData;
        next = nextNode;
    }

    //Accessor method getData()
    //gets data of type String from the current Node
    public String getData()
    {
        return data;
    }

    //Accessor method getNext()
    //gets a reference to the next Node in the list
    public Node getNext()
    {
        return next;
    }

    //mutator method setData()
    //sets the String data of the current Node
    public void setData(String d)
    {

        data = d;
    }

    //mutator method setNext
    //sets the reference to the next Node in the list
    public void setNext(Node n)
    {
        next = n;
    }

    //Adds a node to the end of the list and returns the entire list
    //Must also check to see if list is empty (null) and if so adds a node
    //to the empty list
    public Node addNodeToEnd(String d, Node n)
    {
        if (n == null) {
            return new Node(d, null);
        }
        Node temp = n;
        while (temp.getNext()!=null) {
            temp = temp.getNext();
        }
        n.setNext(new Node(d, null));

        return n;
    }

    //Searches entire list for a String (oldString).  Anywhere it finds that String
    //it replaces it with a new String (newString).
    //Method returns the entire list
    public Node replaceNode(String oldString, String newString, Node n )
    {
        if (n != null) {
            if (n.getData() == oldString) {
                n.setData(newString);
            }
            replaceNode(oldString, newString, n.getNext());
        }
        return n;
    }

    //Search the list for a string (currentString), anywhere in the list where
    //that string is found, add a new string (newString) after it.
    //Must repair all connections and return the entire list
    public Node addNodeAfter(String currentString, String newString, Node n)
    {
        if (n != null) {
            if (n.getData() == currentString) {
                if (n.next != null) {
                    Node temp = n.next;
                    n.setNext(new Node(newString, temp));
                }
            }
            addNodeAfter(currentString, newString, n.getNext());
        }
        return n;
    }

    //Find the last node in the list and effectively remove it from the list
    //by setting the node behind it to point to null.
    //return the entire list
    public Node removeLastNode(Node n)
    {
        if (n.getNext() == null) {
            n = null;
        }
        else {
            removeLastNode(n.getNext());
        }
        return n;
    }
}//end class
