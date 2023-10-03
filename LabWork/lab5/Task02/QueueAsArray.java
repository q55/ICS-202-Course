package lab5.Task02;

// Java program to implement a queue using an array
public class QueueAsArray<T> { 
    private int front, rear, capacity; 
    private T[] queue; 
  
    public QueueAsArray(int capacity) { 
        front = rear = -1; 
        this.capacity = capacity; 
        queue = (T[]) new Object[capacity]; 
    } 
    
    public boolean isEmpty(){
       return front == -1;
    }
    
    public boolean isFull(){
      return rear == capacity - 1;
    }
  
    // function to insert an element at the rear of the queue 
    public void enqueue(T data)  { 
        if (isFull())
            throw new UnsupportedOperationException("Queue is full!"); 
        if(isEmpty())
           front++;
           
           rear++; 
           queue[rear] = data; 
    }

    public T dequeue() {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");
        T dequeuedElement = dequeueHelper(0);
        rear--; // adjust rear after the dequeue operation
        return dequeuedElement;
    }

    private T dequeueHelper(int index) {
        T element = queue[index]; // Save the current element
        if (index < rear) {
            queue[index] = dequeueHelper(index + 1); // Recursive call and shift
        }
        return element; // Return the saved element
    }


    public boolean search(T e){
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
            
        for(int i = 0; i <= rear; i++) 
            if(e.equals(queue[i]))
               return true;
               
        return false;
  }
  
  public String toString()  { 
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
         
        String str = "";  
        for (int i = 0; i <= rear; i++) { 
            str = str + queue[i] + "   "; 
        } 
        
        return str;
    } 
  
    public  T peek() { 
        if (isEmpty())
             throw new UnsupportedOperationException("Queue is empty!"); 
 
        return queue[front];  
    } 
} 