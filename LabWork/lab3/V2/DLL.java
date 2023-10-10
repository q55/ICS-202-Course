package lab3.V2;//****************************  DLL.java  *******************************
//                  generic doubly linked list class

import lab5.Task01.SLL;

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
    public void printAll() { 
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
        System.out.println();
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }
    public void printReverse(){
        DLLNode<T> tmp = tail;
        while (tmp != null){
            System.out.print(tmp.info +" ");
            tmp = tmp.prev;
        }
    }


    public void delete7(){
        if(head == null){
            System.out.println("empty List");
            return;
        } else if (head == tail) {
            head = tail = null;
            return;
        }
        int num = 1;
        DLLNode<T> tmp = head;
        boolean forWard = true;

        while (num != 7){
            if (forWard){
                if (tmp.next == null){
                    forWard = false;
                }else {
                    tmp = tmp.next;
                    num++;
                }
            }else {
                if(tmp.prev == null){
                    forWard = true;
                }else {
                    tmp = tmp.prev;
                    num++;
                }
            }
        }
        System.out.println(tmp.info);
         if (tmp == head) {
            head = head.next;
            //tmp.next = null;
        } else if (tmp == tail) {
            tail.prev.next = null;
            tail = tail.prev;
        }else {
             tmp.prev.next = tmp.next;
             tmp.next.prev = tmp.prev;
         }
    }

    public void insertAlternate(DLL<T> newList){
        DLLNode<T> firstNode = head;
        DLLNode<T> secondNode = newList.head;

        int num = 0;
        int num2 = 0;
        while (firstNode!= null){
            num ++;
        }
        while (secondNode!= null){
            num ++;
        }
        if (num != num2){
            System.out.println("size not same ");
            return;
        }

        DLLNode<T> tmp = new DLLNode<>();

        while (firstNode.next != null){
            tmp.next = firstNode;
            tmp.next.next = secondNode;
            tmp.next.next.prev = tmp.next;
            firstNode = firstNode.next;
            secondNode = secondNode.next;
            tmp = tmp.next;
        }
    }
}