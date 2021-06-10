import java.util.Comparator;
public class BinarySearchTree<T> extends BinaryTree<T>
{
    private Comparator<T> comp;
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
        else if (comp.compare(element, node.getInfo()) <= 0)
        {
            node.setLeftson(recAdd(element, (BSTNode<T>) node.getLeftson()));
        }
        else if (comp.compare(element, node.getInfo()) > 0)
        {
            node.setRightson(recAdd(element, (BSTNode<T>) node.getRightson()));
        }
        return node;
    }
    public boolean add(T element)
    {
        root = recAdd(element, (BSTNode<T>) root);
        return true;
    }
    
}