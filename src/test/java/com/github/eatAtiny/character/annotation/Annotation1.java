package com.github.eatAtiny.character.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/** 在定义注解时可以使用元注解 */
@Retention(RUNTIME) // 元注解，指定Annotation1注解在运行时可用  一般有三种保留策略：
// SOURCE：注解只在源代码中存在，编译后会被丢弃
// CLASS：注解在编译时存在，但在运行时不可用
// RUNTIME：注解在运行时可用，可以通过反射获取
@Target({ElementType.TYPE, ElementType.METHOD}) // 元注解，指定Annotation1注解可以应用于类、方法等元素
public @interface Annotation1 {
  // 当属性中只有一个value时，属性名可以不写
  String value() default "default value"; // 默认值为"default value"
}
