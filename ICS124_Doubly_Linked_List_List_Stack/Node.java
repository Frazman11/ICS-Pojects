
package Lab4;

/**
 * Nodes to hold data and links to the previous or next nodes.Made of Generic Type
 * @author c0530980
 * @param <Q>
 */
public class Node<Q>{
    public Q datum;
    public Node<Q> previous = null;
    public Node<Q> next = null;


    
    public Node(Q q, Node<Q> next, Node<Q> previous){
        this.datum = q;
        this.next = next;
        this.previous = previous;
        
        
    }
    @Override
    public String toString(){
        return (String) datum;
    }
}
