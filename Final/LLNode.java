public class LLNode<T>
{
    public LLNode<T> pre;
    public LLNode<T> next;
    public T info;
    /**
     * default constructor;
     */
    public LLNode()
    {
        pre = null;
        next = null;
        info = null;
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
    public LLNode(LLNode<T> preview, T data, LLNode<T> nextone)
    {
        pre = preview;
        next = nextone;
        info = data;
    }
}