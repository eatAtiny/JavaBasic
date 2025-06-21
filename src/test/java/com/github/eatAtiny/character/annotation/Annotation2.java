package com.github.eatAtiny.character.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({
  ElementType.LOCAL_VARIABLE,
  ElementType.TYPE,
  ElementType.METHOD,
  ElementType.FIELD
}) // 元注解，指定Annotation2注解可以应用于类、方法等元素
@Retention(RUNTIME) // 元注解，指定Annotation2注解在运行时可用
public @interface Annotation2 {
  String name() default "default name"; // 默认值为"default name"

  int age() default 18; // 默认值为18

  String[] hobbies() default {"reading", "coding"}; // 默认值为{"reading", "coding"}

  Class<?> type() default Object.class; // 默认值为Object类
}
