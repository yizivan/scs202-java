package P4_SHI_Y;
public class PrintList<T>
{
    private BSTNode<T> head;
    private BSTNode<T> tail;
    private BSTNode<T> mid;
    public PrintList()
    {
        head = null;
        tail = null;
        mid = null;
    }
    public void add(BSTNode<T> link)
    {
        if (head == null)
        {
            head = link;
            tail = link;
        }
        else
        {
            tail.setNext(link);
            tail = link;
        }
    }
    public void take()
    {
        head = head.getNext();
    }
    public BSTNode<T> getHead()
    {
        return head;
    }
    public BSTNode<T> getTail()
    {
        return tail;
    }
    public void setMid(BSTNode<T> mid)
    {
        this.mid = mid;
    }
    public BSTNode<T> getMid()
    {
        return mid;
    }
}