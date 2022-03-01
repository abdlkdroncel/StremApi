package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        List<Employee> e=new  ArrayList<>();
        e.add(new Employee(1,"name1"));
        e.add(new Employee(2,"name2"));
        e.add(new Employee(3,"name3"));
        e.add(new Employee(4,"name4"));
        e.add(new Employee(5,"name5"));

        //her bir employee nesnesini 1.elemandan başlayarak fonksiyonu calistir.
        e.stream().forEach(parameter->{
                    parameter.talk();
                }
                );
        //Yukarıdaki işlem ile aynı
        System.out.println("--------");
        e.stream().forEach(Employee::talk);

        List<Employee> filterList=e.stream().filter(parameter->parameter.id>2).collect(Collectors.toList());

        System.out.println("Filtered List");
        filterList.stream().forEach(Employee::talk);

        //yeni veri elde etme
        System.out.println("Map List");
        List<Employee> newList=e.stream().map(parameter->new Employee(parameter.id+10, parameter.name)).collect(Collectors.toList());
        newList.stream().forEach(parameter->{
                    System.out.println(parameter.toString());
                }
        );

        Map<Integer,String> mapedList=e.stream().collect(Collectors.toMap(x->x.id,x->x.name));
        mapedList.forEach((k,v)->System.out.println(k+" --"+v));
    }


}
class Employee {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void talk() {
        System.out.println("talk" + this.name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
