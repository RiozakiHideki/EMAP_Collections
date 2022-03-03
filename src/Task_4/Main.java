package Task_4;

// Занести стихотворения одного автора в список
// Провести сортировку по возрастанию длин строк.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("F:\\Java_proj\\EMAP_Collections\\src\\Task_4\\File1.txt"));

        List<String> list = new LinkedList<>();

        while (sc.hasNext()){
            list.add(sc.nextLine());
        }
        sc.close();

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()) return 1;
                if (o1.length()<o2.length()) return -1;
                return 0;
            }
        });

        PrintWriter pw = new PrintWriter("F:\\Java_proj\\EMAP_Collections\\src\\Task_4\\File2.txt");
        pw.println(list.stream().collect(Collectors.joining("\n")));
        pw.close();
    }
}
