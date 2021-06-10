public class Q2_List
{
    private LLNode<NovaClass> head;
    private LLNode<NovaClass> tmdHead;
    private LLNode<NovaClass> tail;
    private LinkedStack<NovaClass> myLinkedStack = new LinkedStack<NovaClass>();
    public Q2_List()
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
            tail.level = 1;
            myLinkedStack.push(newNode);
        }
        else
        {
            tail.next = newNode;
            newNode.level = tail.level;
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
            tail.level = 1;
            myLinkedStack.push(newNode);
        }
        else
        {
            tail.nest = newNode;
            newNode.level = tail.level + 1;
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
    public void printLevel(int level)
    {
        LinkedStack<NovaClass> levelStack = new LinkedStack<NovaClass>();
        LLNode<NovaClass> fakeHead = head;
        LLNode<NovaClass> fakeTail = head;
        int rightLevel = 1;
        levelStack.push(fakeTail);
        while (fakeTail != null)
        {
            if (rightLevel == level)
            {
                while (fakeTail != null)
                {
                    System.out.print(fakeTail.info.getClassName() + " ");
                    fakeTail = fakeTail.next;
                }
                fakeTail = levelStack.pop().next;
                rightLevel --;
                levelStack.pop();
                levelStack.push(fakeTail);
            }
            else if (fakeTail.nest != null)
            {
                fakeTail = fakeTail.nest;
                levelStack.push(fakeTail);
                rightLevel ++;
            }
            else if (fakeTail.next != null)
            {
                fakeTail = fakeTail.next;
                levelStack.pop();
                levelStack.push(fakeTail);
            }
            else 
            {
                fakeTail = levelStack.pop().next;
                levelStack.pop();
                levelStack.push(fakeTail);
                rightLevel --;
            }
        }
    }
    public void printStack(LLNode<NovaClass> node , int level)
    {
        if (node.level == level)
            System.out.print(node.info + " ");
        if (node.nest != null)
        {
            printStack(node.nest, level);
        }
        if (node.next != null)
        {
            printStack(node.next, level);
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
    public void print(int level)
    {
        printStack(head, level);
    }
    public String toString()
    {
        printOut(head,0);
        return "";
    }
}