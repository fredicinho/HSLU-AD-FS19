/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class Tree<E extends Comparable<E>> implements TreeInterface<E> {

    private static final Logger LOG = LogManager.getLogger(Tree.class);
    private Node root;
    private int size;
    private int searchCount;
    
    public Tree(){
        this.size = 0;
        this.root = null;
    }
    

    @Override
    public Object search(E data) {
        //Inorder
        LOG.info("Suche initial gestartet");
        Node iterationNode = root;
        searchCount = 0;
        
        return search(data, iterationNode);
    }
    
    //für rekursion
    private Node search(E data, Node iterationNode){
        Node searchNode = new Node(data);
        searchCount++;
        
        // Wenn gesuchter Knoten die Wurzel ist, diesen zurückgeben
        if (iterationNode.equals(searchNode)){
            LOG.info("Wert " + searchNode.toString() + " gefunden");
            return searchNode;
        } 
        
        //falls Wert rechts ist
        if (iterationNode.compareTo(searchNode) <= 0){ //rechts
            LOG.info("Wert Rechts. Ebene: " + searchCount);
            
            if (iterationNode.getRightNode() != null){
                search(data, iterationNode.getRightNode());
            }
        }
        
        //falls Wert links ist
        if(iterationNode.compareTo(searchNode) > 0){
            LOG.info("Wert Links. Ebene: " + searchCount);
            
            if (iterationNode.getLeftNode() != null) {
                search(data, iterationNode.getLeftNode());
            }
        }
        
        //falls nicht gefunden wurde, return null
        return null;
    }

    @Override
    public void remove(E data) {
        if (this.root.getRightNode() == null && this.root.getLeftNode() == null) {
            this.root.setData(null);
        }
    }

    @Override
    public void add(E data) {
        if (this.size == 0){
            root = new Node(data);
            this.size++;
            LOG.info(this.root.toString() + " wurde als root im Baum hinzugefügt.");
        } else {
            Node newNode = new Node(data);
            if (this.root.compareTo(newNode) <= 0){
                this.root.setRightNode(newNode);
                this.size++;
                LOG.info(newNode.toString() + " wurde rechts vom root hinzugefügt");
            } else {
                this.root.setLeftNode(newNode);
                this.size++;
                LOG.info(newNode.toString() + " wurde links vom root hinzugefügt");
            }
        }
    }
    
    public int getSize(){
        return this.size;
    }
    
    
    
}
