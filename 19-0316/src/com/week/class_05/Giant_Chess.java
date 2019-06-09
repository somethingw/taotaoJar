package com.week.class_05;

/**
 * @author week
 * @Title: Giant_Chess
 * @ProjectName 19-0316
 * @Description: 不得不说，这道题很难。
 * 要掌握的知识点：
 * 第一部分：得到dp状态转移方程
 * 1.排列组合，从一个开始到达结束，一共C(m+n,n)种方法。
 * 2.计数类dp。
 * 3.用总方案数减去经过黑格子的方案个数，得到的就是答案。
 * 4.但是经过黑格子的路径可能经过很多个黑格子，导致重复计算。
 * 5.于是可以设dp[i]表示从起点到黑点i的合法路径个数，合法路径是说这之前不经过其他黑点。
 * 6.那么dp[i]=(起点走到点i的路径总数)-∑(dp[j]*(点j到点i的路径总数),点j在点i的左上方)
 * 第二部分：排序问题
 * 1.保证计算点i时，所有在点i左上方的点都计算过。可以通过坐标排序解决。
 * 第三部分：如何设计C(m+n,n)
 * 0.乘法逆元
 * 1.费马小定理。
 * 2.扩展欧几里得算法。
 * 3.阶乘的乘法逆元递推公式。
 * ps:每个我都有实现，其中计算N!的逆元我用的是费马小定理。扩展欧几里得算法闲置了。
 * @date 2019/6/811:09
 */
import java.util.*;
public class Giant_Chess {
    static int mod=1000000007;
    //缓存n!的值
    static long f[]=new long[200010];
    //缓存n!阶乘的乘法逆元
    static long inv[]=new long[200010];
    //dp表,含义是到达第i个黑点，有几种方法
    static long dp[]=new long[2010];
    //保存黑节点
    static class Node{
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        init(200009);
        while (sc.hasNext()){
            int h=sc.nextInt();
            int w=sc.nextInt();
            int n=sc.nextInt();
            Node list[]=new Node[n+1];
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                list[i]=new Node(x,y);
            }
            list[n]=new Node(h,w);
            //按x轴优先排序
            Arrays.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.x!=o2.x) return o1.x-o2.x;
                    return o1.y-o2.y;
                }
            });

            for (int i=0;i<=n;i++)
            {
                int x1=list[i].x-1;
                int y1=list[i].y-1;
                dp[i] = C(x1,y1) ;
                for(int j = 0 ; j < i ; j++) {
                    if( list[j].x <= list[i].x && list[j].y <= list[i].y ) {
                        int x2 = x1 - list[j].x+1 ; int y2 = y1 - list[j].y+1 ;
                        dp[i] = (dp[i]-C(x2,y2)*dp[j]%mod)%mod ;
                        if( dp[i] <= 0 ) dp[i] = (dp[i]+mod)%mod;
                    }
                }

            }
            System.out.println(dp[n]);
        }
    }

    /**
     * C(m+n,n)=(m+n)!/(m!*n!)
     * @param m
     * @param n
     * @return
     */
    public static long C(int m,int n){
        if(n<0||m<0) return 0;
        long ans=f[n+m]*inv[n]%mod*inv[m]%mod;
        return ans;
    }

    /**
     * 递推公式：https://blog.csdn.net/qq_40861916/article/details/82928080
     * 因为是从后往前的，所以要先用费马小定理算出来最大的
     */
    public  static void init(int N){
        f[0]=1;
        for(int i=1;i<=N;i++)
            f[i]=f[i-1]*i%mod;
        inv[0]=1;
        inv[N]=Fermat(f[N],mod-2);
        for(int i=N-1;i>0;i--)
            inv[i]=inv[i+1]*(i+1)%mod;
    }

    /**
     * 费马小定理：当有两数a,pa,p满足gcd(a,p)=1gcd(a,p)=1时，则有ap≡a(mod p)ap≡a(mod p)。
     * 变一下形：a⋅ap−2≡1(mod p)a⋅ap−2≡1(mod p)。是不是和上面的乘法逆元的定义是相似的？
     * 所以，我们可以使用快速幂求出ap−2ap−2，即求出aa的逆元。
     * @param a 求解的数
     * @param b p-2
     * @return 乘法逆元
     */
    public static  long Fermat(long a,int b){
        long ret=1;
        while (b>0){
            if((b&1)==1){
                ret=ret*a%mod;
            }
            a=a*a%mod;
            b=b>>1;
        }
        return ret;
    }

    static class returnType{
        public int ans;
        public int x;
        public int y;
        public returnType(int ans, int x, int y) {
            this.ans = ans;
            this.x = x;
            this.y = y;
        }
    }

    /**
     *扩展欧几里得算法
     * @param a
     * @param b
     * @return ans为最小公约数，x%mod为其一个逆元，y为另外一个解，可以不关心
     *公式递推：https://blog.csdn.net/alxbaj/article/details/81121447
     */
    public  static returnType extendedEuclidean(int a,int b){
        if(b==0){
            return new returnType(a,1,0);
        }
        returnType type=extendedEuclidean(b,a%b);
        return new returnType(type.ans,type.y,type.x-a/b*type.y);
    }

}
