public class P2_List
{
    private LLNode<NovaClass> head;
    private LLNode<NovaClass> tmdHead;
    private LLNode<NovaClass> tail;
    private LinkedStack<NovaClass> myLinkedStack = new LinkedStack<NovaClass>();
    public P2_List()
    {
        head = null;
        tail = null;
    }
    public void addNext(String nextString)
    {
        String tmdString = nextString;
        NovaClass tmdClass = new NovaClass(tmdString);
        LLNode<NovaClass> newNode = new LLNode<NovaClass>(null, null, tmdClass);
        if (tail == null)
        {
            head = newNode;
            tail = newNode;
            myLinkedStack.push(newNode);
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void addNest(String nextString)
    {
        String tmdString = nextString;
        NovaClass tmdClass = new NovaClass(tmdString);
        LLNode<NovaClass> newNode = new LLNode<NovaClass>(null, null, tmdClass);
        if (tail == null)
        {
            head = newNode;
            tail = newNode;
            myLinkedStack.push(newNode);
        }
        else
        {
            tail.nest = newNode;
            tail = newNode;
            myLinkedStack.push(newNode);
        }
    }
    public void popFromStack()
    {
        if (!myLinkedStack.isEmpty())
        {
            tmdHead = myLinkedStack.pop();
            tail = tmdHead;
            while (tail.next != null)
            {
                tail = tail.next; 
            }
        }
    }
    public void printOut(LLNode<NovaClass> node, int space)
    {
        for (int i = 0; i < space; i++)
        {
            System.out.print(" ");
        }
        System.out.println(node.info);
        if (node.nest != null)
        {
            printOut(node.nest, space + node.info.getClassName().length());
        }
        if (node.next != null)
        {
            printOut(node.next, space);
        }
    }
    public String toString()
    {
        printOut(head,0);
        return "";
    }
}