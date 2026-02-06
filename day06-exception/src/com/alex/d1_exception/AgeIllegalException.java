package com.alex.d1_exception;

import java.lang.Exception;

public class AgeIllegalException extends Exception {
    public AgeIllegalException() {
        super(); // 正确：第一行调用父类无参构造器（可省略，编译器自动补）
        // 其他代码写在super()之后
        // System.out.println("自定义异常");
    }

    public AgeIllegalException(String message) {
        super(message); // 正确：第一行调用父类有参构造器（必须手动写）
        // 其他代码写在后面
        // String msg = "年龄异常：" + message;
    }
}
