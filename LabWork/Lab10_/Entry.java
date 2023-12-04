package lab10;

public class Entry<T> {
    private T dataObject;
    private String status;

    public Entry(T dataObject) {
        this.dataObject = dataObject;
        this.status = "E"; // Initially set to empty
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getDataObject() {
        return dataObject;
    }

    public void setDataObject(T dataObject) {
        this.dataObject = dataObject;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "[" + (dataObject == null ? "null" : dataObject.toString()) + ", '" + status + "']";
    }
}
