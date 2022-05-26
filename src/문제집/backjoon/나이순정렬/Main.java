package 문제집.backjoon.나이순정렬;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N;

    static class Person{
        int age;
        String name;
        int index;

        public Person(int age, String name,int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/나이순정렬/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int age1 = o1.age;
                int age2 = o2.age;

                if(age1 == age2){
                    return Integer.compare(o1.index,o2.index);
                }else{
                    return Integer.compare(age1,age2);
                }
            }
        };

        List<Person> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            String[] s1 = s.split(" ");

            int age = Integer.parseInt(s1[0]);
            String name = s1[1];
            int index = i;

            int[] a = new int[2];
            a[0] = 1;
            a[1] = 2;

            int[] b = new int[]{1,2};

            Person p = new Person(age,name,index);
            list.add(p);
        }

        list.sort(comp);

        for(Person p : list){
            System.out.println(p.age + " " + p.name);
        }
    }
}
