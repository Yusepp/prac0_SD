import utils.ComUtilsService;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    private static final int STRING = 0, INT = 1,VARIABLE = 2;
    public static void main(String[] args) {
        System.out.println("Hello word");
        File f = new File("test");
        try {
            f.createNewFile();
            ComUtilsService com = new ComUtilsService(new FileInputStream(f),new FileOutputStream(f));

            com.writeTest(STRING,"José Manuel López",0);
            com.writeTest(INT,"21",0);
            com.writeTest(VARIABLE,"Mama e gomitao",14);

            System.out.println("Read String: "+com.readTest(STRING,0));
            System.out.println("Read Int: "+com.readTest(INT,0));
            System.out.println("Read Variable: "+com.readTest(VARIABLE,14));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}