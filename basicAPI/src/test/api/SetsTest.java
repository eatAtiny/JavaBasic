package test.api;


import org.junit.Test;

/**
 * * Sets是Java中常用的数据结构之一，提供了集合的功能。
 * HashSet是Sets的一个实现，提供了基于哈希表的集合功能。TreeSet是Sets的另一个实现，提供了基于红黑树的集合功能。
 */
public class SetsTest {

    @Test
    public void hashSetDemo() {
        // HashSet是一个无序的集合，元素不重复
        java.util.HashSet<String> set = new java.util.HashSet<>();

        // 添加元素
        set.add("apple");
        set.add("banana");
        set.add("orange");

        // 尝试添加重复元素
        boolean added = set.add("apple"); // 返回false，因为"apple"已存在
        System.out.println("添加重复元素结果: " + added);

        // 遍历元素
        for (String item : set) {
            System.out.println(item);
        }

        // 检查是否包含某个元素
        boolean containsBanana = set.contains("banana");
        System.out.println("集合中是否包含banana: " + containsBanana);

        // 获取集合大小
        System.out.println("集合大小: " + set.size());
    }

    @Test
    public void treeSetDemo() {
        // TreeSet是一个有序的集合，元素不重复
        java.util.TreeSet<String> treeSet = new java.util.TreeSet<>();

        // 添加元素
        treeSet.add("apple");
        treeSet.add("banana");
        treeSet.add("orange");

        // 尝试添加重复元素
        boolean added = treeSet.add("apple"); // 返回false，因为"apple"已存在
        System.out.println("添加重复元素结果: " + added);

        // 遍历元素
        for (String item : treeSet) {
            System.out.println(item);
        }

        // 检查是否包含某个元素
        boolean containsBanana = treeSet.contains("banana");
        System.out.println("集合中是否包含banana: " + containsBanana);

        // 获取集合大小
        System.out.println("集合大小: " + treeSet.size());
    }
}
