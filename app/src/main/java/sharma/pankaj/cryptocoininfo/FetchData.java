package sharma.pankaj.cryptocoininfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author pankaj sharma
 */
public class FetchData {
    StringBuilder sb;
    BufferedReader br = null;
    String getString;

    public String getURLContent(String urlStr) {
        try {

            URL url = new URL(urlStr);
            InputStream ins = url.openStream();
            br = new BufferedReader(new InputStreamReader(ins));

            sb = new StringBuilder();
            String msg = null;
            while ((msg = br.readLine()) != null) {
                sb.append(msg);

            }
            br.close();
            getString = sb.toString();
        } catch (Exception en) {
            System.out.println(en);
        }

        return getString;
    }

}
