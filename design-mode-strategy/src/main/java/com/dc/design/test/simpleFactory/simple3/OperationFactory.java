package com.dc.design.test.simpleFactory.simple3;

import com.dc.design.test.simpleFactory.simple3.impl.OperationAdd;

class OperationFactory {
        public static Operation createOperation(String operatorChar) {
            Operation operation = null;
            switch (operatorChar) {
                case "+":
                    operation = new OperationAdd();
                    break;
                    // 未实现,如需要自行实现
//                case "-":
//                    operation = new OperationSub();
//                    break;
//                case "*":
//                    operation = new OperationMul();
//                    break;
//                case "/":
//                    operation = new OperationDiv();
//                    break;
                default:
                    System.out.println("请输入正确的运算符号");
                    break;
            }
            return operation;
        }
    }