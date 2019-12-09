/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW03;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
    
    private static final Logger LOG = LogManager.getLogger(Tree.class);

    private Node leftNode, rightNode;
    private Data data;
    private int searchCount;
    
    public Node(E data){
        this.data = new Data(data);
        this.leftNode = null;
        this.rightNode = null;
        this.searchCount = 0;
    }
    
    public void setRightNode(Node newrightNode){
        searchCount++;
        
        // Wenn rechter Knoten null ist, wird dieser gefüllt
        if (this.rightNode == null){
            LOG.info("Wert hinzugefügt: " + newrightNode.toString());
            this.rightNode = newrightNode;
         // wenn die Node nicht null ist, rekursion
         // falls Node kleiner ist --> setLeft
        } else if (this.rightNode.compareTo(newrightNode) > 0) {
            LOG.debug("go left");
            rightNode.setLeftNode(newrightNode);
        } else if (this.rightNode.compareTo(newrightNode) <= 0){
            LOG.debug("go right");
            rightNode.setRightNode(newrightNode);
        }
    }
    
    public void setLeftNode(Node newLeftNode){
        searchCount++;
        
        if (leftNode == null){
            this.leftNode = newLeftNode;
            LOG.info("Wert hinzugefügt: " + newLeftNode.toString());
        //Wenn Node nicht null ist, rekursion
        //falls Node kleiner ist --> setLeft
        } else if (this.leftNode.compareTo(newLeftNode) > 0) {
            this.leftNode.setLeftNode(newLeftNode);
            LOG.info("go left");
        // falls Node grösser ist --> setRight
        } else if (this.leftNode.compareTo(newLeftNode) <= 0){
            LOG.info("go right...");
            this.leftNode.setRightNode(newLeftNode);
        }
        
    }
    
    public Node getRightNode(){
        return this.rightNode;
    }
    
    public Node getLeftNode(){
        return this.leftNode;
    }
    
    public E getData(){
        return (E) this.data.getData();
    }
    
    public void setData(E data){
        this.data.setData(data);
    }

    @Override
    public int compareTo(Node<E> data) {
        return this.data.compareTo(data.getData());
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        if (obj == null){
            return false;
        }
        
        final Node<E> other = (Node<E>) obj;
        if (!Objects.equals(this.data, other.data)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.data);
        return hash;
    }
    
    @Override
    public String toString(){
        return "Node{ " + data.toString() + "}";
    }
    
}
