package test.api;


import org.junit.Test;

/**
 * Dequeues是Java中常用的数据结构之一，提供了双端队列的功能。
 * Queue是Dequeues的一个实现，提供了队列的功能。Deque是Dequeues的另一个实现，提供了双端队列的功能。
 * stack是Dequeues的一个特殊实现，提供了栈的功能。
 */
public class QueueTest {

    @Test
    public void queueDemo() {
        // Queue是一个先进先出（FIFO）的数据结构
        java.util.Queue<String> queue = new java.util.LinkedList<>();

        // 添加元素到队列
        queue.offer("apple");
        queue.offer("banana");
        queue.offer("orange");

        // 获取队列头部元素但不移除它
        String head = queue.peek();
        System.out.println("队列头部元素: " + head); // 输出 "apple"

        // 移除并获取队列头部元素
        String removed = queue.poll();
        System.out.println("移除的元素: " + removed); // 输出 "apple"

        // 遍历队列中的元素
        for (String item : queue) {
            System.out.println(item);
        }

        // 检查队列是否为空
        boolean isEmpty = queue.isEmpty();
        System.out.println("队列是否为空: " + isEmpty);
    }

    @Test
    public void dequeDemo() {
        // Deque是一个双端队列，可以在两端添加和移除元素
        java.util.Deque<String> deque = new java.util.ArrayDeque<>();

        // 在队列头部添加元素
        deque.offerFirst("apple");
        deque.offerFirst("banana");

        // 在队列尾部添加元素
        deque.offerLast("orange");

        // 获取并移除队列头部元素
        String head = deque.pollFirst();
        System.out.println("移除的头部元素: " + head); // 输出 "banana"

        // 获取并移除队列尾部元素
        String tail = deque.pollLast();
        System.out.println("移除的尾部元素: " + tail); // 输出 "orange"

        // 遍历双端队列中的元素
        for (String item : deque) {
            System.out.println(item);
        }

        // 检查双端队列是否为空
        boolean isEmpty = deque.isEmpty();
        System.out.println("双端队列是否为空: " + isEmpty);
    }

    @Test
    public void stackDemo() {
        // Stack是一个后进先出（LIFO）的数据结构
        java.util.Stack<String> stack = new java.util.Stack<>();

        // 压入元素到栈中
        stack.push("apple");
        stack.push("banana");
        stack.push("orange");

        // 获取栈顶元素但不移除它
        String top = stack.peek();
        System.out.println("栈顶元素: " + top); // 输出 "orange"

        // 弹出并获取栈顶元素
        String popped = stack.pop();
        System.out.println("弹出的元素: " + popped); // 输出 "orange"

        // 遍历栈中的元素
        for (String item : stack) {
            System.out.println(item);
        }

        // 检查栈是否为空
        boolean isEmpty = stack.isEmpty();
        System.out.println("栈是否为空: " + isEmpty);
    }
}
