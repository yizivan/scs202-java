package P5_SHI_Y;
public class DesicionPoint implements Comparable<DesicionPoint>
{
    private String key;
    private String value;
    public DesicionPoint(String key, String value)
    {
        this.key = key;
        this.value = value;
    }
    public void setKey(String key)
    {
        this.key = key;
    }
    public void setValue(String value)
    {
        this.value = value;
    }
    public String getKey()
    {
        return key;
    }
    public String getValue()
    {
        return value;
    }
    public int compareTo(DesicionPoint secondDP) 
    {
        if (String.valueOf(value).compareTo(String.valueOf(secondDP.getValue())) < 0)
            return -1;
        if (String.valueOf(value).compareTo(String.valueOf(secondDP.getValue())) > 0)
            return 1;
        return 0;
    }
    public String toString()
    {
        return key;
    }
}