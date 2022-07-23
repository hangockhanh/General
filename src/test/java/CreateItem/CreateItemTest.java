package CreateItem;

import java.io.IOException;
import CreateAuction.CreateAuction;
import login.LoginRequest;
import org.junit.Assert;
import org.junit.Test;
import  logout.LogoutRequest;

public class CreateItemTest{


    @Test
    public void Test01() throws IOException{
        System.out.println("Unit test 1: If all is correct, the code should be 1000, msg should be OK.");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateAuction createAuction = new CreateAuction(6,"2023/07/14 11:31","2024/07/21 11:31","vtd4f", login.getAccess_token());
        CreateItem createItem = new CreateItem(createAuction.getAuctionId(),"girl",300, 1, "beautiful","fcc1dsf", login.getAccess_token());
        int code = createItem.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", createItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test02() throws IOException{
        System.out.println("Unit test 2: If brand_id > 10, code = 1001 , msg=brand: The selected brand id is invalid.&name: &series: &description: &starting_price: ");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateAuction createAuction = new CreateAuction(5,"2023/07/14 11:31","2024/07/21 11:31","ewreew", login.getAccess_token());
        CreateItem createItem = new CreateItem(createAuction.getAuctionId(),"ire",6300, 20, "lonia","ierddccsc", login.getAccess_token());
        int code = createItem.getCode();
        Assert.assertEquals(1001,code);
        Assert.assertEquals("brand: The selected brand id is invalid.&name: &series: &description: &starting_price: ", createItem.getMessage());
        System.out.println("Success !!");
    }


    @Test  // lỗi Server returned HTTP code 500 , nhập auction_id = 2000000000 vẫn trả về 9996
    public void Test03() throws IOException{
        System.out.println("Unit test 3: If auction_id does not exist, code should be 9996 and message should be Id truyền vào không tồn tại");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateItem createItem = new CreateItem("3000000000","ire",6300, 3, "lonia","jwewfdvdd", login.getAccess_token());
        int code = createItem.getCode();
        Assert.assertEquals(9996,code);
        Assert.assertEquals("Id truyền vào không tồn tại", createItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test04() throws IOException{
        System.out.println("Unit test 4: If auction_id had item or approved, code should be 9995 and message should be Không thể thêm item mới với phiên đấu giá này");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateItem createItem = new CreateItem("929","ire",6300, 20, "lonia","i434d1", login.getAccess_token());
        int code = createItem.getCode();
        Assert.assertEquals(9995,code);
        Assert.assertEquals("Không thể thêm item mới với phiên đấu giá này", createItem.getMessage());
        System.out.println("Success !!");
    }

    @Test  // lỗi ko trả về được 1004, lỗi hệ thống 401
    public void Test05() throws IOException {
        System.out.println("Unit test 5: If not login, code should be 1004");
        LoginRequest loginRequest=new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        LogoutRequest logoutRequest=new LogoutRequest(loginRequest.getAccess_token());
        CreateItem createItem = new CreateItem("932", "girl", 300, 3, "beautiful", "gesd1w12", loginRequest.getAccess_token());
        int code = createItem.getCode();
        Assert.assertEquals(1004, code);
        //Assert.assertEquals("OK", createItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test06() throws IOException{
        System.out.println("Unit test 6: if series >10, code=1001, msg=brand: &name: &series: 7011&description: &starting_price: ");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateAuction createAuction = new CreateAuction(5,"2023/07/14 11:31","2024/07/21 11:31","axaxaxz", login.getAccess_token());
        CreateItem createItem = new CreateItem(createAuction.getAuctionId(),"girl",300, 1, "beautiful","999999999993", login.getAccess_token());
        int code = createItem.getCode();
        Assert.assertEquals(1001,code);
        Assert.assertEquals("brand: &name: &series: 7011&description: &starting_price: ", createItem.getMessage());
        System.out.println("Success !!");
    }

    @Test
    public void Test07() throws IOException{
        System.out.println("Unit test 7: If seri is empty, code should be 1001, msg=brand: &name: &series: 7004&description: &starting_price: ");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateAuction createAuction = new CreateAuction(5,"2023/07/14 11:31","2024/07/21 11:31","bm,deck m", login.getAccess_token());
        CreateItem createItem = new CreateItem(createAuction.getAuctionId(),"mm",300, 1, "c","", login.getAccess_token());
        int code = createItem.getCode();
        Assert.assertEquals(1001,code);
        Assert.assertEquals("brand: &name: &series: 7004&description: &starting_price: ",createItem.getMessage());
        System.out.println("Success !!");
    }

    @Test  // Lỗi stating_price >0
    public void Test08() throws IOException{
        System.out.println("Unit test 8: if starting_price <0, code should not be 1000");
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn","giangcvp");
        CreateAuction createAuction = new CreateAuction(5,"2023/07/14 11:31","2024/07/21 11:31","rt84", login.getAccess_token());
        CreateItem createItem = new CreateItem(createAuction.getAuctionId(),"girl",-300, 1, "beautiful","rie4o", login.getAccess_token());
        int code = createItem.getCode();
        Assert.assertNotEquals(1000,code);
        System.out.println("Success !!");
    }
}
