package lab3.LabPrograms;//****************************  DLL.java  *******************************
//                  generic doubly linked list class

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
        for (DLLNode<T> tmp = tail; tmp != null; tmp = tmp.prev){
            System.out.print(tmp.info + " ");
        }
        System.out.println();
    }


    public void delete7() {
        if (isEmpty()) return;

        boolean flag = true;
        DLLNode<T> tmp;
        int num = 1;

        while (flag && !isEmpty()) {
            if(head.next == null){
                deleteFromHead();
                return;
            }

            for (tmp = head; tmp.next != null; tmp = tmp.next) {
                if (num == 7) {
                    if (tmp == head) {
                        deleteFromHead();
                    } else if (tmp == tail) {
                        deleteFromTail();
                    } else {
                        tmp.prev.next = tmp.next;
                        tmp.next.prev = tmp.prev;
                    }
                    flag = false;
                    break;
                }
                num++;
            }
            if (flag) {
                for (tmp = tail; tmp != null; tmp = tmp.prev) {
                    if (num == 7) {
                        if (tmp == head) {
                            deleteFromHead();
                        } else if (tmp == tail) {
                            deleteFromTail();
                        } else {
                            tmp.prev.next = tmp.next;
                            tmp.next.prev = tmp.prev;
                        }
                        flag = false;
                        break;
                    }
                    num++;
                }
                num--;
            }
        }
    }





    public void insertAlternate(DLL<T> newList) {
        DLLNode<T> firstCurrent = head;
        DLLNode<T> secondCurrent = newList.head;

        int sizeFirst = 0, sizeSecond = 0;
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next) sizeFirst++;
        for (DLLNode<T> tmp = newList.head; tmp != null; tmp = tmp.next) sizeSecond++;

        if (sizeFirst != sizeSecond) {
            System.out.println("The two lists are not of the same size");
            return;
        }

        while (firstCurrent != null && secondCurrent != null) {
            DLLNode<T> nextFirst = firstCurrent.next;
            DLLNode<T> nextSecond = secondCurrent.next;

            firstCurrent.next = secondCurrent;

            if (nextFirst != null) {
                secondCurrent.next = nextFirst;
            } else {
                tail = secondCurrent;
            }

            firstCurrent = nextFirst;
            secondCurrent = nextSecond;
        }
        printAll();
    }
}