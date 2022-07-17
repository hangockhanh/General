package GetListComments;

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


public class GetListComments {
    public static GetListCommentsClass rp;
    private static HttpURLConnection connection;
    public GetListComments(String auction_id,String index, String count, String token) throws  IOException{

        StringBuilder content = new StringBuilder();

        URL url = new URL(API.base+"comments/"+ auction_id +"?count=" + count + "&index=" + index);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer" + token);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try{

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);

            }
            System.out.println(content);
            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(content.toString(), GetListCommentsClass.class);
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
    public Comment[] getComments(){
        return rp.data.comments;
    }
    public String getCommentId(Comment[] comments){return comments[0].comment_id;}
    public int getCommentLength() {return rp.data.comments.length;}
}




