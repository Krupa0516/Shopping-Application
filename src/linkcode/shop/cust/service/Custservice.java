package linkcode.shop.cust.service;
import java.util.List;

import linkcode.shop.admin.model.Product;
import linkcode.shop.cust.model.Register;
import linkcode.shop.cust.model.login;
public interface Custservice {
	int create(List<Register>lst);
	boolean validateUser(login lobj);
	List<Product> search(int prodid);
}
