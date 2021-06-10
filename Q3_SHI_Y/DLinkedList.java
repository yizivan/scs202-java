package Q3_SHI_Y;
public class DLinkedList<T>
{
    DLLNode<T> front, rear;
    int numElement;
    public DLinkedList()
    {
        front = null;
        rear = null;
        numElement = 0;
    }
    public void addEnd(T element)
    {
        DLLNode<T> newNode = new DLLNode<T>(element);
        newNode.setForward(null);
        newNode.setBack(rear);
        if (rear == null)
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.setForward(newNode);
            rear = newNode;
        }
        numElement ++;
    }
    public T removeFront()
    {
        T element;
        element = front.getInfo();
        front = front.getForward();
        if (front != null)
            front.setBack(null);
        numElement--;
        return element;
    }
    public T removeRear()
    {
        T element;
        element = rear.getInfo();
        rear = rear.getBack();
        if (rear == null)
        {
            front = null;
        }
        else
        {
            rear.setForward(null);
        }
        numElement--;
        return element;
    }
    public boolean isFull()
    {
        return false;
    }
    public int size()
    {
        return numElement;
    }
}