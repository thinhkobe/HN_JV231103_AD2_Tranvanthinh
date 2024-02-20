package ra.managerment;

import ra.model.Catalog;
import ra.service.CatalogService;
import ra.until.InputMethods;

import java.util.List;

public class CatalogManagerment {
    public static void catalogControler(){
        while (true){
            System.out.println("********************CATALOG-MANAGEMENT********************\n");
            System.out.println("1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục\n" +
                    "2. Hiển thị thông tin tất cả các danh mục \n" +
                    "3. Sửa tên danh mục theo mã danh mục [5 điểm]\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm) [5 điểm]\n" +
                    "5. Quay lại\n");
            System.out.println("nhập lựa chọn");
            byte choice= InputMethods.getByte();
            switch (choice){
                case 1:
                    addCatalog();
                    break;
                    case 2:
                    displayCatalog();
                    break;
                    case 3:
                    editCatalog();
                    break; case 4:
                    deleteCatalog();
                    break;
                case 5:
                    return;

            }
        }
    }
    static CatalogService catalogService=new CatalogService();
    public static void addCatalog(){
        System.out.println("nhập số lượng mục cần thêm");
        int count=InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            Catalog catalog=new Catalog();
            catalog.inputCatalogInfo(true);
            catalogService.save(catalog);
        }

    }
    public static void displayCatalog(){

        List<Catalog> list=catalogService.getAll();
        if (list.isEmpty()){
            System.out.println("danh mục rỗng");
            return;
        }
        for (Catalog catalog : list) {
            System.out.println(catalog);
        }
    }

    public static void editCatalog(){
        displayCatalog();
        System.out.println("nhập id danh mục muốn sửa");
        int id=InputMethods.getInteger();
       Catalog editCatalog=catalogService.findById(id);
       if (editCatalog==null){
           System.err.println("không tồn tại");
           return;
       }
        System.out.println("thông tin cũ");
        System.out.println(editCatalog);
        System.out.println("nhập thông tin mới");
        editCatalog.inputCatalogInfo(false);
        System.out.println("cập nhật thành công");
    }

    public static void deleteCatalog(){
        System.out.println("nhập id danh mục muốn xóa");
        int id=InputMethods.getInteger();
        CatalogService.catalogList.remove(catalogService.findById(id));
        System.out.println("xóa thành công");
    }
}
