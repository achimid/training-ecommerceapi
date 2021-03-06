package br.com.ecommerce.api.ecommerceapi;

import br.com.ecommerce.api.ecommerceapi.category.Category;
import br.com.ecommerce.api.ecommerceapi.category.CategoryUtil;
import br.com.ecommerce.api.ecommerceapi.product.Product;
import br.com.ecommerce.api.ecommerceapi.product.ProductService;
import br.com.ecommerce.api.ecommerceapi.product.ProductUtil;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by Lourran on 11/07/2017.
 */

public class ProductTests extends ApplicationTests {

    @Test
    public void CRUDTest(){
        Product product = ProductUtil.getInstance().createProduct();
        productService.save(product);
        if(!productService.findOne(product.getId()).equals(product)){
            throw new RuntimeException();
        }
        product.setDescription("Desc");
        productService.save(product);
        productService.delete(product.getId());
    }

}
