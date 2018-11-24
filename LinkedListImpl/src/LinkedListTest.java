public class LinkedListTest
{
    static LinkedListImpl head=null;
    public static void main(String args[])
    {
        head=LinkedListImpl.addFirst(5,head);
        head=LinkedListImpl.addFirst(7, head);
        head=LinkedListImpl.addFirst(6, head);
        head=LinkedListImpl.addFirst(10, head);
        head=LinkedListImpl.addFirst(9, head);
        head=LinkedListImpl.addFirst(10, head);
        head=LinkedListImpl.addFirst(1, head);
        head=LinkedListImpl.addFirst(3, head);
        head=LinkedListImpl.addFirst(20, head);

        head.iterateHead();

        head=sort(head);


//        head.next.next.next.next.next = head.next.next;

//        head.findCycle();
//        head.iterateHead();
//        head=head.swap(8,6);
        head.iterateHead();
    }

    private static LinkedListImpl sort(LinkedListImpl head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        LinkedListImpl next = findMiddleElement(head);
        head = sort(head);
        next = sort(next);
        head = mergeSort(head,next);
        return head;
    }

    private static LinkedListImpl mergeSort(LinkedListImpl head, LinkedListImpl next)
    {
        if(head == null)
        {
            return next;
        }
        if(next == null)
        {
            return head;
        }

        if(head.val < next.val)
        {
            head.next = mergeSort(head.next , next);
            return head;
        }
        next.next = mergeSort(head , next.next);
        return next;
    }

    private static LinkedListImpl findMiddleElement(LinkedListImpl head)
    {
        LinkedListImpl slow = head;
        LinkedListImpl fast = head;

        while(fast.next !=null)
        {
            fast = fast.next;
            if(fast.next!=null)
            {
                fast = fast.next;
                slow = slow.next;
            }
        }

        fast = slow.next;
        slow.next = null;
        return fast;


    }
}
