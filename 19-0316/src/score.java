/**
 * @author week
 * @Title: score
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/5/910:56
 */
import java.util.*;
public class score {
    static public int N=1000000000;
        static class Node{
            public long a;
            public long b;
            public Node(long at,long bt){
                a=at;
                b=bt;
            }
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int r=sc.nextInt();
            long avg=sc.nextLong();
            long sum=avg*n;//一共需要解决多少分
            long a;
            long b;
            long count=0;
            List<Node> list =new ArrayList<Node>();
            for(int i=0;i<n;i++){
                a=sc.nextLong();
                count+=a;
                b=sc.nextLong();
                list.add(new Node(a,b));
            }
            if(count>=sum) System.out.print(0);

            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.b>=o2.b){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });

            long res=0;
            long target=sum-count;//要搞定这么多分
            for(int i=0;i<list.size();i++){
                Node node=list.get(i);
                long limit=r-node.a;//表示当前有多少分的能力
                if(limit>=target){//表示够了
                    res=(res+target*node.b)%N;
                    break;
                }else{
                    res=(res+limit*node.b)%N;
                    target=target-limit;
                }
            }
            System.out.print((res));
        }



}
