package CreateComment;
import java.net.ProtocolException;
import java.io.IOException;
import CreateAuction.CreateAuction;
import login.LoginRequest;
import org.junit.Assert;
import org.junit.Test;
import  logout.LogoutRequest;
public class CreateCommentTest{

    @Test
    public void Test01() throws IOException{
        System.out.println("Unit test 1:If all is correct, code=1000, msg=OK");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp2388");
        //LogoutRequest logout = new LogoutRequest(login.getAccess_token());
        CreateComment createComment = new CreateComment("3","no comment",1, login.getAccess_token());
        int code = createComment.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK",createComment.getMessage());
        System.out.println("Success !!");
    }

    @Test // Lỗi, content = "" nhưng ko trả về lỗi 7000
    public void Test02() throws IOException{
        System.out.println("Unit test 2: If content is empty, code =1001, msg return error 7000");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp2388");
        //LogoutRequest logout = new LogoutRequest(login.getAccess_token());
        CreateComment createComment = new CreateComment("1","",2, login.getAccess_token());
        int code = createComment.getCode();
        Assert.assertEquals(1001,code);
        System.out.println("Success !!");
    }

    @Test
    public void Test03() throws IOException{
        System.out.println("Unit test 3: Can't comment, code=1008,msg=Không thể bình luận");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp2388");
        //LogoutRequest logout = new LogoutRequest(login.getAccess_token());
        CreateComment createComment = new CreateComment("2","com",1, login.getAccess_token());
        int code = createComment.getCode();
        Assert.assertEquals(1008,code);
        Assert.assertEquals("Không thể bình luận",createComment.getMessage());
        System.out.println("Success !!");
    }

    @Test // Lỗi không chạy ra 1004
    public void Test04() throws IOException{
        System.out.println("Unit test 4: if not login");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp2388");
        LogoutRequest logout = new LogoutRequest(login.getAccess_token());
        CreateComment createComment = new CreateComment("1","com",1, login.getAccess_token());
        int code = createComment.getCode();
        Assert.assertEquals(1004,code);
        System.out.println("Success !!");
    }
}
