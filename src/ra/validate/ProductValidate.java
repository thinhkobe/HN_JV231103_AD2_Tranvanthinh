package ra.validate;
import java.util.Scanner;

public class ProductValidate {
    private Scanner scanner;

    public ProductValidate() {
        this.scanner = new Scanner(System.in);
    }

    // Phương thức kiểm tra tính hợp lệ cho productId
    public String validateProductId(String string) {
        String productId;
        do {
            System.out.print("Nhập productId (Pxxxx): ");
            productId = scanner.nextLine();
            if (productId.matches("P\\d{4}")) {
                return productId;
            } else {
                System.out.println("ProductId không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    // Phương thức kiểm tra tính hợp lệ cho productName
    public String validateProductName(String string) {
        String productName;
        do {
            System.out.print("Nhập tên sản phẩm: ");
            productName = scanner.nextLine().trim();
            if (!productName.isEmpty()) {
                return productName;
            } else {
                System.out.println("Tên sản phẩm không được để trống. Vui lòng nhập lại.");
            }
        } while (true);
    }

    // Phương thức kiểm tra tính hợp lệ cho productPrice
    public double validateProductPrice(double aDouble) {
        double productPrice;
        do {
            System.out.print("Nhập giá sản phẩm: ");
            try {
                productPrice = Double.parseDouble(scanner.nextLine());
                if (productPrice > 0) {
                    return productPrice;
                } else {
                    System.out.println("Giá sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    // Phương thức kiểm tra tính hợp lệ cho stock
    public int validateStock(int integer) {
        int stock;
        do {
            System.out.print("Nhập tồn kho: ");
            try {
                stock = Integer.parseInt(scanner.nextLine());
                if (stock >= 10) {
                    return stock;
                } else {
                    System.out.println("Tồn kho phải ít nhất là 10. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tồn kho không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }
}
