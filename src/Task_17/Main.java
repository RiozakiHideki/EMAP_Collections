package Task_17;

//создаём лист и делаем два указателя: начало - конец
//вводим символ, который нужно найти
//выводим строки, которые начинается с этого символа
// выводим диапазон листа, в котором состоят эти строки с начальным символом

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("F:\\Java_proj\\EMAP_Collections\\src\\Task_17\\File1.txt"));
        Scanner in = new Scanner(System.in);
        List<String> arrayList = new ArrayList<>();
        while (sc.hasNext()) {                          //заполняем лист словами из файла
            arrayList.add(sc.next());
        }
        sc.close();

        Collections.sort(arrayList);                   //Сортируем список по заданию (хз зачем, но раз сказано... Или я что-то не так понял)
        System.out.println("Текущий список: " + "\n" + arrayList);
        System.out.println("Введите индекс, с которого необходимо начать поиск(начальный индекс = 0): ");
        int StartFrom = in.nextInt();
        System.out.println("Введите конечный индекс поиска (включительно) (конечный индекс текущего листа ="+(arrayList.size()-1)+")");
        int StopAt = in.nextInt();
        sc.close();
        System.out.println(getResult((ArrayList) arrayList,StartFrom,StopAt));

    }

    public static String getResult(ArrayList arrayList,int StartFrom,int StopAt) {

        int start = 0; // Индекс начала диапазона листа, в котором наш символ будет первый в слове
        int end = arrayList.size()-1; //конечный индекс
        boolean findStart = true; //установит начальный индекс и перейдёт в false
        String result = ""; // храним строки, которые начинаются с заданного символа

        System.out.println("Введите символ для поиска по листу");
        char findStringCh = new Scanner(System.in).next().charAt(0); //вводим символ для поиска

       for (int i=StartFrom;i<=StopAt;i++){                              //Запускаем цикл с заданным диапазоном
           if (arrayList.get(i).toString().charAt(0) == findStringCh){       //Если слово начинается с нужного символа
               if (findStart){                                      //Если цикл запустился
                   start = i;                                       //то старт определён
                   findStart = false;                               //больше эта проверка не сработает
               }
               result+=arrayList.get(i)+" ";                      //Добавляем слово, которое начинается с символа
               end = i;                   //Последний отработанный раз - это конец диапазона
           }
       }
        return "Начало диапазона: "+ start+"\n"+
                "Конец диапазона: "+ end+"\n"+
                "Строки, начинающиеся с заданного символа: "+result;
    }
}
