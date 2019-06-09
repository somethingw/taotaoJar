import java.util.*;

/**
 * @author week
 * @Title: ss3
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/3/1611:02
 */
public class ss3 {
    public static void find(List<Integer> list){


    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            int m=in.nextInt();
            List<Integer> num=new ArrayList<>();
            for(int j=0;j<m;j++){
                num.add(in.nextInt());
            }
            list.add(num);
        }
        System.out.println(list.get(0).get(0));
    }

}
