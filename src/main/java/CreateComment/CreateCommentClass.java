package CreateComment;
import java.util.List;

public class CreateCommentClass {
    public int code;
    public String message;
    public Data data;
}
class Data{
    public String auction_id;
    public String user_id;
    public String content;
    public String update_at;
    public String total;
    public Comment[] comments;
}

class Comment{
    public String auction_id;
    public String user_id;
    public String content;
    public String update_at;
    public String total;

}

