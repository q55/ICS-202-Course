package lab10;

public class HashTable<T> {
    private Entry<T>[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = (Entry<T>[]) new Entry<?>[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Entry<>(null);
            table[i].setStatus("E");
        }
    }

    public boolean insert(T dataObject) {
        int hash = Math.abs(dataObject.hashCode()) % size;
        int originalHash = hash;

        while (!table[hash].getStatus().equals("E")) {
            if (table[hash].getStatus().equals("O") && table[hash].getDataObject().equals(dataObject)) {
                return false; // It's a duplicate, so do not insert
            }
            hash = (hash + 1) % size;
            if (hash == originalHash) {
                return false; // Came full circle, table must be full
            }
        }

        table[hash].setDataObject(dataObject);
        table[hash].setStatus("O");
        return true;
    }

    public boolean delete(T dataObject) {
        int index = find(dataObject);
        if (index != -1) {
            // Mark the entry as deleted
            table[index].setStatus("D");
            return true;
        }
        return false; // Element not found
    }


    public int find(T dataObject) {
        int hash = Math.abs(dataObject.hashCode()) % size;
        int originalHash = hash;
        while (!table[hash].getStatus().equals("E")) {
            if (table[hash].getStatus().equals("O") && table[hash].getDataObject().equals(dataObject)) {
                return hash;
            }
            hash = (hash + 1) % size;
            if (hash == originalHash) {
                return -1; // Came full circle, element not found
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("  ").append(i).append(": ").append(table[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
