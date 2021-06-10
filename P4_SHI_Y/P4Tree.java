package P4_SHI_Y;
public class P4Tree
{
    private BinarySearchTree<NovaClass> myTree = new BinarySearchTree<NovaClass>();
    private NovaClass found = null;
    public P4Tree()
    {

    }
    public void addNode(String line)
    {
        String[] tmdStrings = line.split(", ");
        String classLetter = tmdStrings[0];
        String classNote = tmdStrings[2];
        String[] secondTmdString = tmdStrings[1].split(" ");
        String className = secondTmdString[0];
        int classNumber = Integer.valueOf(secondTmdString[1]);
        NovaClass tmdClass = new NovaClass(classLetter, className, classNumber, classNote);
        myTree.add(tmdClass);
    }
    private void check(String letter, BSTNode<NovaClass> node)
    {
        if (node.getInfo().getClassLetter().compareTo(letter) == 0)
        {
            found = node.getInfo();
        }
        if (node.getLeft() != null)
            check(letter, node.getLeft());
        if (node.getRight() != null)
            check(letter, node.getRight());
    }
    private NovaClass findNode(String letter)
    {
        found = null;
        check(letter, myTree.root);
        return found;
    }
    public void remove(String target)
    {
        myTree.remove(findNode(target));
    }
    public String toString()
    {
        System.out.println(myTree);
        return "";
    }
}