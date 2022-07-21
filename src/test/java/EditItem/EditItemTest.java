package EditItem;
import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import CreateAuction.CreateAuction;

import login.LoginRequest;
import org.junit.Assert;
import org.junit.Test;

public class EditItemTest {

    // không có api nào trả về item_id
    @Test  //Lỗi data chỉ trả về name và image
    public void Test01() throws ProtocolException, IOException {
        System.out.println("Unit test 1: If all is correct, code=1000,msg=OK");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        EditItem editItem = new EditItem("2", "chicken", 150, 1, "king of chicken1", "otritor", login.getAccess_token());
        int code = editItem.getCode();
        Assert.assertEquals(1000, code);
        Assert.assertEquals("OK", editItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test02() throws IOException {
        System.out.println("Unit test 2: If not your item_id you create, code=1005,msg=Không thể chỉnh sửa");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        EditItem editItem = new EditItem("1", "chicken", 150, 1, "king of chicken1", "accbccss", login.getAccess_token());
        int code = editItem.getCode();
        Assert.assertEquals(1005, code);
        Assert.assertEquals("Không thể chỉnh sửa", editItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test03() throws IOException {
        System.out.println("Unit test 3: If name is empty, code =1001, msg=brand: &name: 7000&series: &description: &starting_price: ");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        EditItem editItem = new EditItem("2", "", 2350, 2, "king of chicken1", "esccefcdc", login.getAccess_token());
        int code = editItem.getCode();
        Assert.assertEquals(1001, code);
        Assert.assertEquals("brand: &name: 7000&series: &description: &starting_price: ", editItem.getMessage());
        System.out.println("Success !!");
    }

}