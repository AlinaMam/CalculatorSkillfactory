package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Calculator {
    private  static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public static void main(String[] args) {
        int exit = 1;
        while (exit != 0) {
            int num1;
            int num2;
            try {
                logger.info("Введите число1: ");
                num1 = scanner.nextInt();
                logger.info("Введено число1: " + num1);
                logger.info("Выберите операцию: " +
                        "1. + " +
                        "2. - " +
                        "3. * " +
                        "4. / ");
                String line = scanner.next();
                logger.info("Введена операция: " + line);
                logger.info("Введите число2: ");
                num2 = scanner.nextInt();
                logger.info("Введено число2: " + num1);
                if (num2 == 0 && line.equals("/")) {
                    logger.info("На 0 делить нельзя");
                    logger.error("Деление на 0");
                    break;
                }
                getResult(num1, num2, line, scanner);
                logger.info("Если хочешь продолжить введи 1. Для выхода введи 0: ");
                exit = scanner.nextInt();
            } catch (Exception e) {
                logger.error("Пользователь ввел некорректное число");
                break;
            }
        }
    }

    public static void getResult(int num1, int num2, String line, Scanner scanner) {
        double result = 0.0;
        switch (line) {
            case "+":
                logger.info(num1 + " + " + num2 + " = " + (result = sum(num1, num2)));
//                log.info("Прошла операция сложения: " + num1 + " + " + num2 + " = " + (result = sum(num1, num2)));
                break;
            case "-":
                logger.info(num1 + " - " + num2 + " = " + (result = sub(num1, num2)));
//                log.info("Прошла операция вычитания: " + num1 + " - " + num2 + " = " + (result = sub(num1, num2)));
                break;
            case "*":
                logger.info(num1 + " * " + num2 + " = " + (result = mul(num1, num2)));
//                log.info("Прошла операция умножения: " + num1 + " * " + num2 + " = " + (result = mul(num1, num2)));
                break;
            case "/":
                logger.info(num1 + " / " + num2 + " = " + (result = div(num1, num2)));
//                log.info("Прошла операция деления: " + num1 + " / " + num2 + " = " + (result = div(num1, num2)));
                break;
            default:
                logger.error("Операция некорретна. Попробуйте сначала!");
                break;
        }
    }

    public static int sum(int num1, int num2) {
        return (num1 + num2);
    }

    public static int sub(int num1, int num2) {
        return (num1 - num2);
    }

    public static int mul(int num1, int num2) {
        return (num1 * num2);
    }

    public static int div(int num1, int num2) {
        return (num1 / num2);
    }
    }
