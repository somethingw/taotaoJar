package com.week;

/**
 * @author week
 * @Title: queueTest
 * @ProjectName 19-0316
 * @Description: 简单的队列实现
 * @date 2019/5/3120:37
 */
public class queueTest <T>{
    public class queueNode{
        public T val;
        public queueNode next;
        public queueNode(T value){
            this.val=value;
        }
    }
    public queueNode head;
    public queueNode end;
    public int size=0;

    public void push(T t){
        queueNode node=new queueNode(t);
        if(size<=0){
            head=end=node;
        }else{
            end.next=node;
            end=node;
        }
        size++;
    }

    //一般没有删除，你写个pop就行了，就是返回一个，并在队列里删除
    public T pop(){
        return null;
    }

    //这个简单，返回，不用删除
    public T peek(){
        return null;
    }

}
