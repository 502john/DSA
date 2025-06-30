class Solution {
    public ListNode reverseList(ListNode head) 
    {
        if ( head == null || head.next == null )
        {
            return head;
        }

        ListNode left = null;
        ListNode curr = head;
        ListNode right = curr.next;

        while (right != null)
        {
            curr.next = left;
            left = curr;
            curr = right;
            right = right.next;
        }
        curr.next = left;

        return curr;
    }
}