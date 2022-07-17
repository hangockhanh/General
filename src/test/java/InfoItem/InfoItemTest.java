package InfoItem;
import java.net.ProtocolException;
import java.io.IOException;
import login.LoginRequest;
import logout.LogoutRequest;

import org.junit.Assert;
import org.junit.Test;

public class InfoItemTest{

    String token= "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU4MDQzMDM4LCJleHAiOjE2NTg0MDMwMzgsIm5iZiI6MTY1ODA0MzAzOCwianRpIjoicmo0NFE1VmJRSERaUW9ZSCIsInN1YiI6NjMsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.77-ECKqvAAd1J1F0SkR9L5oySBXoawKUlFvPj2ch1_k";

    @Test
    public void Test01() throws ProtocolException, IOException{
        System.out.println("Unit test 1: if token is correct and item_id was created, code should be 1000, msg should be OK");
        InfoItem infoItem = new InfoItem("10",token);
        int code = infoItem.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK",infoItem.getMessage());
        System.out.println("Success !!");
    }

}
