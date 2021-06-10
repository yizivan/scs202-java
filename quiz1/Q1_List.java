public class Q1_List
{
    private LLNode<NovaClass> tail;
    private int length;
    public Q1_List()
    {
        tail = null;
        length = 0;
    }
    public void add(String nextLine)
    {
        String[] tmdString = nextLine.split(",");
        NovaClass tmdClass = new NovaClass(tmdString[0], tmdString[1], tmdString[2]);
        LLNode<NovaClass> newNode = new LLNode(null, null, null);
        if (tail == null)
        {
            newNode.info = tmdClass;
            tail = newNode;
            tail.next = tail;
            length++;
        }
        else
        {
            newNode.info = tmdClass;
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
            length ++;
        }
    }
    public String toString()
    {
        LLNode<NovaClass> listNode = tail;
        for (int i = 0; i < (length - 1); i ++)
        {
            System.out.print(listNode.info.getClassLetter() + "-->");
            listNode = listNode.next;
        }
        System.out.print(listNode.info.getClassLetter());
        return ("");
    }
    
}