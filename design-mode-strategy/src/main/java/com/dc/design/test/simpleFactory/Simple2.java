package com.dc.design.test.simpleFactory;

import java.util.Scanner;

/**
 * @author DCZhang
 * @title Simple2
 * @date 2023/7/31 15:17
 * @description TODO
 */
public class Simple2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A：");
        String number1 = scanner.nextLine();
        System.out.println("请输入运算符号（+、-、*、/）：");
        String operatorChar = scanner.nextLine();
        System.out.println("请输入数字B：");
        String number2 = scanner.nextLine();

        String result = operate(number1, operatorChar, number2);
        System.out.println("结果是：" + result);
    }

    public static String operate(String number1, String operatorChar, String number2) {
        String result = "";
        switch (operatorChar) {
            case "+":
                result = String.valueOf(Integer.parseInt(number1) + Integer.parseInt(number2));
                break;
            case "-":
                result = String.valueOf(Integer.parseInt(number1) - Integer.parseInt(number2));
                break;
            case "*":
                result = String.valueOf(Integer.parseInt(number1) * Integer.parseInt(number2));
                break;
            case "/":
                result = String.valueOf(Integer.parseInt(number1) / Integer.parseInt(number2));
                break;
            default:
                System.out.println("请输入正确的运算符号");
                break;
        }
        return result;
    }
}
