package linkcode.shop.admin.service;
import java.util.List;
import linkcode.shop.admin.model.Product;
public interface Adminservice {
	public String createProduct(List<Product>lstproduct);
	public List<Product> search(int prodid);
	public List<Product> displayprod();

}
