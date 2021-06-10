public class NovaClass
{
    private String className;
    public NovaClass()
    {

    }
    public NovaClass(String name)
    {
        className = name;
    }
    public void setClassName(String name)
    {
        className = name;
    }
    public String getClassName()
    {
        return className;
    }
    public String toString()
    {
        return (className);
    }
}