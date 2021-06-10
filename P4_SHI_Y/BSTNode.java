package P4_SHI_Y;
public class BSTNode<T>
{
    private T info;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private BSTNode<T> next;
    private int printPosition;
    public BSTNode(T info)
    {
        this.info = info;
        left = null;
        right = null;
        next = null;
        printPosition = 0;
    }
    public void setInfo(T info)
    {
        this.info = info;
    }
    public T getInfo()
    {
        return info;
    }
    public void setLeft(BSTNode<T> link)
    {
        left = link;
    }
    public void setRight(BSTNode<T> link)
    {
        right = link;
    }
    public BSTNode<T> getLeft()
    {
        return left;
    }
    public BSTNode<T> getRight()
    {
        return right;
    }
    public void setNext(BSTNode<T> link)
    {
        next = link;
    }
    public BSTNode<T> getNext()
    {
        return next;
    }
    public void setPrintPositioin(int ps)
    {
        printPosition = ps;
    }
    public int getPrintPosition()
    {
        return printPosition;
    }
}