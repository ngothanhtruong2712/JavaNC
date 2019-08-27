/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoJava;

/**
 *
 * @author w7
 */
import java.sql.*;

public class Main {
    public static void main(String args[])
    {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rst=null;
        try{
            //bt1. Nap trinh dieu khien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //bt2. Dinh nghia chuoi ket noi
            String url = "jdbc:sqlserver://PC234\\SQLSERVER;" +
                         "databaseName=QLSanpham;";
            //bt3. Tao doi tuong ket noi
            conn = DriverManager.getConnection(url, "sa", "123456");
            //bt4. Tao doi tuong thuc thi cau lenh truy van va thi hanh
            stmt = conn.createStatement();
            System.out.println("---Bang loai san pham---");
            //bt5. Thuc thi cau lenh truy van
            rst = stmt.executeQuery("select * from LoaiSP");
            //bt6. Xu ly ket qua tra ve
            while(rst.next())//duyet cac mau tin ket qua
            {
                System.out.println(rst.getString("Maloai") + " - " + rst.getString("Tenloai"));
            }
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
    }
}
