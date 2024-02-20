package ra.managerment;

import ra.model.CartItem;
import ra.model.Product;
import ra.service.CartService;
import ra.service.ProductService;
import ra.until.InputMethods;

import java.util.List;

public class CartManagerment {
    static ProductService productService = new ProductService();

    public static void CartControler() {
        while (true) {
            System.out.println("**************************MENU-USER**************************\n");
            System.out.println("1. Xem danh sách sản phẩm\n" +
                    "2. Thêm vào giỏ hàng\n" +
                    "3. Xem tất cả sản phẩm giỏ hàng\n" +
                    "4. Thay đổi số lượng sản phẩm trong giỏ hàng\n" +
                    "5. Xóa 1 sản phẩm trong giỏ hàng\n" +
                    "6. Xóa toàn bộ sản phẩm trong giỏ hàng\n" +
                    "7. Quay lại\n");
            System.out.println("nhập lựa chọn");
            byte choice = ra.until.InputMethods.getByte();
            switch (choice) {
                case 1:
                    ProductManagerment.displayAll();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    showAllCart();
                    break;
                case 4:
                    edit();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    deleteAll();
                case 7:
                    return;
                default:
                    System.err.println("nhập sai lựa chọn");

            }
        }
    }

    static CartService cartService = new CartService();

    public static void addProduct() {
        System.out.println("danh sách sản phẩm");
        ProductManagerment.displayAll();
        CartItem cartItem = new CartItem();
        cartItem.addTocart(true);
        cartService.save(cartItem);
    }

    public static void showAllCart() {
        List<CartItem> list = CartService.cartItemList;
        if (list.isEmpty()) {
            System.out.println("danh sách rỗng");
            return;
        }
        for (CartItem cartItem : list) {
            System.out.println(cartItem);
        }
    }



    public static void delete() {
        showAllCart();
        System.out.println("nhập id cart");
        String idEdit = InputMethods.getString();
        CartItem deleteCart = cartService.findById(idEdit);
        CartService.cartItemList.remove(deleteCart);

    }

    public static void deleteAll() {
        CartService.cartItemList.clear();
    }
    public static void edit(){
        showAllCart();
        System.out.println("nhập id cart cần chỉnh sửa ");
        String id =InputMethods.getString();
        System.out.println("số lượng cần chỉnh sửa");
        int count=InputMethods.getInteger();
        cartService.updateCartItemQuantity(id,count);

    }
}
