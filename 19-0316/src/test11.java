import java.util.*;
/**
 * @author week
 * @Title: test11
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/4/1119:44
 */
public class test11 {
    public static void find(int n){
        //跳格子
        int count=0;
        while(n!=1){
            if(n%2==0){
                n=(int)n/2;
            }else{
                n=n*3+1;
            }
            count++;
        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        //教技能
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int m=sc.nextInt();
        if(m>=n){
            System.out.println(k);
        }else{
            System.out.println(n*k%m==0?n*k/m:n*k/m+1);
        }

    }
}
