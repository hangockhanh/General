package EditItem;
import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import CreateAuction.CreateAuction;

import org.junit.Assert;
import org.junit.Test;

public class EditItemTest {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU4MDQzMDM4LCJleHAiOjE2NTg0MDMwMzgsIm5iZiI6MTY1ODA0MzAzOCwianRpIjoicmo0NFE1VmJRSERaUW9ZSCIsInN1YiI6NjMsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.77-ECKqvAAd1J1F0SkR9L5oySBXoawKUlFvPj2ch1_k";

    // không có api nào trả về item_id
    @Test  //Lỗi data chỉ trả về name và image
    public void Test01() throws ProtocolException, IOException {
        System.out.println("Unit test 1: If all is correct, code=1000,msg=OK");
        EditItem editItem = new EditItem("2", "chicken", 150, 1, "king of chicken1", "otritor", token);
        int code = editItem.getCode();
        Assert.assertEquals(1000, code);
        Assert.assertEquals("OK", editItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test02() throws IOException {
        System.out.println("Unit test 2: If not your item_id you create, code=1005,msg=Không thể chỉnh sửa");
        EditItem editItem = new EditItem("1", "chicken", 150, 1, "king of chicken1", "accbccss", token);
        int code = editItem.getCode();
        Assert.assertEquals(1005, code);
        Assert.assertEquals("Không thể chỉnh sửa", editItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test03() throws IOException {
        System.out.println("Unit test 3: If name is empty, code =1001, msg=brand: &name: 7000&series: &description: &starting_price: ");
        EditItem editItem = new EditItem("2", "", 2350, 2, "king of chicken1", "esccefcdc", token);
        int code = editItem.getCode();
        Assert.assertEquals(1001, code);
        Assert.assertEquals("brand: &name: 7000&series: &description: &starting_price: ", editItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test04() throws IOException {
        System.out.println("Unit test 4: If series exist, code = 1001, msg =brand: &name: &series: 7004&description: &starting_price: ");
        EditItem editItem = new EditItem("390", "ccc", 2350, 2, "king of chicken1", "escmcdc", token);
        int code = editItem.getCode();
        Assert.assertEquals(1001, code);
        Assert.assertEquals("brand: &name: &series: 7004&description: &starting_price: ", editItem.getMessage());
        System.out.println("Success !!");
    }

}