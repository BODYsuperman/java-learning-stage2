package com.alex.d8_generic_class;

// 泛型节点类，T为数据类型占位符
public class Node<T> {
    // 成员变量私有（Java编码规范），驼峰命名修正（c#的Data→java的data）
    private T data;
    private Node<T> next;

    // 构造方法：初始化数据，next默认置null
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // 生成get/set方法（对应C#的{ get; set; }）
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}