/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.towson.cosc237;

/**
 *
 * @author skaza
 * @param <T>
 */
public interface LinkedListADT<T> extends Cloneable { 
    public boolean isEmptyList();        //Method to determine whether the list is empty. 
    public void initializeList();        //Method to initialize the list to an empty state. 
    public void print();                 //Method to output the data contained in each node. 
    public Object clone() throws CloneNotSupportedException;               //Returns a copy of objects data in store (shallow copy) 
    public int length();                 //Method to return the number of nodes in the list. 
    public T front();                    //Method to return a reference to the first node 
    public T back();                     //Method to return a reference to the last node 
    public boolean search(T searchItem); //Method to determine whether searchItem is in the list. 
    public void insertFirst(T newItem);  //Method to insert newItem as the first item in the list. 
    public void insertLast(T newItem);   //Method to insert newItem at the end of the list. 
    public void deleteNode(T deleteItem);//Method to delete deleteItem from the list. 
}
