package com.week.class_03;

import javafx.scene.transform.Scale;

import java.util.*;

/**
 * @author week
 * @Title: num_count_tmp
 * @ProjectName 19-0316
 * @Description: 中序转后续的规则如下：
 * 1.数字直接输出。
 * 2.左括号直接压栈。
 * 3.运算符进行优先级判定，优先级高则压栈，优先级低则触发出栈，直到遇到一个左括号（只有右括号能让它出栈）或者一个比它优先级低的停止。
 * 4.右括号触发出栈，直到遇到一个左括号结束（左括号也得出栈，而且只有右括号才可以让它出栈）
 * 4.出栈的过程中，只输出运算符。
 * @date 2019/5/3010:52
 */
public class num_count_tmp {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            List<Object> list=IN_TO_POST(str);
            Stack<Integer> stack=new Stack<>();
            Iterator<Object> it= list.iterator();
            while(it.hasNext()) {
                Object temp = it.next();
                if (temp instanceof Integer){
                    stack.push((Integer) temp);
                }else{
                    int b=stack.pop();
                    int a=stack.pop();
                    int res=operation(a,b,(char)temp);
                    stack.push(res);
                }
            }
            System.out.println(stack.pop());
        }
    }
    //辅助函数，运算
    private static  int operation(int a,int b,char c){
        if(c=='*') return a*b;
        if(c=='/') return  a/b;
        if(c=='+') return  a+b;
        if(c=='-') return  a-b;
        return  0;
    }

    //将中序字符串转为后序
    private static List<Object> IN_TO_POST(String str){
        List<Object> list=new ArrayList<>();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            String T="";
            while (i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                T=T+str.charAt(i++);
            }
            if(!T.equals("")){//是数字直接输出
                list.add(Integer.valueOf(T));
                --i;//注意回退
            }else{//不是数字，则进行判定操作
                if(str.charAt(i)=='('){//左括号直接压栈
                    stack.push(str.charAt(i));
                }else if(str.charAt(i)==')'){//右括号弹出栈内元素，直至遇到一个左括号
                    while(stack.peek()!='('){
                        list.add(stack.pop());
                    }
                    stack.pop();
                }else{//符号的情况
                    if(stack.isEmpty()||prior(str.charAt(i),stack.peek())){//如果栈为空,或者当前优先级高，直接压栈
                        stack.push(str.charAt(i));
                    }else{//优先级低，触发出栈
                        //三个条件同时满足，则弹出，1.栈不为空，2.栈顶不能是左括号，因为只有右括号有权利将左括号弹出。3.当前元素的优先级小于栈顶元素
                        while(!stack.isEmpty()&&stack.peek()!='('&&!prior(str.charAt(i),stack.peek())){
                            list.add(stack.pop());
                        }
                        //再把当前符号进栈
                        stack.push(str.charAt(i));
                    }
                }
            }
        }
        //当前面的循环进行完的时候，栈里可能还有符号，要将其拿过来，是满足后序的定义的
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    //辅助函数，判定两个字符的优先级,优先级高则进栈
    private static boolean prior(char now,char peek){
        //只有两种情况表示优先级高可以入栈，其余情况都不可以
        if(peek=='(') return true;
        if((now=='*'||now=='/')&&(peek=='+'||peek=='-')) return true;
        return false;
    }
}
