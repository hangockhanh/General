package InfoItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import com.google.gson.Gson;
import API.API;



public class InfoItem {
    public static InfoItemClass rp;
    private static HttpURLConnection connection;
    public InfoItem(String item_id,String token) throws  IOException{

        StringBuilder content = new StringBuilder();

        URL url = new URL(API.base+"items/info/"+item_id);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer" + token);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            System.out.println(content);
            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(content.toString(), InfoItemClass.class);

            in.close();
        } finally {
            connection.disconnect();
        }

    }
    public int getCode(){
        return rp.code;
    }
    public String getMessage(){
        return rp.message;
    }
    public Data getData(){
        return rp.data;
    }

}




