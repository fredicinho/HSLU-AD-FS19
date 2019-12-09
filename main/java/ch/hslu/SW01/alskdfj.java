/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freda
 */
public class alskdfj<E extends Comparable<E>> implements Comparable<Node<E>> {

    private static final Logger LOG = LogManager.getLogger(Node.class);
    
    private final ArrayList<E> data;

    private Node leftNode;
    private Node rightNode;

    //Hilfsattribut
    private int searchCount;

    public alskdfj(final List<E> data) {
        //initialize Data Object
        this.data = data;
     
        //init right and left node
        this.leftNode = null;
        this.rightNode = null;
        this.searchCount = 0;
    }
    
}
