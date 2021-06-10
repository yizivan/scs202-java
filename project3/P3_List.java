public class P3_List
{
    private LLNode<NovaClass> head;
    private String line;
    public P3_List()
    {
        head = null;
    }
    public LLNode<NovaClass> build(LLNode<NovaClass> myTail)
    {
        String tmdString = "";
        int mark =0;
        if (line.length() < 1) return null;
        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) != '(' && line.charAt(i) != ')' && line.charAt(i) != ',')
            {
                tmdString = tmdString + line.charAt(i);
            }
            else 
            {
                mark = i;
                break;
            }   
        }
        NovaClass tmdClass = new NovaClass(tmdString);
        LLNode<NovaClass> newNode = new LLNode<NovaClass>(null, null, tmdClass);
        if (head == null)
            head = newNode;
        line = line.substring(mark);
        if (line.charAt(0) == '(')
        {
            line = line.substring(1);
            newNode.nest = build(newNode);
            newNode.next = build(newNode);
            return newNode;
        }
        else if (line.charAt(0) == ',')
        {
            line = line.substring(1);
            newNode.next = build(newNode);
            if (!tmdString.equals(""))
            	return newNode;
            else 
            	return newNode.next;
        }
        else if (line.charAt(0) == ')')
        {	
        	line = line.substring(1);
        	if (!tmdString.equals(""))
        		return newNode; 
        }
        return null;
   
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
    public void setLine(String line)
    {
    	this.line = line;
    }
    public String toString()
    {
        printOut(head,0);
        return "";
    }
}