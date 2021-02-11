import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //System.out.println("Wklej link do postu i po spacji sciezke pliku do ktorego chcesz zapisac pliki");
       // Scanner skan = new Scanner(System.in);
        //String URL=skan.next();
        // String sciezka=skan.next();
        String URL = "https://boards.4channel.org/n/thread/1598315#p1606040";
        String sciezka = "D://folder";
        Files plik = new Files(URL);
        ArrayList<String> lista = new ArrayList<>();
        lista = plik.zapis(plik.getDoc().getElementsByAttribute("src"));
        Zapisywanie zapis = new Zapisywanie();
        for (int i = 0; i < lista.size(); i++) {
            zapis.zapis(sciezka, lista.get(i), i);
//      }
//        try {
//            File folder = new File(sciezka);
//            PrintWriter zap = new PrintWriter(folder);
//
//
//            Zapisywanie zapis = new Zapisywanie();
//            for (int i = 0; i < lista.size(); i++) {
//                zapis.zapiszZdjecie(zap, lista.get(i), i);
//            }
//
//            zap.close();
//        }
//              catch(IOException e)
//        {
//            System.err.println("Błąd odczytu obrazka");
//            e.printStackTrace();
//        }
            System.out.println(lista);
        }
    }
}