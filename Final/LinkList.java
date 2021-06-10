public class LinkList<T>
{
    private LLNode<T> head;
    private LLNode<T> tail;
    private int length;
    public LinkList()
    {
        head = null;
        tail = null;
        length = 0;
    }
    public void add(LLNode<T> newNode)
    {
        if (length == 0)
        {
            head = newNode;
            tail = newNode;
            length ++;
        }
        else 
        {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
            length ++;
        }
    }
    public LLNode<T> search(T data)
    {
        
        LLNode<T> tmdNode = head;
        while (tmdNode != null)
        {
            if (tmdNode.info.toString().equals(data.toString()))
            {
                return tmdNode;
            }
            else 
            {
                tmdNode = tmdNode.next;
            }
        }
        return null;
    }
    public LLNode<T> remove(T data)
    {
        LLNode<T> tmdNode = head;
        while (tmdNode != null)
        {
            if (tmdNode.info.toString().equals(data.toString()))
            {
                if (tmdNode == head)
                {
                    head = tmdNode.next;
                    head.pre = null;
                }
                else 
                {
                    if (tmdNode.next != null)
                    {
                        tmdNode.next.pre = tmdNode.pre;
                        tmdNode.pre.next = tmdNode.next;
                    }
                    else 
                    {
                        tmdNode.pre.next = tmdNode.next;
                    }
                }
                return tmdNode;
            }
            else 
            {
                tmdNode = tmdNode.next;
            }
        }
        return null;
    }
    public int getLength()
    {
        return length;
    }
}