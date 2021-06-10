public class LinkedStack<T>
{
    private LLNode<T> top ;
    public LinkedStack()
    {
        top = new LLNode<T>(null,null,null);
    }
    public void push(LLNode<T> node)
    {
        node.father = top;
        top = node;
    }
    public LLNode<T> pop()
    {
        if (top.info != null)
        {
            top = top.father;
        }
        return top;
    }
    public boolean isEmpty()
    {
        if (top.info == null)
        {
            return true;
        }
        return false;
    }
    public LLNode<T> getTop()
    {
        return top;
    }

}