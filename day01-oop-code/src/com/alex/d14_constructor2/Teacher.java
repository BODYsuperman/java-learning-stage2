package com.alex.d14_constructor2;

public class Teacher extends  People{

    private  String skill;

    public Teacher() {
    }

    public Teacher(String name, int age, String skill) {
        super(name, age);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        // %s表示字符串占位符，%d表示整数占位符，按顺序匹配后面的属性
        return String.format("Teacher{name='%s', age=%d, skill='%s'}",
                super.getName(),  // 调用父类的getter获取name
                super.getAge(),   // 调用父类的getter获取age
                this.skill);      // 子类自己的skill属性
    }
}
