import org.jsoup.nodes.Document;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class Zapisywanie {
    private File sciezka;

    Zapisywanie()
    {
    }
    public void zapis(String sciezka,String img,int i)
    {
        try {
            if(!sciezka.endsWith("/")) sciezka=sciezka+"/";

            URL imageUrl=new URL(img);
            RenderedImage zdjecie=ImageIO.read(imageUrl);
            File folder=new File(sciezka);
            if(!folder.isDirectory()) folder.mkdir();
            this.sciezka = new File(sciezka + "/plik"+ i+".jpg");
            // ImageIO.write(imageUrl,".jpg",this.sciezka);
            ImageIO.write(zdjecie,"jpg",this.sciezka);
        }
        catch(IOException e)
        {
            System.err.println("Błąd odczytu obrazka");
            e.printStackTrace();
        }
    }
    public void zapiszZdjecie(PrintWriter zap,String img,int i)
    {

            zap.println(img);


    }
}
