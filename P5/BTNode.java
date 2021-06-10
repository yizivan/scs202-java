public class BTNode<T>
{
    private BTNode<T> parent;
    private BTNode<T> leftson;
    private BTNode<T> rightson;
    private T info;
    public BTNode(T info)
    {
        this.info = info;
        parent = null;
        leftson = null;
        rightson = null;
    }
    public void setParent(BTNode<T> p)
    {
        parent = p;
    }
    public void setLeftson(BTNode<T> l)
    {
        leftson = l;
    }
    public void setRightson(BTNode<T> r)
    {
        rightson = r;
    }
    public T getInfo()
    {
        return info;
    }
    public BTNode<T> getParent()
    {
        return parent;
    }
    public BTNode<T> getLeftson()
    {
        return leftson;
    }
    public BTNode<T> getRightson()
    {
        return rightson;
    }

}