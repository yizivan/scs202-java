package P6_SHI_Y;
import java.util.Comparator;
public class BinarySearchTree<T>
{
    protected BSTNode<T> root;
    protected Comparator<T> comp;
    protected boolean found;
    private BSTNode<T> needNode;  
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
    // Removes the information at node from the tree. 
    {
      T data;
      if (node.getLeft() == null)
        return node.getRight();
      else if (node.getRight() == null) 
        return node.getLeft();
      else
      {
        data = getPredecessor(node.getLeft());
        node.setInfo(data);
        node.setLeft(recRemove(data, node.getLeft()));  
        return node;
      }
    }
  
    private T getPredecessor(BSTNode<T> subtree)
    // Returns the information held in the rightmost node of subtree
    {
      BSTNode<T> temp = subtree;
      while (temp.getRight() != null)
        temp = temp.getRight();
      return temp.getInfo();
    }
    private BSTNode<T> recRemove(T target, BSTNode<T> node)
    // Removes element with info i from tree rooted at node such that
    // comp.compare(target, i) == 0 and returns true; 
    // if no such node exists, returns false. 
    {
      if (node == null)
        found = false;
      else if (comp.compare(target, node.getInfo()) < 0)
        node.setLeft(recRemove(target, node.getLeft()));
      else if (comp.compare(target, node.getInfo()) > 0)
        node.setRight(recRemove(target, node.getRight()));
      else  
      {
        node = removeNode(node);
        found = true;
      }
      return node;
    }
  
    public boolean remove (T target)
    // Removes a node with info i from tree such that comp.compare(target,i) == 0
    // and returns true; if no such node exists, returns false.
    {
      root = recRemove(target, root);
      return found;
    }

    public void recContains(T target, BSTNode<T> node)
    {
        if (node != null)
        {
            if (target.toString().equals(node.getInfo().toString()))
            {
                needNode = new BSTNode<T>(node.getInfo());
                return;
            }       
            else 
            {
                recContains(target, node.getLeft());
                recContains(target, node.getRight());
            }
            
        }
    }
    public BSTNode<T> contains (T target)
    // Returns true if this BST contains a node with info i such that 
    // comp.compare(target, i) == 0; otherwise, returns false.
    {
        needNode = new BSTNode<T>(null);
        recContains(target, root);
        if (needNode.getInfo() != null)
            return needNode;
        else 
            return null;
    }

}