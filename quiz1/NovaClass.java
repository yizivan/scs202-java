public class NovaClass
{
    private String classLetter;
    private String classCode;
    private String className;
    public NovaClass()
    {

    }
    public NovaClass(String classletter, String classcode, String classname)
    {
        classLetter = classletter;
        classCode = classcode;
        className = classname;
    }
    public NovaClass(NovaClass novaclass)
    {
        classLetter = novaclass.getClassLetter();
        classCode = novaclass.getClassCode();
        classCode = novaclass.getClassName();
    }
    public String getClassLetter()
    {
        return classLetter;
    }
    public String getClassCode()
    {
        return classCode;
    }
    public String getClassName()
    {
        return className;
    }
    public void setClassLetter(String classletter)
    {
        classLetter = classletter;
    }
    public void setClassCode(String classcode)
    {
        classCode = classcode;
    }
    public void setClassName(String classname)
    {
        className = classname;
    }
    public boolean equals(NovaClass novaclass)
    {
        if (classLetter.equals(novaclass.getClassLetter()) && classCode.equals(novaclass.getClassCode()) && className.equals(novaclass.getClassName()))
        {
            return true;
        }
        return false;
    }
    public String toString()
    {
        return (classLetter + "|" + classCode + "|" + className);
    }
}