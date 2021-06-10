public class LLNode<T>
{
    public LLNode<T> pre;
    public LLNode<T> next;
    public T info;
    public NovaClass data;
    /**
     * default constructor;
     */
    public LLNode()
    {

    }
    /**
     * constructor which set up variables by enter variables;
     * @precondition: the Node object pre;
     *                the Node object next;
     *                the NovaClass data; 
     * @postcondition: pre has been change to preview;
     *                 next has been change to nextone;
     *                 this.data has been change to data;
     * @param preview
     * @param data
     * @param nextone
     */
    public LLNode(LLNode preview, NovaClass data, LLNode nextone)
    {
        pre = preview;
        next = nextone;
        this.data = data;
    }
}