public class fibonacci {
    int a = 0,b = 1;
    int res(int n){
        if(n<=1)
            return n;
        else return res(n-1)+res(n-2);
    }
    public static void main(String[] args){
        fibonacci f = new fibonacci();
        System.out.println(f.res(13));//0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987
    }
}
