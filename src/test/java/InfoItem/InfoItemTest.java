package InfoItem;
import java.net.ProtocolException;
import java.io.IOException;
import login.LoginRequest;
import logout.LogoutRequest;

import org.junit.Assert;
import org.junit.Test;

public class InfoItemTest{

    @Test
    public void Test01() throws ProtocolException, IOException{
        System.out.println("Unit test 1: if token is correct and item_id was created, code should be 1000, msg should be OK");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        InfoItem infoItem = new InfoItem("10", login.getAccess_token());
        int code = infoItem.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK",infoItem.getMessage());
        System.out.println("Success !!");
    }

}
