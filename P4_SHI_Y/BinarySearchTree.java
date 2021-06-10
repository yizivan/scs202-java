package P4_SHI_Y;
import java.util.Comparator;
public class BinarySearchTree<T>
{
    protected BSTNode<T> root;
    protected Comparator<T> comp;
    private int position = 0;
    public BinarySearchTree()
    {
        root = null;
        comp = new Comparator<T>()
        {
            public int compare(T elementOne, T elementTwo)
            {
                return ((Comparable) elementOne).compareTo(elementTwo);
            }
        };
    }
    public BinarySearchTree(Comparator<T> comp)
    {
        root = null;
        this.comp = comp;
    }

    private BSTNode<T> recAdd(T element, BSTNode<T> node)
    {
        if (node == null)
        {
            node = new BSTNode<T>(element);
        }
        else if (comp.compare(element, node.getInfo()) < 0)
        {
            node.setLeft(recAdd(element, node.getLeft()));
        }
        else if (comp.compare(element, node.getInfo()) > 0)
        {
            node.setRight(recAdd(element, node.getRight()));
        }
        return node;
    }
    public boolean add(T element)
    {
        root = recAdd(element, root);
        return true;
    }
    private int recSize(BSTNode<T> node)
    {
        if (node == null)
        {
            return 0;
        }
        else 
        {
            return (1 + recSize(node.getLeft()) + recSize(node.getRight()));
        }
    }
    public int size()
    {
        return recSize(root);
    }
    private BSTNode<T> removeNode(BSTNode<T> node)
    {
        T data;
        if (node.getLeft() == null)
        {
            return node.getRight();
        }
        else if (node.getRight() == null)
        {
            return node.getLeft();
        }
        else 
        {
            data = node.getLeft().getInfo();
            node.setInfo(data);
            node.setLeft(recRemove(data, node.getLeft()));
            return node;
        }
    }
    private BSTNode<T> recRemove(T target, BSTNode<T> node)
    {
        if (node == null)
        {
            return node;  
        }
        else if (comp.compare(target, node.getInfo()) < 0)
        {
            node.setLeft(recRemove(target, node.getLeft()));
        }
        else if (comp.compare(target, node.getInfo()) > 0)
        {
            node. setRight(recRemove(target, node.getRight()));
        }
        else
        {
            node = removeNode(node);
        }
        return node;
    }
    public boolean remove (T target)
    {
        BSTNode<T> tmd = recRemove(target, root);
        if (tmd != null)
        {
            return true;
        }
        else
        {
            return false;
        } 
    }
    private void presetPosition(BSTNode<T> node)
    {
        node.setPrintPositioin(position);
        position ++;
        if (node.getLeft() != null)
        {
            presetPosition(node.getLeft());
        }
        if (node.getRight() != null)
        {
            presetPosition(node.getRight());
        }
    }
    public void Print()
    {
        position = 0;
        PrintList<T> myPrint = new PrintList<T>();
        presetPosition(root);
        myPrint.add(root);
        while (myPrint.getHead() != null)
        {
            myPrint.setMid(myPrint.getTail());
            for (int i = 0; i <= myPrint.getMid().getPrintPosition(); i++)
            {
                if (i == myPrint.getHead().getPrintPosition())
                {
                    System.out.print(myPrint.getHead().getInfo());
                    if (myPrint.getHead().getLeft() != null)
                    {
                        myPrint.add(myPrint.getHead().getLeft());
                    }
                    if (myPrint.getHead().getRight() != null)
                    {
                        myPrint.add(myPrint.getHead().getRight());
                    }
                    myPrint.take();
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public String toString()
    {
        Print();
        return ("");
    }
}