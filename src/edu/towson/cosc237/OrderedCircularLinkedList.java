/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.towson.cosc237;

/**
 *
 * @author skaza
 */
public class OrderedCircularLinkedList<T> extends LinkedListClass<T> {

    @Override
    public boolean search(T searchItem) {
        LinkedListNode<T> current; //variable to traverse the list 
        boolean found; 
        current = first;  //set current to point to the first node in the list 
        found = false; 
        while (current != null && !found )  { 
            Comparable<T> temp = (Comparable<T>) current.info; 
            if (temp.compareTo(searchItem) >= 0) 
                found = true;           //found is true will end the serach the info is equal or greator 
            else 
                current = current.link; //make current point to the next node 
        } 
        
        if (found) 
           found = current.info.equals(searchItem); 
        return found;  
    }

    @Override
    public void insertFirst(T newItem) {
        insert(newItem);
    }

    @Override
    public void insertLast(T newItem) {
        insert(newItem);
    }

    public void insert(T newItem) {
        LinkedListNode<T> current;  //variable to traverse the list 
        LinkedListNode<T> trailCurrent; //variable just before current 
        LinkedListNode<T> newNode;  //variable to create a node 
        boolean  endLoop; 
        int nodesSeen = 0;
        
        newNode = new LinkedListNode<T>(newItem, null); //create the node 
        
        //Case 1; the list is empty 
        if (first == null) { 
           first = newNode; 
           
           newNode.link = first;
           last = newNode; 
           
           count++; 
        } 
        else if (first.link == first) { //list has only one node
            Comparable<T> temp = (Comparable<T>) first.info;
            if (temp.compareTo(newItem) > 0) {  //inserting at the first position
                first.link = newNode;
                newNode.link = first;
                first = newNode;
                count++;
            } else { //inserting at the second position
                first.link = newNode;
                newNode.link = first;
                last = newNode;
                count++;
            }
        }
        else { //find the position of insertion
            trailCurrent = first; 
            current = first; 
            endLoop = false; 
     
            while ((nodesSeen < this.count) && !endLoop) {//search the list to find the right position of insertion
                Comparable<T> temp = (Comparable<T>) current.info; //need to compare the item to be inserted to the data in each node
                if (temp.compareTo(newItem) >= 0) //found!
                   endLoop = true; 
                else { //move on to next node
                   trailCurrent = current; 
                   nodesSeen++;
                   if (nodesSeen != count) { //if this is not the last node. we don't want to do it for the last node becuase of ** below
                       current = current.link;
                   } else {
                       current = last;
                   }
                   
                } 
            } 
            
            //inserting at the first position ** this will not work if we had done it for the last node
            if (current == first) { 
                newNode.link = first; 
                first = newNode; 
                count++; 
                last.link = newNode;
            } else
            
            //inserting at the last position
            if (current == last) {
                newNode.link = first;
                last.link = newNode;
                last = newNode;
                count++;
            } else 
            
            //inserting in the middle
            { 
                trailCurrent.link = newNode; 
                newNode.link = current; 
                //if (current.link == null) 
                //    last = newNode; 
                count++; 
            } 
        } 
    }
    
    @Override
    public void deleteNode(T deleteItem) {
        LinkedListNode<T> current;      //variable to traverse the list 
        LinkedListNode<T> trailCurrent; //variable just before current 
        boolean found; 
        
        //list is empty. 
        if (first == null) 
            System.err.println("Cannot delete from an empty list."); 
        else { 
            //if the first item is the one to be deleted
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
                        trailCurrent.link = current.link; 
                        if (current == last) 
                            last = trailCurrent; 
                        count--;  
                    } 
                    else 
                        System.out.println("Item to be deleted is not in the list."); 
            } 
        } 
    }

    @Override
    public void print() {
        LinkedListNode<T> current; //variable to traverse the list 
        current = first; 
        int numberPrinted = 0;
        
        if (current != null) { //print the first node seperately
            System.out.println(current.info + " ");
            current = current.link;
            numberPrinted++;
        }
        
        while (numberPrinted < count) {//while more data to print (the last one points back to first). stop then. 
            System.out.println(current.info + " "); 
            current = current.link; 
            numberPrinted ++;
        } 
    }
    
    
}
