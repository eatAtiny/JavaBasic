package test.character;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void streamDemo() {
        // Stream是Java 8引入的一个新特性，用于处理集合数据，流的处理主要有三个步骤：创建流、操作流、终止流。

        // 创建一个字符串列表
        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "orange", "apple"));

        // 创建流的方式
        Stream<String> stream = list.stream();
        // 或者使用静态方法创建流
        Stream<String> stream2 = Stream.of("apple", "banana", "orange", "apple");


        // 操作流：使用流的中间操作来处理数据
        // 实际上，流的中间操作接口中会调用集合中的方法来处理数据
        // 比如说distinct()方法会调用集合的去重方法，filter()方法会调用集合的过滤方法等
        // 常见的中间操作包括filter、map、sorted等
        Stream<String> filteredStream = stream.filter(s -> !s.equals("apple")); // 过滤掉"apple"
        Stream<String> mappedStream = filteredStream.map(String::toUpperCase); // 将剩余的字符串转换为大写 这种写法相当于map(s -> s.toUpperCase())
        Stream<String> sortedStream = mappedStream.sorted(); // 对结果进行排序 sorted()方法默认是升序排序 如果需要自定义排序，可以传入一个Comparator对象
        Stream<String> distinctStream = sortedStream.distinct(); // 去重，去掉重复的元素
        Stream<String> stream3 = distinctStream.peek(System.out::println); // 使用peek方法打印每个元素，peek是一个中间操作，不会终止流
        // 以上操作不会立即执行，流的处理是惰性求值的，只有在终止操作时才会执行。
        // 注意：流一旦被终止，就不能再使用了，必须重新创建流。
        // 例如，下面的代码会抛出IllegalStateException，因为stream已经被终止了
        // 过程流在被终止后不能再使用

        // 终止流：使用终止操作来获取结果，一个流只能被终止一次，终止操作会触发流的处理并返回结果。
        // 常见的终止操作包括forEach、collect、count等
        long count = stream3.count(); // 计算流中元素的数量
        System.out.println("元素数量: " + count); // 输出元素数量
        // 使用forEach打印每个元素
//        sortedStream.forEach(System.out::println); // 输出剩余的元素
        // 使用collect将流转换为列表
//        ArrayList<String> resultList = sortedStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // 这种写法相当于collect(Collectors.toList());
    }

}
