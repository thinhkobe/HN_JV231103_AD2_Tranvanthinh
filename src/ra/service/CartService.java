package ra.service;

import ra.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartService implements IGenerricService<CartItem,String>{
    public static List <CartItem> cartItemList=new ArrayList<>();

    @Override
    public List<CartItem> getAll() {
        return cartItemList;
    }
    static public String getNewId() {
        int idMax = 0;
        for (CartItem cartItem : cartItemList) {
            int cartId = Integer.parseInt(cartItem.getCartItemId().replace("C", "0"));
            if (idMax < cartId) {
                idMax = cartId;
            }
        }
        idMax += 1;
        return "C" + String.format("%03d", idMax);
    }

    @Override
    public void save(CartItem cartItem) {

        cartItemList.add(cartItem);
    }

    @Override
    public CartItem findById(String id) {

        return  cartItemList.stream()
                .filter(e -> e.getCartItemId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String deleteid) {
        cartItemList.remove(findById(deleteid));
    }
    // Phương thức thay đổi số lượng sản phẩm trong giỏ hàng
    public void updateCartItemQuantity(String cartItemId, int newQuantity) {
        // Tìm cartItem cần cập nhật số lượng

       CartItem upDateCart= findById(cartItemId);

        if (upDateCart != null) {
            // Lấy số lượng hiện tại của sản phẩm trong giỏ hàng
            int currentQuantity = upDateCart.getQuantity();

            // Tính toán sự thay đổi số lượng
            int quantityChange = newQuantity - currentQuantity;

            // Kiểm tra số lượng tồn kho đủ để cập nhật không
            if (upDateCart.getProduct().getStock() + quantityChange >= 0) {
                // Cập nhật số lượng sản phẩm trong giỏ hàng
                upDateCart.setQuantity(newQuantity);

                // Cập nhật số lượng tồn kho tương ứng
                int updatedStock = upDateCart.getProduct().getStock() - quantityChange;
                upDateCart.getProduct().setStock(updatedStock);

                System.out.println("Số lượng sản phẩm đã được cập nhật thành công.");
            } else {
                System.out.println("Không đủ hàng trong kho để cập nhật số lượng sản phẩm.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm trong giỏ hàng.");
        }
    }
}
