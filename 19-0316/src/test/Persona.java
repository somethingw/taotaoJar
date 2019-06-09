package test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Persona {
    private ArrayList<Person> list=new ArrayList<>();//监听对像集合

    private static Persona persona=new Persona();//单例模式提供观察者
    public static Persona getPersona(){
        return persona;
    }
    public void jion(Person p){//监听目标生成
        list.add(p);
        }

    public ArrayList<Person> getList(){//提供高并发下生成的对象队列
        return list;
    }



}
