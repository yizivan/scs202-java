package P4_SHI_Y;
public class NovaClass implements Comparable<NovaClass>
{
    private String ClassLetter;
    private String ClassName;
    private int ClassNumber;
    private String ClassNote;
    public NovaClass()
    {

    }
    public NovaClass(String classletter, String classname, int classnumber, String classnote)
    {
        ClassLetter = classletter;
        ClassName = classname;
        ClassNumber = classnumber;
        ClassNote = classnote;
    }
    public String getClassLetter()
    {
        return ClassLetter;
    }
    public String getClassName()
    {
        return ClassName;
    }
    public int getClassNumber()
    {
        return ClassNumber;
    }
    public String getClassNote()
    {
        return ClassNote;
    }
    public void setClassLetter(String classletter)
    {
        ClassLetter = classletter;
    }
    public void setClassName(String classname)
    {
        ClassName = classname;
    }
    public void setClassNumber(int classnumber)
    {
        ClassNumber = classnumber;
    }
    public void setClassNote(String classnote)
    {
        ClassNote = classnote;
    }
    public String toString()
    {
        return ClassLetter;
    }
    public int compareTo(NovaClass secondClass) 
    {
        if (ClassNumber < secondClass.getClassNumber())
            return -1;
        if (ClassNumber > secondClass.getClassNumber())
            return 1;
        if (ClassName.compareTo(secondClass.getClassName()) < 0)
            return -1;
        if (ClassName.compareTo(secondClass.getClassName()) > 0)
            return 1;
        if (ClassNote.compareTo(secondClass.getClassNote()) < 0)
            return -1;
        if (ClassNote.compareTo(secondClass.getClassNote()) > 0)
            return 1;
        return 0;
    }
}