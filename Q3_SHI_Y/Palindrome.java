package Q3_SHI_Y;
public class Palindrome
{
    public static boolean test(String candidate)
    {
        char ch;
        int length;
        length = candidate.length();
        DLinkedList<Character> queue = new DLinkedList<Character>();
        for (int i = 0; i<length; i++)
        {
            ch = candidate.charAt(i);
            if (Character.isLetter(ch))
            {
                ch = Character.toLowerCase(ch);
                queue.addEnd(ch);
            }
        }
        return testPalindromeRecur(queue);
    }

    public static boolean testPalindromeRecur(DLinkedList<Character> q)
    {
        if (q.size() <= 0) return true;
        if (q.removeFront() != q.removeRear())
            return false;
        else 
            return testPalindromeRecur(q);
    }
}