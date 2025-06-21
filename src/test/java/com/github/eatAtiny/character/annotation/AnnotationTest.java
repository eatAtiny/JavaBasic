package com.github.eatAtiny.character.annotation;

import org.junit.jupiter.api.Test;

@Annotation1("Annotation Test") // 使用Annotation1注解来描述类AnnotationTest
public class AnnotationTest {

  // 使用注解相当于实例化抽象注解
  @Annotation2(
      name = "Annotation Test",
      age = 25,
      hobbies = {"coding", "testing"},
      type = AnnotationTest.class)
  private String annotationField = "This is a field with Annotation2";

  @Test
  public void annotationDemo() throws NoSuchFieldException {
    /** 局部变量的注解不会在运行时保留，无法通过反射获取 将注解引用到类的字段上，并通过反射获取注解信息 */

    // 通过反射获得name上的注解Annotation2的信息
    Annotation2 annotation =
        this.getClass().getDeclaredField("annotationField").getAnnotation(Annotation2.class);
    if (annotation != null) {
      System.out.println("Name: " + annotation.name()); // 打印注解中的name属性值
      System.out.println("Age: " + annotation.age()); // 打印注解中的age属性值
      System.out.print("Hobbies: ");
      for (String hobby : annotation.hobbies()) {
        System.out.print(hobby + " "); // 打印注解中的hobbies属性值
      }
      System.out.println();
      System.out.println("Type: " + annotation.type().getSimpleName()); // 打印注解中的type属性值
    } else {
      System.out.println("No Annotation2 found on name variable.");
    }
  }
}
