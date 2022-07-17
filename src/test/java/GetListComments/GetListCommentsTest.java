package GetListComments;
import java.net.ProtocolException;
import java.io.IOException;
import CreateAuction.CreateAuction;

import org.junit.Assert;
import org.junit.Test;

public class GetListCommentsTest{

    String token= "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU4MDQzMDM4LCJleHAiOjE2NTg0MDMwMzgsIm5iZiI6MTY1ODA0MzAzOCwianRpIjoicmo0NFE1VmJRSERaUW9ZSCIsInN1YiI6NjMsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.77-ECKqvAAd1J1F0SkR9L5oySBXoawKUlFvPj2ch1_k";

    @Test
    public void Test01() throws ProtocolException, IOException{
        System.out.println("Unit test 1: If all is correct, code = 1000, msg=OK");
        GetListComments getListComments = new GetListComments("1","2","3",token);
        int code = getListComments.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK",getListComments.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test02() throws ProtocolException, IOException{
        System.out.println("Unit test 2:If count = 0, comments.length=0");
        GetListComments getListComments = new GetListComments("1","2","0",token);
        int code = getListComments.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK",getListComments.getMessage());
        Assert.assertEquals(0,getListComments.getCommentLength());
        System.out.println("Success !!");
    }

}
