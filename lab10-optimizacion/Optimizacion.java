package lab10-optimizacion;

// Redundant database queries
public class ProductLoader {
    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        for (int id = 1; id <= 100; id++) {
            products.add(database.getProductById(id));  //aqui se harian 100 consultas a la base de datos, cuando se puede pedir todos los productos de una sola vez
        }
        return products;
    }
}

// se puede crear una query sql que pida todos los productos de una sola vez
//ejemplo crear un metodo que consulte y devuelva la lista de productos:
"SELECT p FROM Product p WHERE p.id BETWEEN :startId AND :endId"

public List<Product> getRangeProducts(int startId, int endId) {
    return entityManager.createQuery("SELECT p FROM Product p WHERE p.id BETWEEN :startId AND :endId", Product.class)
            .setParameter("startId", startId)
            .setParameter("endId", endId)
            .getResultList();
}

//posterior en en otro metodo se puede llamar a este metodo para obtener todos los productos de una sola vez
public class ProductLoader {
    public List<Product> loadProducts() {
        return database.getRangeProducts(1, 100);
    }
}