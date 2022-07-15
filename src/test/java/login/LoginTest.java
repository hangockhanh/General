package login;
import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class LoginTest{
    @Test
    public void true_account() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp2388");
        String code = loginrequest.getCode();
        assertEquals("code should be 1000", "1000", code);
    }
    @Test
    public void trueEmail_falsePass() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "ngockhanh");
        String code = loginrequest.getCode();
        assertEquals("code should be 1002", "1002", code);
    }
    @Test
    public void falseEmail_truePass() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("hakhanh@gmail.com", "khanh");
        String code = loginrequest.getCode();
        assertEquals("code should be 1002", "1002", code);
    }
    @Test
    public void email_notPass() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "");
        String code = loginrequest.getCode();
        String message = loginrequest.getMessage();
        assertEquals("code should be 1001", "1001", code);
        assertEquals("message", "email:  &password: 7000", message);
    }
    @Test
    public void notEmail_pass() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("", "khanh");
        String code = loginrequest.getCode();
        String message = loginrequest.getMessage();
        assertEquals("code should be 1001", "1001", code);
        assertEquals("message", "email: 7000 &password: ", message);
    }
    @Test
    public void notEmail_notPass() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("", "");
        String code = loginrequest.getCode();
        String message = loginrequest.getMessage();
        assertEquals("code should be 1001", "1001", code);
        assertEquals("message", "email: 7000 &password: 7000", message);
    }
}
