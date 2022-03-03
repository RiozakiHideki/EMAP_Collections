package Task_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Задан файл с текстом на английском языке. Выделить все различные слова.
// Для каждого слова подсчитать частоту его встречаемости.
// Слова, отличающиеся регистром букв, считать различными.
// Использовать класс HashMap.

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("F:\\Java_proj\\EMAP_Collections\\src\\Task_15\\File1.txt")); //считываем текст из файла File1
        Map<String, Integer> hashMap = new HashMap<>();   //Создаём HashMap (Key - слово, Value - его встречаемость)
        int value = 1;                                    //переменная повторения слова (служит как key в hashMap).

        while (sc.hasNext()){
            String twin = sc.next();                    //String для удобства записи текущего слова
            if (hashMap.containsKey(twin)) {            //Если hashMap уже имеет такой ключ то:
                hashMap.put(twin,hashMap.get(twin)+1);  //Значение этого ключа увеличивается на 1
                continue;
            }
            hashMap.put(twin.replace(",","")        //удаляются лишние символы и заносится в Map
                                 .replace(".","")
                                 .replace("?","")
                                 .replaceAll("\"",""), value);
        }
        sc.close();

        PrintWriter pw = new PrintWriter("F:\\Java_proj\\EMAP_Collections\\src\\Task_15\\File2.txt"); // Файл для записи

        for (String s : hashMap.keySet()){              //Проходимся по каждому ключу
            pw.println(s+" - Встречается "+hashMap.get(s)+" раз"); //Вывод: ключ(слово) + Значение ключа(повторяемость слова)
        }

        pw.close();
    }
}
