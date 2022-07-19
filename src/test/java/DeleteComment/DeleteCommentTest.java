package DeleteComment;
import java.net.ProtocolException;
import java.io.IOException;
import CreateAuction.CreateAuction;
import login.LoginRequest;
import org.junit.Assert;
import org.junit.Test;
import  logout.LogoutRequest;
import  CreateComment.CreateComment;
import  GetListComments.GetListComments;
public class DeleteCommentTest{

    @Test
    public void Test01() throws IOException{
        System.out.println("Unit test 1: If you delete your comment, code =1000, msg=OK");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateComment createComment = new CreateComment("3","thich",1, login.getAccess_token());
        GetListComments getListComments= new GetListComments("3","1","1", login.getAccess_token());
        DeleteComment deleteComment = new DeleteComment(getListComments.getCommentId(getListComments.getComments()),login.getAccess_token());
        int code = deleteComment.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK",deleteComment.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test02() throws IOException{
        System.out.println("Unit test 2: If not your comment, code =1006");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        DeleteComment deleteComment = new DeleteComment("300",login.getAccess_token());
        int code = deleteComment.getCode();
        Assert.assertEquals(1006,code);
        System.out.println("Success !!");
    }

}
