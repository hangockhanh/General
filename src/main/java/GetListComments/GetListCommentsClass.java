package GetListComments;
import java.util.List;

public class GetListCommentsClass {
    public int code;
    public String message;
    public Data data;
}
class Data{
    public String total;
    public Comment[] comments;
}

class Comment{
    public String user_name;
    public String user_avatar;
    public String update_at;
    public String content;
    public  String comment_id;
}

