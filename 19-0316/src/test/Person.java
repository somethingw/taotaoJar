package test;

public class Person {
    private String name;
    private int age;
    public Person (){
        Persona persona = Persona.getPersona();
        persona.jion(this);
        }
    public Person (String name,int age){
        this.name=name;
        this.age=age;
        Persona persona = Persona.getPersona();
        persona.jion(this);
    }
    public void remove(){

    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
