package com.dc.design.test.simpleFactory.simple3;

import java.util.Scanner;

/**
 * @author DCZhang
 * @title Simple3
 * @date 2023/7/31 15:20
 * @description 简单工厂,将运算符号和运算逻辑分离,使用工厂模式,对操作类进行封装继承
 * 新增需求时,只需要新增一个类,修改原有的工厂类即可
 */
public class Simple3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A：");
        String number1 = scanner.nextLine();
        System.out.println("请输入运算符号（+、-、*、/）：");
        String operatorChar = scanner.nextLine();
        System.out.println("请输入数字B：");
        String number2 = scanner.nextLine();

        Operation operation = OperationFactory.createOperation(operatorChar);
        double result = operation.getResult(Double.parseDouble(number1), Double.parseDouble(number2));
        System.out.println("结果是：" + result);
    }

}
