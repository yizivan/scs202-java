public class P6_map
{
    private HMap<String, Infomation> myHmap = new HMap<String, Infomation>();
    private int duplicatesLL = 0;
    private int notFindRecLL = 0;
    private int duplicatesBST = 0;
    private int notFindRecBST = 0;
    public P6_map()
    {

    }
    public void setUpSize(int size)
    {
        myHmap.fixedSize(size);
    }
    public void addLL(String input)
    {
        String[] tmdString = input.split(",");
        Infomation tmdInfo = new Infomation(tmdString[0], Double.valueOf(tmdString[1]));
        myHmap.putLL(tmdInfo.getName(), tmdInfo);
    }
    public void addBST(String input)
    {
        String[] tmdString = input.split(",");
        Infomation tmdInfo = new Infomation(tmdString[0], Double.valueOf(tmdString[1]));
        myHmap.putBST(tmdInfo.getName(), tmdInfo);
    }
    public double getAveChainLengthLL()
    {
        return myHmap.getAveChainLengthLL();
    }
    public double getAveChainLengthBST()
    {
        return myHmap.getAveChainLengthBST();
    }
    public double getSDLL()
    {
        return myHmap.getSDLL();
    }
    public double getSDBST()
    {
        return myHmap.getSDBST();
    }
    public int getDupLL()
    {
        return duplicatesLL;
    }
    public int getDupBST()
    {
        return duplicatesBST;
    }
    public void searchLL(String input)
    {
        if (myHmap.getLL(input) == null)
        {
            notFindRecLL ++;
        }
        else 
        {
            duplicatesLL ++;
        }
    }
    public void searchBST(String input)
    {
        if (myHmap.getBST(input) == null)
        {
            notFindRecBST ++;
        }
        else 
        {
            duplicatesBST ++;
        }
    }
    public int getNFRLL()
    {
        return notFindRecLL;
    }
    public int getNFRBST()
    {
        return notFindRecBST;
    }
    public boolean removeBST(String input)
    {
        return myHmap.removeBST(input);
    }
}