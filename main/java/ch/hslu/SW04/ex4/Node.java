/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW04.ex4;

/**
 *
 * @author freda
 */
public class Node<E> {
    
        //Nöchste Node
    private Node next;
    //Daten der Node
    private E data;

    public Node(E data) {
        //Default next == null
        this(data, null);
    }

    public Node(E data, Node next) {
        this.next = next;
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }
    
}
