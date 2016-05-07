package controller;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONException;

public class tesst {
    private static final String CLIENT_ID = "Dictionary1";
    private static final String CLIENT_SECRET_KEY ="maUQXnGo1OiClwMB391jMku4Yynnk3KqImUZbH/fL5M=";
    private static final String TRANSLATE_GOOGLE = "https://translate.googleapis.com/translate_a/single?client=gtx&dt=t&dt=bd&dj=1&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=at";

//    public static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36";
    public static String translateQuickGoogle(String input, String original,
            String destination) throws IOException, JSONException {

        String LANGUAGE_TARGET = "&tl=";
        String LANGUAGE_SOURCE = "&sl=";
        String QUERY = "&q=";

        String query = URLEncoder.encode(input, "utf-8");

        String translate = "";

        LANGUAGE_SOURCE += original;
        LANGUAGE_TARGET += destination;

        QUERY += query;

        String url = TRANSLATE_GOOGLE + LANGUAGE_TARGET + LANGUAGE_SOURCE
                + QUERY;

        String data = getUrl(url);

        JSONObject json;
        json = new JSONObject(data);

        JSONArray arr = json.getJSONArray("sentences");
        int lenght = arr.length();
        if (lenght > 0) {

            JSONObject ori;
            for (int i = 0; i < lenght; i++) {
                ori = arr.getJSONObject(i);
                try {
                    translate += new String(ori.getString("trans").getBytes("ISO-8859-1"), "utf-8");
                } catch (Exception e) {

                    // update key bing and retranslate
                }
            }
        }
        return translate;
    }

    public static String getUrl(String urlQuery) throws IOException {

        HttpURLConnection connection = null;
        BufferedReader reader;

        try {
            URL url = new URL(urlQuery);
            connection = (HttpURLConnection) url.openConnection();
            connection
                    .setRequestProperty(
                            "User-Agent",
                            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");

            InputStream in = connection.getInputStream();

            InputStreamReader streamReader = new InputStreamReader(in,
                    "iso-8859-1");

            reader = new BufferedReader(streamReader, 8);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            if (connection != null) {
                connection.disconnect();
            }

            return "";
        }
    }

//    public static void main(String[] args) throws JSONException, IOException {
//        System.out.println(translateQuickGoogle("laptop", "en", "vi"));
//        ;
//    }
    public static void main(String[] args) throws Exception {
        // Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
        Translate.setClientId(CLIENT_ID);
        Translate.setClientSecret(CLIENT_SECRET_KEY);
        String source = "Tao giặt quần áo xong rồi. Không biết mai khô không. Đm thừa sức khô nhé :v, clgt mày nói nhảm gì thế ";
        System.out.println(source);
        String translatedText = Translate.execute(source, Language.VIETNAMESE, Language.ENGLISH);
        System.out.println("Google : " + translateQuickGoogle(source, "vi", "en"));
        System.out.println("Bing : " + translatedText);
    }
}
