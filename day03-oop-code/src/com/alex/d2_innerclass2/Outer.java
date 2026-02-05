package com.alex.d2_innerclass2;

public class Outer {

    private static  String schoolName = "MIT";
    public  static  void inAddr(){
        System.out.println("I'm here at MIT");
    }


    private  String height;

    public static class Inner{
        public Inner() {
        }
        private String name;
        private  int age;


        public  void show(){
            System.out.println(schoolName);
            inAddr();
            System.out.println(name);

            //System.out.println(height);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
