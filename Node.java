package triangle;

/**
 *
 * @author will
 */
public class Node {
    
    private int dist;
    private int value;
    private Node lChild;
    private Node rChild;
    
    public void setLeftChild(Node n){
        this.lChild=n;
    }
    public void setRightChild(Node n){
        this.rChild=n;
    }
    public void setDist(int parentDist){
        if(parentDist+this.value>this.dist)
            this.dist=parentDist+this.value;
    }
    public int getDist(){
        return this.dist;
    }
    public static int getMax(Node[] nArray){
        int i=0;
        int currentMax=nArray[0].getDist();
        for(i=1; i<nArray.length; i++){
            if(nArray[i].getDist()>currentMax)
                currentMax=nArray[i].getDist();
        }
        return currentMax;
    }
    
    public Node(int value){
        this.value=value;
        this.lChild=null;
        this.rChild=null;
        this.dist=-1;
    }
   
}
