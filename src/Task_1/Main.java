package Task_1;

// Ввести строки из файла, записать в список.
// Вывести строки в файл в обратном порядке.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("F:\\Java_proj\\EMAP_Collections\\src\\Task_1\\File1.txt"));

        List<String> list = new LinkedList<>();

        while (sc.hasNext()){
            list.add(sc.nextLine());
        }
        sc.close();

        Collections.reverse(list);

        PrintWriter pw = new PrintWriter("F:\\Java_proj\\EMAP_Collections\\src\\Task_1\\File2.txt");
        pw.println(list.stream().collect(Collectors.joining("\n")));
        pw.close();
    }
}
