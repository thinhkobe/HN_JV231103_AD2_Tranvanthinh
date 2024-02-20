package ra.managerment;

import ra.model.Catalog;
import ra.model.Product;
import ra.service.ProductService;
import ra.until.InputMethods;

import java.util.List;

public class ProductManagerment {
    public static void productControler(){
        while (true){
            System.out.println("********************PRODUCT-MANAGEMENT********************\n");
            System.out.println("1. Nhập số sản sản phẩm và nhập thông tin sản phẩm [5 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [5 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá giảm dần [5 điểm]\n" +
                    "4. Xóa sản phẩm theo mã [5 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi thông tin của sách theo mã sách\n" +
                    "7.thoát");
            System.out.println("nhập lựa chọn");
            byte choice= InputMethods.getByte();
            switch (choice){
                case 1:
                    addProduct();
                    break;
                    case 2:
                    displayAll();
                    break;
                    case 3:
                    sortProductByPrice();
                    break;
                    case 4:
                    deleteProduct();
                    break;
                    case 5:
                        System.out.println("nhập tên tìm kiếm");
                        String key=InputMethods.getString();
                    productService.searchProductByName(key);
                    break;
                case 6:
                    updateProduct();
                case 7 :
                    return;
                default:
                    System.err.println("nhập sai lựa chọn");

            }
        }
    }
   static ProductService productService=new ProductService();
    public static void addProduct(){
        System.out.println("số lượng muốn thêm");
        int count=InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            System.out.println("nhâp thông tin sản phẩm thứ "+i);
            Product newProduct=new Product();
            newProduct.inputData(true);
            productService.save(newProduct);
        }
    }
    public static void displayAll(){
        List<Product> list=ProductService.productList;
        if (list.isEmpty()){
            System.out.println("danh sach rong ");
            return;
        }
        for (Product product : list) {
            System.out.println(product);
        }
    }
    public static void sortProductByPrice(){
        productService.sortProductsByPriceDescending();
        displayAll();
    }
    public static void deleteProduct(){
        System.out.println("nhập id cần xóa");
        String id=InputMethods.getString();
       productService.delete(id);
    }
    public static void updateProduct(){
        System.out.println("nhập id muốn sửa");
        String id=InputMethods.getString();
        productService.updateProductById(id);
    }
}
