package com.alex.d5_list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class MyLinkedList<T> {

    // 链表节点内部类
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // 链表属性
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // 构造函数
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 1. 添加操作

    // 在链表尾部添加元素
    public void add(T data) {
        addLast(data);
    }

    // 在链表尾部添加元素
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // 在链表头部添加元素
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // 在指定索引位置插入元素
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> current = getNode(index);
            Node<T> newNode = new Node<>(data, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    // 2. 删除操作

    // 删除链表头部元素
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list");
        }

        T removedData = head.data;

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return removedData;
    }

    // 删除链表尾部元素
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list");
        }

        T removedData = tail.data;

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return removedData;
    }

    // 删除指定索引位置的元素
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> current = getNode(index);
            T removedData = current.data;

            current.prev.next = current.next;
            current.next.prev = current.prev;

            size--;
            return removedData;
        }
    }

    // 删除第一次出现的指定元素
    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }

        // 处理头部元素
        if (head.data.equals(data)) {
            removeFirst();
            return true;
        }

        // 遍历查找元素
        Node<T> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }

        if (current == null) {
            return false; // 元素不存在
        }

        // 处理尾部元素
        if (current == tail) {
            removeLast();
            return true;
        }

        // 处理中间元素
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
    }

    // 3. 查询操作

    // 获取指定索引位置的元素
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return getNode(index).data;
    }

    // 获取链表头部元素
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    // 获取链表尾部元素
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    // 检查链表是否包含指定元素
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    // 查找元素第一次出现的索引
    public int indexOf(T data) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    // 4. 更新操作

    // 更新指定索引位置的元素
    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> node = getNode(index);
        T oldData = node.data;
        node.data = data;
        return oldData;
    }

    // 5. 工具方法

    // 获取链表大小
    public int size() {
        return size;
    }

    // 检查链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空链表
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // 将链表转换为数组
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    // 将链表转换为字符串表示
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    // 6. 迭代器支持（简单版本）
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // 7. 私有辅助方法

    // 获取指定索引位置的节点
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // 根据索引位置决定从头部还是尾部开始遍历
        Node<T> current;
        if (index < size / 2) {
            // 从头部开始遍历
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // 从尾部开始遍历
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    // 测试示例
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("=== 添加操作测试 ===");
        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(30);
        list.add(2, 15);
        System.out.println("链表内容: " + list);
        System.out.println("链表大小: " + list.size());

        System.out.println("\n=== 查询操作测试 ===");
        System.out.println("索引2的元素: " + list.get(2));
        System.out.println("头部元素: " + list.getFirst());
        System.out.println("尾部元素: " + list.getLast());
        System.out.println("是否包含20: " + list.contains(20));
        System.out.println("元素15的索引: " + list.indexOf(15));

        System.out.println("\n=== 更新操作测试 ===");
        list.set(1, 12);
        System.out.println("更新后链表: " + list);

        System.out.println("\n=== 删除操作测试 ===");
        System.out.println("删除头部: " + list.removeFirst());
        System.out.println("删除尾部: " + list.removeLast());
        System.out.println("删除索引1: " + list.remove(1));
        list.remove(Integer.valueOf(12));
        System.out.println("删除后链表: " + list);

        System.out.println("\n=== 迭代器测试 ===");
        list.add(100);
        list.add(200);
        list.add(300);
        System.out.print("迭代器遍历: ");
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("\n=== 转换为数组 ===");
        Object[] array = list.toArray();
        System.out.print("数组内容: ");
        for (Object item : array) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("\n=== 清空链表 ===");
        list.clear();
        System.out.println("清空后是否为空: " + list.isEmpty());
        System.out.println("清空后大小: " + list.size());
    }
}