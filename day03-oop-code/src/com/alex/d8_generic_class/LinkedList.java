package com.alex.d8_generic_class;

/**
 * 泛型链表实现类
 * 与同包下的Node<T>泛型节点类配合使用
 */
public class LinkedList<T> {
    // 链表头节点
    private Node<T> head;
    // 链表长度
    private int length;

    // 无参构造：初始化空链表
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    // 对应C#的 Length => length 表达式体属性：提供getter方法
    public int getLength() {
        return length;
    }

    // 对应C#的 IsEmpty() => (length == 0) 表达式体方法
    public boolean isEmpty() {
        return length == 0;
    }

    // 在链表头部添加新节点
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head); // 替换C#的newNode.Next = head
        head = newNode;
        length++;
    }

    // 在链表尾部添加新节点
    public void addTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> current = head;
        // 遍历到最后一个节点（next为null）
        while (current.getNext() != null) { // 替换C#的current.Next != null
            current = current.getNext();
        }
        current.setNext(newNode); // 尾节点指向新节点
        length++;
    }

    // 刪除链表中所有匹配的节点（原C#的DeleteElemets，修正拼写：Elements）
    public void deleteElements(T data) {
        // 虚拟头节点，避免处理头节点删除的特殊情况
        Node<T> dummyHead = new Node<>(null); // 对应C#的default(T)
        dummyHead.setNext(head);
        Node<T> temp = dummyHead;
        while (temp.getNext() != null) {
            // 匹配节点数据
            if (temp.getNext().getData().equals(data)) { // 替换C#的temp.Next.Data
                temp.setNext(temp.getNext().getNext());
                length--;
            } else {
                temp = temp.getNext();
            }
        }
        // 更新头节点为虚拟头节点的下一个节点
        head = dummyHead.getNext();
    }

    // 删除链表中第一个匹配的节点（原C#的Delete）
    public void delete(T data) {
        if (head == null) {
            return;
        }
        // 特殊情况：头节点就是要删除的节点
        if (head.getData().equals(data)) {
            head = head.getNext();
            length--;
            return;
        }
        Node<T> current = head;
        // 遍历查找待删除节点的前驱节点
        while (current != null && current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                length--;
                return;
            }
            current = current.getNext();
        }
    }

    // 删除头节点
    public void deleteAtHead() {
        if (head == null) {
            return;
        }
        head = head.getNext();
        length--;
    }

    // 查找指定数据，控制台打印结果
    public void find(T data) {
        if (head == null) {
            System.out.println("The Linked List is null, can't find the data");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                System.out.println("Found the data: " + data);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Not Found the data: " + data);
    }

    // 在指定索引位置插入节点（索引从0开始）
    public void insertAt(int index, T data) {
        // 索引非负校验
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be non-negative, current: " + index);
        }
        Node<T> newNode = new Node<>(data);
        // 索引为0，直接调用头部添加方法
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node<T> current = head;
        // 遍历到待插入位置的前驱节点（index-1）
        for (int i = 0; i < index - 1; i++) {
            // 前驱节点为空，说明索引越界
            if (current == null || current.getNext() == null) {
                throw new IndexOutOfBoundsException("Index is out of range, current: " + index + ", list length: " + length);
            }
            current = current.getNext();
        }
        // 插入新节点：先连后，再连前
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        length++;
    }

    // 打印链表所有节点（格式：data->data->null）
    public void print() {
        Node<T> current = head;
        if (current == null) {
            System.out.println("null");
            return;
        }
        // 遍历打印所有节点
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        // 链表尾部标识
        System.out.println("null");
    }
}