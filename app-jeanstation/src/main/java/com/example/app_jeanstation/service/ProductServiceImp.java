package com.example.app_jeanstation.service;

import com.example.app_jeanstation.model.Product;
import com.example.app_jeanstation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements IProductService{

    @Autowired
    ProductRepository useRepository;

    @Override
    public Product getProductById(Integer id) {

        return useRepository.getReferenceById(id);
    }

    @Override
    public List<Product> getAllProducts() {

        return useRepository.findAll();
    }

    @Override
    public String addProduct(Product product) {

        if(useRepository.existsById(product.getProductId())){

            return "Entity already exists, use valid request";
        }
        useRepository.save(product);
        return "Entity added successfully";
    }

    @Override
    public String addAllProducts(List<Product> products) {

        useRepository.saveAll(products);
        return "Entities added successfully";
    }

    @Override
    public String updateProductById(Integer id, Product product) {

        if (useRepository.existsById(id)){

            Product updateProduct = useRepository.getReferenceById(id);
            updateProduct.setProductName(product.getProductName());
            updateProduct.setProductPrice(product.getProductPrice());

            useRepository.save(updateProduct);
            return "Entity updated Successfully";
        }

        return "Entity not exists";
    }

    @Override
    public Product updateProductNameById(Integer id, String productName) {

        if (useRepository.existsById(id)){

            Product updateProductName = useRepository.getReferenceById(id);
            updateProductName.setProductName(productName);

            useRepository.save(updateProductName);
            return useRepository.getReferenceById(id);
        }

        return null;
    }

    @Override
    public Product updateProductPriceById(Integer id, Double productPrice) {

        if (useRepository.existsById(id)){

            Product updateProductPrice = useRepository.getReferenceById(id);
            updateProductPrice.setProductPrice(productPrice);

            useRepository.save(updateProductPrice);
            return useRepository.getReferenceById(id);
        }
        return null;
    }

    @Override
    public String deleteProductById(Integer id) {

        useRepository.deleteById(id);

        if (useRepository.existsById(id)){
            return "Entity not deleted";
        }
        return "Entity deleted successfully";
    }

    @Override
    public String deleteAllProducts() {

        useRepository.deleteAll();
        if (useRepository.count()>0){

            return "Entities not deleted";
        }

        return "All Entities were removed";
    }
}
