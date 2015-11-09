/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.towson.cosc237;

import java.util.Scanner;

/**
 *
 * @author skaza
 */
public class LinkedListADTGeneric {
    static Scanner input = new Scanner(System.in); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        
        //for ordered Linked List
        OrderedLinkedList<Integer> intList = new OrderedLinkedList<Integer>(); 
        OrderedLinkedList tempList; 
        Integer num; 
        System.out.println("Enter integers (999 to stop)"); 
        num = input.nextInt(); 
        while (!num.equals(999)) { 
            intList.insert((Integer) num); 
            num = input.nextInt(); 
        } 
        System.out.println("\nTesting .insert. The original list is: "); 
        intList.print(); 
        System.out.println("\nTesting .length. The length of the original list is: " + intList.length()); 
        if (!intList.isEmptyList()) { 
            System.out.println("Testing .front. First element/original list: " + intList.front()); 
            System.out.println("Testing .back. Last element/original list: "  + intList.back()); 
        } 
        tempList = (OrderedLinkedList<Integer>) intList.clone(); 
        System.out.println("Testing .clone. The copy list is: "); 
        tempList.print(); 
        System.out.println("\nTesting .length. The length of the copy list is: " + tempList.length()); 
        System.out.print("Testing .search. Enter the number to search for/original list: "); 
        num = input.nextInt(); 
        if (intList.search(num)) 
            System.out.println(num + " found in original list."); 
        else 
            System.out.println(num + " is not in original list."); 
        System.out.print("Testing .remove. Enter the number to be deleted from original list: "); 
        num = input.nextInt(); 
        intList.deleteNode(num); 
        System.out.print("After deleting " + num + " the original list is: "); 
        intList.print(); 
        System.out.println("\nThe length of of the original list is: " + intList.length()); 
        //Create an iterator for intList. 
        OrderedLinkedList<Integer>.LinkedListIterator<Integer> intListIt = intList.iterator(); 
        System.out.println("Testing iterator -- remove second node from original list. "); 
        if (intListIt.hasNext()) 
            intListIt.next(); 
        if (intListIt != null) 
            intListIt.remove(); 
        System.out.println("The original list is: "); 
        intList.print(); 
        System.out.println("\nThe length of the original list is: " + intList.length()); 
        System.out.println("The copy list is: "); 
        tempList.print(); 
        System.out.println("\nThe length of the copy list is: " + tempList.length()); 
    }
    
}
