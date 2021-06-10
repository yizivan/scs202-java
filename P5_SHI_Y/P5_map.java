package P5_SHI_Y;
import java.util.Scanner;
public class P5_map
{
    private ArrayListMap<String, BTNode<DesicionPoint>> myMap = new ArrayListMap<String,BTNode<DesicionPoint>>();
    private BinaryTree<DesicionPoint> myBTree = new BinaryTree<DesicionPoint>();
    private BinarySearchTree<DesicionPoint> myBSTree = new BinarySearchTree<DesicionPoint>();
    private Scanner keyboard = new Scanner(System.in);
    public P5_map()
    {

    }
    public void add (String input)
    {
        String[] tmdString = input.split(": ");
        DesicionPoint tmdDP = new DesicionPoint(tmdString[0], tmdString[1]);
        BTNode<DesicionPoint> tmdNode = new BTNode<DesicionPoint>(tmdDP);
        myMap.put(tmdString[0], tmdNode);
    }
    public void builBT(String input)
    {
        String[] tmdString = input.split(":");
        myBTree.add(myMap.get(tmdString[0]), myMap.get(tmdString[1]), myMap.get(tmdString[2]));
    }
    public void printMyBTree(int order)
    {
        myBTree.print(order);
        for (int i=0; i < myBTree.getPrintList().size(); i++)
        {
            myBSTree.add(myBTree.getPrintList().get(i).getInfo());
        }
    }
    public void printMyBSTree(int order)
    {
        myBSTree.print(order);
    }
    public void goThroughBTree()
    {
        BTNode<DesicionPoint> tmdNode = myBTree.goThroughTree("q");
        while (true)
        {
            if (tmdNode.getLeftson() == null && tmdNode.getRightson() == null)
            {
                System.out.println("Congrats - your semester grade will be " + tmdNode.getInfo().getValue().toString());
                break;
            }
            System.out.println(tmdNode.getInfo().getValue().toString());
            System.out.print(">>");
            String enter = keyboard.nextLine();
            tmdNode = myBTree.goThroughTree(enter.toUpperCase());
        }
    }
}