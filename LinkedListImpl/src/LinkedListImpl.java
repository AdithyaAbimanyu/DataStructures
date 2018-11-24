public class LinkedListImpl
{
    LinkedListImpl next;
    int val;
    LinkedListImpl(int val)
    {
        this.val = val;
        next = null;
    }

    public LinkedListImpl() {

    }

    public static LinkedListImpl addFirst(int val, LinkedListImpl head)
    {
        if(head == null)
        {
            head = new LinkedListImpl(val);
            return head;
        }
        LinkedListImpl node =new LinkedListImpl(val);
        node.next = head;
        head = node;
        return head;
    }

    public void iterateHead()
    {
        LinkedListImpl crawl = this;
        while(crawl!=null)
        {
            System.out.print(crawl.val+"->");
            crawl = crawl.next();
        }
        System.out.println("null");
    }

    private LinkedListImpl next()
    {
        return next;
    }

    private boolean hasNext()
    {
        return next!=null;
    }

    public void findCycle()
    {
        LinkedListImpl slowCursor = this;
        LinkedListImpl fastCursor = this;
        while(slowCursor != null && fastCursor != null)
        {
            slowCursor = slowCursor.next();
            fastCursor = fastCursor.next();
            if(fastCursor !=null)
            {
                fastCursor =fastCursor.next();
            }
            if(slowCursor!=null && fastCursor!=null && slowCursor == fastCursor)
            {
                System.out.println("Loop detected "+slowCursor.val);
                break;
            }
        }
        if(slowCursor == null || fastCursor == null)
        {
            System.out.println("No loop detected");
        }
    }

    public LinkedListImpl swap(int x, int y)
    {
        LinkedListImpl crawl = this;
        LinkedListImpl prevX = null, prevY = null;
        LinkedListImpl currX = this, currY = this;
        LinkedListImpl head = this;
        while(crawl!=null)
        {
            if(crawl.val == x)
            {
                prevX = currX;
                currX = crawl;
            }
            if(crawl.val == y)
            {
                prevY = currY;
                currY = crawl;
            }
            crawl =crawl.next;
        }
        if(prevX == null && prevY == null)
        {
            return null;
        }

        if(prevX!=null)
        {
            prevX.next = currY;
        }
        else
        {
             head = currY;
        }

        if(prevY!=null)
        {
            prevY.next = currX;
        }
        else
        {
            head = currX;
        }

        currX.next = currY.next;
        currY.next = currX.next;
        return head;
    }
}
