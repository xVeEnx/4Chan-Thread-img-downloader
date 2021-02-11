import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;


public class Files {
    private File sciezka;
    private Connection adres;
    private ArrayList<String> lista=new ArrayList<>();
    Document dokument;
    public Files(String URL){
        try {
            adres = Jsoup.connect(URL);
            dokument=adres.get();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Błędny link spróbuj ponownie! ");
        }
        catch (IOException e) {
            System.out.println("Problem z IOException ");
        }
    }
    public ArrayList<String> zapis(Elements zdjecie)
    {
        for(int i=0;i<zdjecie.size();i++)
        {
            String link=zdjecie.get(i).attr("src");
            if(link.startsWith("//")&&link.endsWith(".jpg"))
            {
                link="https:"+link;
                lista.add(link);
            }
        }
        return lista;
    }

    public Document getDoc()
    {
        return this.dokument;
    }
//    public void finding()
//    {
//        Elements zdjecie=dokument.getElementsByAttribute("src");
////        System.out.println(zdjecie.attr("src"));
//        lista=zapis(zdjecie);
//
//          //  System.out.println(lista.get(i));
//    }
}
