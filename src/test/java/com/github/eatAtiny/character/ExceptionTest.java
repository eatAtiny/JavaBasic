package com.github.eatAtiny.character;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 * * ExceptionTest是Java中异常处理的测试类。 * Exception是Java中异常处理的基类，提供了异常的基本功能。 *
 * RuntimeException是Exception的一个子类，表示运行时异常。编译时一般不会出现这种异常。 处理异常一般有两种方式： 一种是使用try-catch语句块来捕获异常并处理它；
 * 另一种是使用throws关键字将异常抛出到调用者。
 */
public class ExceptionTest {

  @Test
  public void RuntimeExceptionDemo() {
    // RuntimeException是一个运行时异常，通常表示程序逻辑错误
    try {
      int result = 10 / 0; // 这将抛出ArithmeticException
    } catch (RuntimeException e) {
      e.printStackTrace();
      System.out.println("捕获到运行时异常: " + e.getMessage());
    }
  }

  @Test
  public void CompileTimeExceptionDemo() {
    // CompileTimeException是编译时异常，通常需要在方法签名中声明
    try {
      ExceptionDemo(); // 调用可能抛出ParseException的方法
      myExceptionDemo(1);
    } catch (ParseException e) {
      e.printStackTrace();
      System.out.println("捕获到编译时异常: " + e.getMessage());
    } catch (MyException e) {
      e.printStackTrace();
    }
  }

  /**
   * ExceptionDemo方法演示了如何处理编译时异常ParseException。 该方法将字符串解析为日期对象，可能会抛出ParseException。
   *
   * @throws ParseException 如果字符串格式不正确，将抛出此异常
   */
  public void ExceptionDemo() throws ParseException {
    System.out.println("ExceptionDemo方法开始执行");

    String str = "2015-06-12 21:51:23";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = sdf.parse(str); // 可能会抛出ParseException
    // 如果出现异常，则程序停止，会处理异常，抛出或者捕获异常
    System.out.println(date);
    System.out.println("ExceptionDemo方法执行结束");
  }

  public int myExceptionDemo(int a) throws MyException {
    System.out.println("myExceptionDemo方法开始执行");
    if (a < 10) {
      throw new MyException("参数不能小于10");
    }
    System.out.println("参数合法: " + a);
    System.out.println("myExceptionDemo方法执行结束");
    return a;
  }
}

class MyException extends Exception {
  public MyException(String message) {
    super(message);
  }
}
