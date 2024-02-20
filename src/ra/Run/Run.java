package ra.Run;

import ra.managerment.CartManagerment;
import ra.managerment.CatalogManagerment;
import ra.managerment.ProductManagerment;
import ra.until.InputMethods;

public class Run {
    public static void main(String[] args) {
        while (true){
            System.out.println("**************************BASIC-MENU**************************\n");
            System.out.println("1. Quản lý danh mục [5 điểm]\n" +
                    "2. Quản lý sản phẩm [5 điểm]\n" +
                    "3.Dành cho người dùng" +
                    "4. Thoát");
            System.out.println("nhập lựa chọn");
            byte choice= InputMethods.getByte();
            switch (choice){
                case 1:
                    CatalogManagerment.catalogControler();
                    break;
                case 2:
                    ProductManagerment.productControler();
                    break;
                case 3:
                    CartManagerment.CartControler();
                default:
                    System.err.println("nhập sai lựa chọn");
            }
        }
    }
}
