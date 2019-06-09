import java.util.*;
public class Main {
    public static  void build(String s){
        String tmp="";
        boolean has=false;
        int i=0;
        while(i<s.length()){
            System.out.println(i);
            if(tmp.length()<1){
                tmp=tmp+s.charAt(i);
                i++;
            }else {
                if (tmp.charAt(tmp.length() - 1) == s.charAt(i) ) {
                    if(has){
                        has=false;
                    }else {
                        tmp = tmp + s.charAt(i);
                        has=true;
                    }
                    i++;
                    while(i<s.length()&&s.charAt(i)==tmp.charAt(tmp.length() - 1)){
                        i++;
                    }
                }else{
                    tmp=tmp + s.charAt(i);
                    i++;
                }
            }
        }

        System.out.println(tmp);
    }
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            String[] str=new String[n];
            for(int i=0;i<n;i++){
                str[i]=in.next();
            }

            build(str[0]);
        }

}
