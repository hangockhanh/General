package logout;
import login.LoginRequest;
import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class LogoutTest {
    @Test
    public void true_logout() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp2388");
        String access_token = loginrequest.getAccess_token();
        LogoutRequest logoutrequest = new LogoutRequest(access_token);
        String code = logoutrequest.getCode();
        assertEquals("code should be 1000", "1000", code);
    }
}
