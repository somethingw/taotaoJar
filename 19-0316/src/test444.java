/**
 * @author week
 * @Title: test444
 * @ProjectName 19-0316
 * @Description: 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 体育场突然着火了，现场需要紧急疏散，但是过道真的是太窄了，同时只能容许一个人通过。
 * 现在知道了体育场的所有座位分布，座位分布图是一棵树，已知每个座位上都坐了一个人，安全出口在树的根部，也就是1号结点的位置上。
 * 其他节点上的人每秒都能向树根部前进一个结点，但是除了安全出口以外，没有任何一个结点可以同时容纳两个及以上的人，这就需要一种策略，
 * 来使得人群尽快疏散，问在采取最优策略的情况下，体育场最快可以在多长时间内疏散完成。
 * 第一行包含一个正整数n，即树的结点数量（1<=n<=100000）。
 * 接下来有n-1行，每行有两个正整数x，y，表示在x和y结点之间存在一条边。(1<=x<=y<=n)
 * 2 1
 * 3 2
 * 4 3
 * 5 2
 * 6 1
 * @date 2019/4/1319:38
 */
import java.util.*;
public class test444 {
    static int[] L;
    static int[] R;
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1){
            System.out.println(0);
        }else{
            L=new int[n];
            R=new int[n];
            int index=0;
            for(int i=0;i<n-1;i++){
                L[i]=sc.nextInt();
                R[i]=sc.nextInt();
                if(R[i]==1){
                    index=i;
                }
            }
            find(L[index]);
            int res=(n-1)/2;
            System.out.println(count>=res?count:n-1-count);
        }

    }
    public static void find(int num){
        count++;
        for(int i=0;i<R.length;i++){
            if(R[i]==num) {
                find(L[i]);
            }
        }
    }
}
