public class Zadanie5 {
    private static int n=0;
    public static int rec(int N)
    {
        if (N != 0)
        {
            N = N/ 10;
            n=n+1;
            return rec(N);
        }
        if (N==0)
        {
            System.out.println(n);
        }
        return 0;
    }


    public static void main(String[] args)
    {

        rec(1111);
    }
}
