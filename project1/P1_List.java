public class P1_List
{
    private LLNode firstNode;
    private LLNode lastNode;
    private int length;
    public P1_List()
    {
        firstNode = null;
        lastNode = null;
        length = 0;
    }
    public void add(String nextLine)
    {
        String[] tmdString = nextLine.split(",");
        NovaClass tmdClass = new NovaClass(tmdString[0], tmdString[1], tmdString[2]);
        LLNode newNode = new LLNode(null, null, null);
        if (firstNode == null)
        {
            newNode.data = tmdClass;
            firstNode = newNode;
            lastNode = newNode;
            length++;
        }
        else
        {
            newNode.data = tmdClass;
            lastNode.next = newNode;
            newNode.pre = lastNode;
            lastNode = newNode;
            length ++;
        }
    }
    public boolean insertLLNode(LLNode movingnode, LLNode locatednode, String direction)
    {
        LLNode movingNode = firstNode;
        while (movingNode != null)
        {
            if (movingNode.data.equals(movingnode.data))
                break;
            else
            {
                movingNode = movingNode.next;
            }
        }
        if (movingNode == null) return false;
        LLNode locatedNode = firstNode;
        while (locatedNode != null)
        {
            if (locatedNode.data.equals(locatednode.data))
                break;
            else
            {
                locatedNode = locatedNode.next;
            }
        }
        if (locatedNode == null) return false;
        if (!locatedNode.equals(movingNode))
        {
            if (movingNode.equals(firstNode))
            {
                movingNode.next.pre = null;
                firstNode = movingNode.next;
            }
            else if (movingNode.equals(lastNode))
            {
                movingNode.pre.next = null;
                lastNode = movingNode.pre;
            }
            else
            {
                movingNode.pre.next = movingNode.next;
                movingNode.next.pre = movingNode.pre;
            }
            if (direction.equals("a"))
            {
                if (locatedNode.next != null)
                {
                    locatedNode.next.pre = movingNode;
                    movingNode.next = locatedNode.next;
                    locatedNode.next = movingNode;
                    movingNode.pre = locatedNode;
                }
                else
                {
                    locatedNode.next = movingNode;
                    movingNode.pre = locatedNode;
                    movingNode.next = null;
                    lastNode = movingNode;
                } 
            }
            if (direction.equals("b"))
            {
                if (!locatedNode.equals(firstNode))
                {
                    locatedNode.pre.next = movingNode;
                    movingNode.pre = locatedNode.pre;
                    locatedNode.pre = movingNode;
                    movingNode.next = locatedNode;
                }
                else
                {
                    locatedNode.pre = movingNode;
                    movingNode.next = locatedNode;
                    movingNode.pre = null;
                    firstNode = movingNode;
                }
                
            }
        }
        
        return true;
    }
    public int getLength()
    {
        return length;
    }
    public LLNode getFirstNode()
    {
        return firstNode;
    }
    public void printList()
    {
        LLNode listNode = firstNode;
        for (int i = 0; i < (length - 1); i ++)
        {
            System.out.print(listNode.data.getClassLetter() + "-->");
            listNode = listNode.next;
        }
        System.out.println(listNode.data.getClassLetter());
    }
    public LLNode checkList(String checkedString)
    {
        LLNode listNode = firstNode;
        for (int i = 0; i < length; i++)
        {
            if (listNode.data.getClassLetter().equals(checkedString))
            {
                break;
            }
            listNode = listNode.next;
        }
        return listNode;
    }
}