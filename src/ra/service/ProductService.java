package ra.service;

import ra.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService implements IGenerricService<Product,String>{
    public static List<Product> productList=new ArrayList<>();
    @Override
    public List getAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }

    @Override
    public Product findById(String id) {
        for (Product product : productList) {
            if (product.getProductId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(String s) {
        productList.remove(findById(s));
    }
    // Sắp xếp sản phẩm theo giá giảm dần
    public void sortProductsByPriceDescending() {


        Collections.sort(productList, (p1, p2) -> Double.compare(p2.getProductPrice(), p1.getProductPrice()));
    }
    // Tìm kiếm sản phẩm theo tên sản phẩm
    public void searchProductByName(String productName) {
        boolean found = false;
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println("Thông tin sản phẩm:");
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có tên " + productName);
        }
    }

//     Thay đổi thông tin sản phẩm theo mã
    public void updateProductById(String productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                System.out.println("Nhập thông tin mới cho sản phẩm:");
                product.inputData(false);
                System.out.println("Đã cập nhật thông tin cho sản phẩm có mã " + productId);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + productId);
    }
}
