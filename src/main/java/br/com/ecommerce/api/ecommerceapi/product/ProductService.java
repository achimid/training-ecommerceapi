package br.com.ecommerce.api.ecommerceapi.product;

import br.com.ecommerce.api.ecommerceapi.product.Product;
import br.com.ecommerce.api.ecommerceapi.product.ProductRepository;
import br.com.ecommerce.api.ecommerceapi.base.intefaces.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lourran on 11/07/2017.
 */
@Service
public class ProductService implements BaseService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        if (productRepository.exists(id)) {
            productRepository.delete(id);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }
}
