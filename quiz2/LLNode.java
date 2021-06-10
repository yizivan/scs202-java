

public class LLNode<T>
{
    public LLNode<T> next;
    public LLNode<T> nest;
    public LLNode<T> father;
    public int level;
    public T info;
    public LLNode()
    {
    }
    public LLNode(LLNode<T> nest, LLNode<T> next,T info)
    {
        this.nest = nest;
        this.next = next;
        this.info = info;
        father = null;
    }
    public String toString()
    {
        return String.valueOf(info);
    }
}