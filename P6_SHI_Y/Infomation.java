package P6_SHI_Y;
public class Infomation implements Comparable<Infomation>
{
    private String name;
    private double value;
    public Infomation()
    {

    }
    public Infomation(String name, double value)
    {
        this.name = name;
        this.value = value;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setValue(double value)
    {
        this.value = value;
    }
    public String getName()
    {
        return name;
    }
    public double getValue()
    {
        return value;
    }
    public int compareTo(Infomation secondDP) 
    {
        String tmdone = name + String.valueOf(value);
        String tmdtwo = secondDP.getName() + String.valueOf(secondDP.getValue());
        if (tmdone.compareTo(tmdtwo) < 0)
            return -1;
        if (tmdone.compareTo(tmdtwo) > 0)
            return 1;
        return 0;
    }
}