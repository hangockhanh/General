package EditItem;

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



public class EditItem {
    public static EditItemClass rp;
    private static HttpURLConnection connection;
    public EditItem(String item_id, String name, int starting_price, int brand_id, String description, String series, String token) throws  IOException{

        StringBuilder content = new StringBuilder();

        URL url = new URL(API.base+"items/edit/"+item_id);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer" + token);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String data = "{\n \"name\": \"" + name
                + "\",\n  \"brand_id\": \"" + brand_id
                + "\",\n  \"starting_price\": \"" + starting_price
                + "\",\n  \"description\": \"" + description
                + "\",\n  \"series\": \"" + series
                + "\"\n}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        try {
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
            writer.write(out);
            writer.flush();
            writer.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);

            }
            System.out.println(content);

            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(content.toString(), EditItemClass.class);

            in.close();
            //} catch (IOException e) {
            //    e.printStackTrace();
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




