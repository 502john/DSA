public class Node<T>
{
    // A node needs to hold data, and be able to hold a reference to the next node
    public Node<T> next;
    public T data;

    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}