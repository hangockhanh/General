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
    int rpCode;

    public int fixed_comment_last_id;

    public String fixed_content;
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
            //set to model
            // set to model
            this.setFixed_content(content+"");
            this.setFixed_comment_last_id(comment_last_id);
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
    public String getFixed_content() {
        return fixed_content;
    }

    public void setFixed_content(String fixed_content) {
        this.fixed_content = fixed_content;
    }

    public int getFixed_comment_last_id() {
        return fixed_comment_last_id;
    }

    public void setFixed_comment_last_id(int comment_last_id) {
        this.fixed_comment_last_id = comment_last_id;
    }
    public int getHttpCode(){
        return rpCode;
    }

}




