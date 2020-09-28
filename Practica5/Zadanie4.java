public class Zadanie4 {public static int recursion(int len, int sum, int k, int s)
{
    if (len == k)
    {
        if (sum == s)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    int c = (len == 0 ? 1 : 0);
    int res = 0;
    for (int i = c; i < 10; i++)
    {
        res += recursion(len + 1, sum + i, k, s);
    }
    return res;
}
    public static void main(String[] args)
    {
        System.out.println(recursion(0, 0, 4, 12));
    }
}
