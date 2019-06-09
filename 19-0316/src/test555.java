/**
 * @author week
 * @Title: test555
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/4/1320:11
 */
import java.util.*;
public class test555 {
    static int Count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(y==1){
                count++;
            }
            if(count<=list.size()){
                int num=list.get(list.size()-1);
                list.set(list.size()-1,num+1);
            }else{
                list.add(1);
            }
        }
        Collections.sort(list);
        find(list);
        System.out.println(Count);
    }
    public static void find(List<Integer> list){
        if(list.size()<=2){
            Count=Count+list.get(list.size()-1);
            return;
        }
        int num_0=list.get(0);
        Count=Count+num_0;
        int num_1=list.get(1);
        list.set(1,num_1-num_0);
        list.remove(0);
        find(list);
        return;

    }
}
