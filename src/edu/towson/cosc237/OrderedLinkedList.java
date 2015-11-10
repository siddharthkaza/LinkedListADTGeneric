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

public class OrderedLinkedList<T> extends LinkedListClass<T> { 

    public OrderedLinkedList()    { 
        super(); 
    }
    
    @Override
    public boolean search(T searchItem)  { 
        LinkedListNode<T> current; //variable to traverse the list 
        boolean found; 
        current = first;  //set current to point to the first node in the list 
        found = false; 
        while (current != null && !found )  { 
            Comparable<T> temp = (Comparable<T>) current.info; 
            if (temp.compareTo(searchItem) >= 0) 
                found = true; 
            else 
                current = current.link; //make current point to the next node 
        } 
        if (found) 
           found = current.info.equals(searchItem); 
        return found; 
    }

    public void insert(T insertItem)  { 
        LinkedListNode<T> current;  //variable to traverse the list 
        LinkedListNode<T> trailCurrent; //variable just before current 
        LinkedListNode<T> newNode;  //variable to create a node 
        boolean  found; 
        newNode = new LinkedListNode<T>(insertItem, null); //create the node 
        
        //Case 1; the list is empty 
        if (first == null) { 
           first = newNode; 
           last = newNode; 
           count++; 
        } 
        else { 
            trailCurrent = first; 
            current = first; 
            found = false; 
            while (current != null && !found) {//search the list to find the right position of insertion
                Comparable<T> temp = (Comparable<T>) current.info; //need to compare the item to be inserted to the data in each node
                if (temp.compareTo(insertItem) >= 0) //found!
                   found = true; 
                else { //move on to next node
                   trailCurrent = current; 
                   current = current.link; 
                } 
            } 
            //Case 2 - inserting at the first position
            if (current == first) { 
                newNode.link = first; 
                first = newNode; 
                count++; 
            } 
            
            //Case 3 - inserting in the middle
            else { 
                trailCurrent.link = newNode; 
                newNode.link = current; 
                if (current == null) 
                    last = newNode; 
                count++; 
            } 
        } 
    }

    @Override
    public void insertFirst(T newItem) { 
        //the list is sorted - will call insert! 
        insert(newItem); 
    }

    @Override
    public void insertLast(T newItem) { 
        //the list is sorted - will call insert! 
        insert(newItem); 
    }

    @Override
    public void deleteNode(T deleteItem) { 
        
        
        
        
        
        
        
        //write your own code. Working code is below.   
        
        
        
        
        
        
        
        
        /*
        LinkedListNode<T> current;      //variable to traverse the list 
        LinkedListNode<T> trailCurrent; //variable just before current 
        boolean found; 
        //list is empty. 
        if (first == null) 
            System.err.println("Cannot delete from an empty list."); 
        else { 
            if (first.info.equals(deleteItem)) { 
                first = first.link; 
                if (first == null) 
                    last = null; 
                count--; 
            } 
            else { //search the list for the node with the given info 
                found = false; 
                trailCurrent = first; //trailCurrent points to the first node 
                current = first.link; //current points to the second node 
                while (current != null && !found) { 
                    Comparable<T> temp = (Comparable<T>) current.info; 
                    if (temp.compareTo(deleteItem) >= 0) 
                        found = true; 
                    else { 
                        trailCurrent = current; 
                        current = current.link; 
                    } 
                } 
                if (current == null) 
                    System.out.println("Item to be deleted is not in the list."); 
                else 
                    if (current.info.equals(deleteItem)) { //item to be deleted is in the list 
                         if (first == current) { 
                            first = first.link; 
                            if (first == null) 
                                last = null; 
                            count--; 
                        } 
                        else { 
                            trailCurrent.link = current.link; 
                            if (current == last) 
                                last = trailCurrent; 
                            count--; 
                        } 
                    } 
                    else 
                        System.out.println("Item to be deleted is not in the list."); 
            } 
        } 
        */
    } 
}


