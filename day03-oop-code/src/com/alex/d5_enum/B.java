package com.alex.d5_enum;

//Singleton Best practice
/*

An enum is essentially a final class that inherits from java.lang.Enum, so it cannot be inherited (preventing subclasses from creating new instances).
✅ Globally unique: RED is a public static final constant, initialized when the class is loaded; only one instance exists globally.
✅ Cannot be instantiated manually: The constructor is private, so the outside world cannot create instances via new Color().
✅ Thread-safe: Class loading is guaranteed to be thread-safe by the JVM (the JVM’s class loading mechanism uses parent delegation + synchronized loading, so static constants will not be initialized multiple times under multithreading).
✅ Cannot be extended: Enums are compiled as final classes, so subclasses cannot extend them, preventing new instances from being created through inheritance.
 */
public enum B {
    X;
    private  String name;
    private  int age;

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
