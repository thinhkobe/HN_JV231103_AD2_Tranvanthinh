package ra.model;

import ra.service.CartService;
import ra.service.ProductService;
import ra.until.InputMethods;

import java.lang.module.FindException;
import java.util.List;


public class CartItem {
        private String cartItemId;
        private Product product;
        private double price;
        private int quantity;

        public CartItem() {
        }

        public CartItem(String cartItemId, Product product, double price, int quantity) {
            this.cartItemId = cartItemId;
            this.product = product;
            this.price = this.product.getProductPrice()*this.quantity;
            this.quantity = quantity;
        }

        public String getCartItemId() {
            return cartItemId;
        }

        public void setCartItemId(String cartItemId) {
            this.cartItemId = cartItemId;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "CartItem{" +
                    "cartItemId='" + cartItemId + '\'' +
                    ", product=" + product.getProductName() +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    '}';
        }
        public void addTocart(boolean isAdd){
            if (isAdd){
                this.cartItemId= CartService.getNewId();
            }
            ProductService productService=new ProductService();
            System.out.println("nhập id sản phẩm muốn thêm");
            String idPro= InputMethods.getString();
           this.product=productService.findById(idPro);
            System.out.println("nhập số lượng sản phẩm");
            int count=InputMethods.getInteger();
            if (this.product.getStock()<count){
                System.out.println("Hàng tồn kho không đủ");
            }else{
                this.quantity=count;

                changeStock(productService, count);
            }

        }

    public  void changeStock(ProductService productService, int count) {
        //thay đổi số lượng sản phẩm trong cửa hàng
        String idPro1=this.product.getProductId();
        Product changePro= productService.findById(idPro1);
        List<Product> editList=ProductService.productList;
        for (Product product1 : editList) {
            if (product1.equals(changePro)){
                product1.setStock(product1.getStock()- count);
            }
        }
        ProductService.productList=editList;
    }
}


