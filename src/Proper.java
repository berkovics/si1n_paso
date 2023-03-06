import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Proper {
    final String PROP_FILE = "config.properties";

    public String readProper(String key) {
        try {
            return tryReadProper(key);
        } catch (IOException e) {
            String msg = "Hiba! A beállítás beolvasása sikertelen";
            System.err.println(msg);
            return msg;
            // TODO: handle exception
        }
    }

    public String tryReadProper(String key)
            throws FileNotFoundException,
            UnsupportedEncodingException,
            IOException {
        FileInputStream fis = new FileInputStream("config.properties");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        Reader reader = new BufferedReader(isr);
        Properties pro = new Properties();
        pro.load(reader);
        String result = pro.getProperty(key);
        return result;
    }

}
