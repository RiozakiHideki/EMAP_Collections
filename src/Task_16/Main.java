package Task_16;

import java.util.HashMap;
import java.util.Map;

/* Заполнить HashMap 10 объектами <Integer, String>.
   Найти строки у которых ключ>5.
   Если ключ = 0, вывести строки через запятую.
   Перемножить все ключи, где длина строки>5
.*/

public class Main {
    public static void main(String[] args) {
        Map<Integer,String> hashMap = new HashMap<>();
        String ifZero = ""; //записываются значения, если есть ключ=0
        String ifBiggerThen5 = ""; //записываются значения, если ключ>5
        int keyMultiplicator = 1; //перемножение ключей, если длинна строки>5
        hashMap.put(0,"Ноль");
        hashMap.put(1,"Один");
        hashMap.put(2,"Два");
        hashMap.put(3,"Три");
        hashMap.put(4,"Четыре");
        hashMap.put(5,"Пять");
        hashMap.put(6,"Шесь");
        hashMap.put(7,"Семь");
        hashMap.put(8,"Восемь");
        hashMap.put(9,"Девять");

        for (int i : hashMap.keySet()){
            if (i>5) ifBiggerThen5+=hashMap.get(i)+" ";
            if (hashMap.containsKey(0)) ifZero+=hashMap.get(i)+" "; //Если ключ = 0 - строки выводятся через запятую
            if (hashMap.get(i).length()>5) keyMultiplicator *= i;
        }

        System.out.println("Строки у которых ключ>5: "+ ifBiggerThen5);
        if (hashMap.containsKey(0))
            System.out.println("Если ключ=0, вывести строки через запятую: "+ ifZero);
        System.out.println("Перемножить все ключи, где длинна строки>5: " + keyMultiplicator);
    }
}
