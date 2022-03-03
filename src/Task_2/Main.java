package Task_2;

// Ввести число, занести его цифры в стек.
// Вывести число, у которого цифры идут в обратном порядке.

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String numStr = String.valueOf(num);
        numStr = numStr.replaceAll(""," "); //Вставляем пробелы между цифр
        numStr = numStr.substring(1,numStr.length()-1); // удаляем лишние пробелы вначале и конце

        Stack<Integer>stack = new Stack(); //Создаём стек

        for (int i=0;i<numStr.length();i+=2){
            stack.push(Integer.parseInt(String.valueOf(numStr.charAt(i)))); // Получаем i-й символ строки
                                                                            // Переводим его в String
                                                                            // Переводим String в Integer
                                                                            // i+=2 чтобы миновать пробелы
        }
        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
