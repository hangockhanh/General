package CreateComment;

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
import com.google.gson.JsonSyntaxException;


public class CreateComment {
    public static CreateCommentClass rp;
    private static HttpURLConnection connection;

    public CreateComment(String auction_id,String content,int comment_last_id, String token) throws  IOException{

        StringBuilder requestContent = new StringBuilder();

        URL url = new URL(API.base+"comments/create/"+auction_id);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer" + token);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String data = "{\n \"content\": \"" + content + "\"" + "    ,\n  \"comment_last_id\": \"" + comment_last_id
                + "\"" + " \n}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        try {
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
            writer.write(out);
            writer.flush();
            writer.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                requestContent.append(line);

            }
            System.out.println(requestContent);

            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(requestContent.toString(), CreateCommentClass.class);
            in.close();
        }
        finally {
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




