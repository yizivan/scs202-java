public class BSTNode<T>
{
    private BSTNode<T> parent;
    private BSTNode<T> leftson;
    private BSTNode<T> rightson;
    private T info;
    public BSTNode()
    {

    }
    public BSTNode(T info)
    {
        this.info = info;
        parent = null;
        leftson = null;
        rightson = null;
    }
    public void setParent(BSTNode<T> p)
    {
        parent = p;
    }
    public void setLeft(BSTNode<T> l)
    {
        leftson = l;
    }
    public void setRight(BSTNode<T> r)
    {
        rightson = r;
    }
    public void setInfo(T data)
    {
        info = data;
    }
    public T getInfo()
    {
        return info;
    }
    public BSTNode<T> getParent()
    {
        return parent;
    }
    public BSTNode<T> getLeft()
    {
        return leftson;
    }
    public BSTNode<T> getRight()
    {
        return rightson;
    }

}