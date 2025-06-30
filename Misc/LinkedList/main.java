import java.util.Random;
public class main
{
    public static void main(String[] args)
    {
        // Must declare data type
        LinkedList<Integer> list = new LinkedList<>();

        // Using generator
        Random gen = new Random();


        for (int i = 0; i < 10; i ++ )
        {
            int num = gen.nextInt(11);
            list.add(num);
        }
        System.out.println("Standard List: ");
        list.print();

        // "Whiteboard" Visualization
        /*
        [1] -> [2] -> [3] -> [4]
     L   M     R   
        */

       // Code to reverse list 
       Node<Integer> left = null;
       Node<Integer> curr = list.head;
       Node<Integer> right = curr.next;

        while (right != null )
        {
            curr.next = left;
            left = curr;
            curr = right;
            right = right.next;
        }
        curr.next = left;

        // Creating new object to use the .print() method
        System.out.println("\nReversed List: ");
        LinkedList<Integer> reversedList = new LinkedList<>(curr, 10);
        reversedList.print();


        




       




        


    }
}