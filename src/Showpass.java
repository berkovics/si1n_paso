import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Showpass {

    public void getPasses() throws FileNotFoundException {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(":");
            String using = lineArray[0];
            String cryptText = lineArray[1];
            String plainText = getPlainText(cryptText, this.getAppKey());
            System.out.println(using + ":" + plainText);
        }
    }

    private String getAppKey() {
        Proper proper = new Proper();
        String appKey = proper.readProper("AppKey");
        return appKey;
    }

    private String getPlainText(String cryptText, String key) {
        Crypto crypto = new Crypto();
        String plainText = crypto.decrypt(cryptText, key);
        return plainText;
    }
}
