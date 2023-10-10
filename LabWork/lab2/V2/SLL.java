package lab2.V2;//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {

    private class SLLNode<T> {
      private T info;
      private SLLNode<T> next;
      public SLLNode() {
         this(null,null);
      }
      public SLLNode(T el) {
        this(el,null);
      }
      public SLLNode(T el, SLLNode<T> ptr) {
         info = el; next = ptr;
      }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a nonhead node;
                 for (pred = head, tmp = head.next;  
                      tmp != null && !tmp.info.equals(el); 
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
                     pred.next = tmp.next;
                     if (tmp == tail) // if el is in the last node;
                        tail = pred;
                 }
            }
    }
    
    @Override
    public String toString() {
       if(head == null)
          return "[ ]";
       String str = "[ ";   
       SLLNode<T> tmp = head;
       while(tmp != null){
         str += tmp.info + " ";
         tmp = tmp.next;
       }
       return str+"]";             
    }
    
    public boolean contains(T el) {
        if(head == null)
            return false;
        SLLNode<T> tmp = head;
        while(tmp != null){
           if(tmp.info.equals(el))
              return true;
           tmp = tmp.next;
        }
        return false;
    }
    
    public int size(){
        if(head == null)
          return 0;
          
        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
           count++;
           p = p.next;
        }
           
        return count;
    }
    
    //  Please write the methods of Task02 here:

    public void insertBefore(int index, T newElem){
        SLLNode<T> tmp = head;
        SLLNode<T> myNode = new SLLNode<>(newElem);
        if (head == null){
            throw new RuntimeException("Empty list");
        } else if (size() <= index || index < 0) {
            throw new RuntimeException("invalied size");

        } else if (index == 0) {
            myNode.next =head;
            head = myNode;
        } else {
            for (int i = 0 ;i<index-1;i++){
                tmp = tmp.next;
            }
            myNode.next = tmp.next;
            tmp.next = myNode;
        }

    }

    public T delete(int index) {
        SLLNode<T> element = head;
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        } else if (index < 0 || index >= size()) {
            throw new RuntimeException("invalid index");
        } else if (index ==0) {
            SLLNode<T> deleted = head;
            head = head.next;
            return deleted.info;
        } else {
            for (int i = 0; i < index-1; i++) {
                element = element.next;
            }
            SLLNode<T> deleted = element.next;
            element.next = element.next.next;
            return deleted.info;
        }
    }

    public void insertAfterSecondOccurrence(T e1, T e2){
        int num = 0;
        boolean flag = true;

        SLLNode<T> tmp = head;
        if(head == null){
            throw new RuntimeException("Empty");
        } else {
            while (tmp != null){
                if (tmp.info.equals(e2)){
                    num++;
                    if (num == 2){
                        SLLNode<T> newNode = new SLLNode<>(e1);
                        newNode.next = tmp.next;
                        tmp.next = newNode;
                        return;
                }}
                tmp =tmp.next;

            }
            if(num<2){
                throw new RuntimeException("no second occ of "+e2);
            }
        }
    }
}