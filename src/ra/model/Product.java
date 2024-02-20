package ra.model;

import ra.service.CatalogService;
import ra.until.InputMethods;
import ra.validate.ProductValidate;

public class Product {
    private String productId,productName,description;
    private double productPrice;
    private int stock;
    private Catalog catalog;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, String description, double productPrice, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.stock = stock;
        this.catalog = catalog;
        this.status = true;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", productPrice=" + productPrice +
                ", stock=" + stock +
                ", catalog=" + (catalog.getCatalogName()) +
                ", status=" + (status?"bán":"không bán") +
                '}';
    }
    public void inputData( boolean isAdd){
        ProductValidate productValidate=new ProductValidate();
        if (isAdd){
            System.out.println("nhập mã sản phẩm ");
          this.productId=  productValidate.validateProductId(InputMethods.getString());
        }

        System.out.println("nhập tên sản phẩm");
        this.productName=productValidate.validateProductName(InputMethods.getString());

        System.out.println("nhập mô tả");
        this.description=InputMethods.getString();

        System.out.println("nhập giá");
        this.productPrice=productValidate.validateProductPrice(InputMethods.getDouble());

        System.out.println("nhập số lượng");
        this.stock=productValidate.validateStock(InputMethods.getInteger());

        System.out.println("nhập câtlog");
        System.out.println(CatalogService.catalogList);
        System.out.println("nhập id catalog muốn thêm");
        int id=InputMethods.getInteger();
        CatalogService catalogService=new CatalogService();
        this.catalog=catalogService.findById(id);

        System.out.println("nhập nhập trạng thái");
        this.status=InputMethods.getBoolean();

    }

}
