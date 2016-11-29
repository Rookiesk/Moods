package cafe.moods.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chertpong on 11/29/2016.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao productDao;

    @PreAuthorize("")
    @Override
    public List<Product> getAllSecretProduct() {
        return productDao.getAllSecretProduct();
    }
}
