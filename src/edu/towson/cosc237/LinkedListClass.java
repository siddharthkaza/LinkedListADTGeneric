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
import java.util.*; 

public abstract class LinkedListClass<T> implements LinkedListADT<T> {
    
    /**
     * Inner class LinkedListNode - stores info and link to the next node
     * @param <T> 
     */
    
    //Question - what is an inner class?
    protected class LinkedListNode<T> implements Cloneable { 
        public T info; 
        public LinkedListNode<T> link; 
        
        public LinkedListNode() { 
            info = null; 
            link = null; 
        }

        public LinkedListNode(T elem, LinkedListNode<T> ptr) { 
            info = elem; 
            link = ptr; 
        }
        
        //Question - what is the clone method?
        @Override
        public Object clone() throws CloneNotSupportedException { 
            LinkedListNode<T> copy = null; 
            try { 
                copy = (LinkedListNode<T>) super.clone(); 
            } 
            catch (CloneNotSupportedException e) { 
                return null; 
            } 
            return copy; 
        }

        @Override
        public String toString() { 
            return info.toString(); 
        } 
    }
    
    /**
     * Inner class LinkedListIterator - provides an iterator over the list
     * @param <T> 
     */
    
    public class LinkedListIterator<T> { 
        protected LinkedListNode<T> current;  //points to the current node in list 
        protected LinkedListNode<T> previous; //points to the node before the current node

        public LinkedListIterator() { 
            current = (LinkedListNode<T>) first; 
            previous = null; 
        }

        //Method to reset the iterator to the first node 
        public void reset() { 
            current = (LinkedListNode<T>) first; 
            previous = null; 
        }

        //return a reference to current and advance iterator to next node 
        public T next() { 
            if (!hasNext()) 
                throw new NoSuchElementException(); 
            LinkedListNode<T> temp = current; 
            previous = current; 
            current = current.link; 
            return temp.info; 
        }

        public boolean hasNext()  { 
            return (current != null); 
        }

        //remove the node currently pointed to by the iterator. 
        public void remove() { 
            if (current == null) 
                throw new NoSuchElementException(); 
            if (current == first) { 
                first = first.link; 
                current = (LinkedListNode<T>) first; 
                previous = null; 
                if (first == null) 
                    last = null; 
            } 
            else { 
                previous.link = current.link; 
                if (current == last){ 
                    last = first; 
                    while (last.link != null) 
                        last = last.link; 
                } 
                current = current.link; 
            } 
            count--; 
        }

        @Override
        public String toString() { 
            return current.info.toString(); 
        }

    }

    //Instance variables of the class LinkedListClass 
    protected LinkedListNode<T> first;//address of the first node/list 
    protected LinkedListNode<T> last; //address of the last node/list 
    protected int count;            //number of nodes in the list


    public LinkedListClass() { 
        first = null; 
        last = null; 
        count = 0; 
    }

    @Override
    public boolean isEmptyList() { 
        return (first == null); 
    }

    @Override
    public void initializeList() { 
        first = null; 
        last = null; 
        count = 0; 
    }

    @Override
    public void print()  { 
        LinkedListNode<T> current; //variable to traverse the list 
        current = first; 
        while (current != null) {//while more data to print 
            System.out.print(current.info + " "); 
            current = current.link; 
        } 
    }

    @Override
    public int length() { 
        return count; 
    }

    @Override
    public T front()   { 
        return first.info; 
    }

    @Override
    public T back()  { 
        return last.info; 
    }

    @Override
    public Object clone() throws CloneNotSupportedException { 
        LinkedListClass<T> copy = null; 
        try  { 
            copy = (LinkedListClass<T>) super.clone(); 
        } 
        catch (CloneNotSupportedException e){ 
            return null; 
        }

        //If the list is not empty clone each node of the list. 
        if (first != null) { 
            //Clone the first node 
            copy.first = (LinkedListNode<T>) first.clone(); 
            copy.last = copy.first; 
            LinkedListNode<T> current; 
            if (first != null) 
                current = first.link; 
            else 
                current = null; 
            //Clone the remaining nodes of the list 
            while (current != null) { 
                copy.last.link = (LinkedListNode<T>) current.clone(); 
                copy.last = copy.last.link; 
                current = current.link; 
            } 
        } 
        return copy; 
    }

    //Method to return an iterator of the list. 
    public LinkedListIterator<T> iterator()   { 
        return new LinkedListIterator<T>(); 
    }

    @Override
    public abstract boolean search(T searchItem); 
    @Override
    public abstract void insertFirst(T newItem); 
    @Override
    public abstract void insertLast(T newItem); 
    @Override
    public abstract void deleteNode(T deleteItem); 
}
