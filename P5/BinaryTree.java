import java.util.ArrayList;
public class BinaryTree<T>
{
    protected BTNode<T> root;
    protected ArrayList<BTNode<T>> myPrintList = new ArrayList<BTNode<T>>();
    protected BTNode<T> point;
    public BinaryTree()
    {
        root = null;
    }
    public void add(BTNode<T> parent, BTNode<T> leftson, BTNode<T> rightson)
    {
        parent.setLeftson(leftson);
        parent.setRightson(rightson);
        leftson.setParent(parent);
        rightson.setParent(parent);
        if (root == null)
        {
            root = parent;
        }
        else 
        {
            while (root.getParent() != null)
            {
                root = root.getParent();
            }
        }
        point = root;
    }
    public void preOrderPrint(BTNode<T> target)
    {
        if (target != null) 
        {
            System.out.print(target.getInfo() + ",");
            myPrintList.add(target);
            preOrderPrint(target.getLeftson());
            preOrderPrint(target.getRightson());    
        }
    }
    public void inOrderPrint(BTNode<T> target)
    {
        if (target != null) 
        {
            inOrderPrint(target.getLeftson());
            System.out.print(target.getInfo() + ",");
            myPrintList.add(target);
            inOrderPrint(target.getRightson());    
        }
    }
    public void postOrderPrint(BTNode<T> target)
    {
        if (target != null) 
        {
            postOrderPrint(target.getLeftson());
            postOrderPrint(target.getRightson());
            System.out.print(target.getInfo() + ",");    
            myPrintList.add(target);
        }
    }
    public void print(int order)
    {
        myPrintList = new ArrayList<BTNode<T>>();
        if (order == 1)
        {
            preOrderPrint(root);
        }
        else if (order == 2)
        {
            inOrderPrint(root);
        }
        else if (order == 3)
        {
            postOrderPrint(root);
        }
    }
    public ArrayList<BTNode<T>> getPrintList()
    {
        return myPrintList;
    }
    public BTNode<T> goThroughTree(String YorN)
    {
        if (YorN.equals("Y"))
        {
            point = point.getLeftson();
            return point;
        }
        else if (YorN.equals("N"))
        {
            point = point.getRightson();
            return point;
        }
        return point;
    }
}