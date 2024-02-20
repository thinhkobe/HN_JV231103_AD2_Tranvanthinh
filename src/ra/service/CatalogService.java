package ra.service;

import ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements IGenerricService<Catalog,Integer>{
    public static List<Catalog> catalogList=new ArrayList();
    @Override
    public List<Catalog> getAll() {
        return catalogList;
    }

    @Override
    public void save(Catalog catalog) {
        catalogList.add(catalog);
    }

    @Override
    public Catalog findById(Integer id) {
        for (Catalog catalog : catalogList) {
            if (catalog.getCatalogId()==id){
                return catalog;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        catalogList.remove(findById(id));
    }
}
