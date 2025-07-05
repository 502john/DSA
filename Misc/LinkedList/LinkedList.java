public class LinkedList<T>
// Don't forget LinkedList should also be generic
{
    public Node<T> head;
    public int size;

    public LinkedList()
    {
        this.head = null;
        this.size = 0;

    }
    
    public LinkedList(Node<T> node, int size)
    {
        this.head = node;
        this.size = size;

    }

    public void add(T data)
    {
        Node<T> temp = new Node<>(data);
        

        // If empty
        if (size == 0)
        {
            this.head = temp;
        }
        // Otherwise append to the end
        else
        {
            Node<T> curr = this.head;
            while (curr.next != null)
            {
                curr = curr.next;
            }

            curr.next = temp;

        }

        this.size++;

    }

    public void print()
    {
        Node<T> curr = head;
        while (curr != null)
        {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }





}