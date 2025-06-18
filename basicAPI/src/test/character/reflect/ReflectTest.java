package test.character.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest {

    /**
     * 反射机制的使用示例：
     * 1. 获取类的Class对象
     * 2. 创建类的实例
     * 3. 获取类的方法、字段等信息
     * 4. 调用方法或访问字段
     */
    @Test
    public void reflectDemo1() throws Exception {
        // Class是反射的入口
        // 有三种方式获取Class对象：
        // 1. 使用类名.class
        Class reflectClass = ReflectClass.class;
        // 2. 使用Class.forName("类的全限定名")
        Class reflectClassForName = Class.forName("test.character.reflect.ReflectClass");
        // 3. 使用对象.getClass()
        ReflectClass reflectClassInstance = new ReflectClass();
        Class reflectClassInstanceType = reflectClassInstance.getClass();

        System.out.println(reflectClass == reflectClassForName); // true
        System.out.println(reflectClass == reflectClassInstanceType); // true，说明三种方式获取的Class对象是同一个

    }

    @Test
    public void reflectDemo2() throws Exception {
        // 获取类信息
        // 1. 获取类对象
        // 2. 获取类的构造方法、方法、字段等信息
        Class reflectClass = ReflectClass.class;
        // 获取类构造器
        Constructor[] constructors = reflectClass.getConstructors(); // 获取所有公共构造方法
        for (Constructor constructor : constructors) {
            System.out.println("Constructor: " + constructor);
        }
        Constructor[] declaredConstructors = reflectClass.getDeclaredConstructors(); // 获取所有构造方法，包括私有的
        for (Constructor constructor : declaredConstructors) {
            System.out.println("Declared Constructor: " + constructor);
        }
        Constructor reflectConstructor = reflectClass.getDeclaredConstructor(int.class, String.class); // 获取指定参数类型的构造方法
        System.out.println("Specific Constructor: " + reflectConstructor);

        // 使用构造器
        // 暴力反射，即使用setAccessible(true)来访问私有构造方法
        reflectConstructor.setAccessible(true);
        ReflectClass reflectInstance = (ReflectClass) reflectConstructor.newInstance(1, "Test Name"); // 创建类的实例
        System.out.println(reflectInstance.toString());

        // 获取类的属性
        Field[] fields = reflectClass.getFields(); // 获取所有公共字段
        for (Field field : fields) {
            System.out.println("Field: " + field);
        }
        Field[] declaredFields = reflectClass.getDeclaredFields(); // 获取所有字段，包括私有的
        for (Field field : declaredFields) {
            System.out.println("Declared Field: " + field);
        }
        Field reflectField = reflectClass.getDeclaredField("name"); // 获取指定名称的公共字段
        System.out.println("Specific Field: " + reflectField);
        // 使用字段
        ReflectClass reflectClass1 = new ReflectClass(); // 创建类的实例
        reflectField.setAccessible(true); // 允许访问私有字段
        reflectField.set(reflectClass1, "name111"); // reflectField是ReflectClass类的name字段，此处将其设置为name111
        System.out.println(reflectClass1);

        // 获取类的方法
        Method[] methods = reflectClass.getMethods(); // 获取所有公共方法
        for (Method method : methods) {
            System.out.println("Method: " + method);
        }
        Method[] declaredMethods = reflectClass.getDeclaredMethods(); // 获取所有方法，包括私有的
        for (Method method : declaredMethods) {
            System.out.println("Declared Method: " + method);
        }
        Method reflectMethod = reflectClass.getDeclaredMethod("setName", String.class); // 获取指定名称和参数类型的公共方法
        System.out.println("Specific Method: " + reflectMethod);

        // 使用方法
        ReflectClass reflectClass2 = new ReflectClass(); // 创建类的实例
        reflectMethod.setAccessible(true); // 允许访问私有方法
        reflectMethod.invoke(reflectClass2, "New Name"); // 调用方法，传入参数
        System.out.println(reflectClass2); // 输出调用方法后的结果
    }

    @Test
    public void reflectDemo3() throws Exception {
        /**
         * 反射的作用：
         * 1.获取类的所有成分
         * 2.破坏封装，访问私有成员
         * 3.绕过泛型约束
         */

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        // 通过反射获取ArrayList的class对象
        Class arrayListClass = list.getClass();
        // 获取ArrayList的add方法
        Method add = arrayListClass.getDeclaredMethod("add", Object.class);
        add.invoke(list, 123); // 通过反射调用add方法，传入一个整数
        System.out.println(list); // 输出结果：[Hello, World, 123]

    }
}
