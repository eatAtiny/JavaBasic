package test.api;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public void FileOperationDemo() {
        // File类的常用方法
        File file = new File("example.txt"); // 创建一个File对象，表示一个文件

        // 检查文件是否存在
        if (file.exists()) {
            System.out.println("文件已存在");
        } else {
            System.out.println("文件不存在");
        }

        // 检查文件是否是一个目录
        if (file.isDirectory()) {
            System.out.println("这是一个目录");
        } else if (file.isFile()) {
            System.out.println("这是一个文件");
        } else {
            System.out.println("这不是一个文件或目录");
        }

        // 创建新文件
        try {
            if (file.createNewFile()) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件已存在，无法创建");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        // 操作文件
        // 获取文件的绝对路径
        System.out.println("文件的绝对路径: " + file.getAbsolutePath());
        // 获取文件的名称
        System.out.println("文件名: " + file.getName());
        // 获取文件的大小（字节数）
        System.out.println("文件大小: " + file.length() + " 字节");
        // 检查文件是否是一个目录


        // 删除文件
        if (file.delete()) {
            System.out.println("文件删除成功");
        } else {
            System.out.println("文件删除失败或文件不存在");
        }

        // 创建一个目录
        File dir = new File("exampleDir");
        if (dir.mkdir()) {
            System.out.println("目录创建成功");
        } else {
            System.out.println("目录已存在或创建失败");
        }
        // 列出目录中的文件和子目录
        File[] files = dir.listFiles(); // 获取目录中的所有文件和子目录，指定的目录必须存在，而且必须是目录，不能是文件
        if (files != null) {
            System.out.println("目录中的文件和子目录:");
            for (File f : files) {
                System.out.println(f.getName() + (f.isDirectory() ? " [目录]" : " [文件]"));
            }
        } else {
            System.out.println("目录为空或无法访问");
        }
    }

    @Test
    public void FileDemo() {
        // File类是Java中用于处理文件和目录的类，提供了对文件系统的访问和操作。
        // File类位于java.io包中，可以用于创建、删除、重命名文件和目录，获取文件属性等。

        // 创建一个File对象，表示当前目录
        File file = new File("."); // "."表示当前目录
        // 模拟一个终端
        while (true) {
            // 初始输出当前目录
            System.out.print(file.getAbsolutePath() + "> "); // 输出当前目录的绝对路径
            String input = System.console().readLine(); // 读取用户输入的命令
            if (input == null || input.trim().isEmpty()) {
                continue; // 如果输入为空，继续下一次循环
            }
            String[] command = input.split(" "); // 将输入的命令按空格分割
            switch (command[0].toLowerCase()) {
                case "ls": // 列出file目录内容
                    File[] files = file.listFiles(); // 获取当前目录下的所有文件和目录
                    if (files != null) {
                        for (File f : files) {
                            System.out.println(f.getName() + (f.isDirectory() ? " [目录]" : " [文件]"));
                        }
                    } else {
                        System.out.println("无法列出目录内容");
                    }
                    break;

                case "cd": // 切换目录
                    if (command[1].equalsIgnoreCase("..")) {
                        // 切换到上级目录
                        File parentFile = file.getParentFile();
                        if (parentFile == null) {
                            System.out.println("已经在根目录，无法再上一级");
                        } else {
                            file = parentFile; // 更新当前目录为上级目录
                        }
                    } else if (!command[1].isEmpty()) {
                        // 进入指定子目录
                        File[] files1 = file.listFiles();
                        if (files1 != null) {
                            boolean found = false;
                            for (File f : files1) {
                                if (f.isDirectory() && f.getName().equals(command[1])) {
                                    file = f; // 更新当前目录
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("没有找到指定的目录: " + command[1]);
                            }
                        }
                    } else {
                        // 切换到指定目录
                        File newDir = new File(file, command[1]);
                        if (newDir.isDirectory()) {
                            file = newDir; // 更新当前目录
                        } else {
                            System.out.println("指定的路径不是一个目录: " + command[1]);
                        }
                    }
                    break;

                case "touch": // 创建新文件
                    if (command.length < 2) {
                        System.out.println("请指定要创建的文件名");
                        break;
                    }
                    File newFile = new File(command[1]);
                    try {
                        if (newFile.createNewFile()) {
                            System.out.println("文件创建成功: " + newFile.getName());
                        } else {
                            System.out.println("文件已存在: " + newFile.getName());
                        }
                    } catch (IOException e) {
                        System.out.println("无法创建文件: " + e.getMessage());
                    }
                    break;

                case "exit": // 退出终端
                    return;

                default:
                    System.out.println("未知命令: " + command[0]);
                    System.out.println("可用命令: ls, cd <目录>, touch <文件名>, exit");
            }

        }
    }
}
