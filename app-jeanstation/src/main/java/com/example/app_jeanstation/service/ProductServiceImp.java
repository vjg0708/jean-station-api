package com.example.app_jeanstation.service;

import com.example.app_jeanstation.DTO.ProductDTO;
import com.example.app_jeanstation.mapper.ProductMapper;
import com.example.app_jeanstation.model.Product;
import com.example.app_jeanstation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    ProductRepository useRepository;


    @Override
    public ProductDTO getProductById(Long id) {

        Product getProduct = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not found"));
        return ProductMapper.convertToDTO(getProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {

        if (!(useRepository.count() > 0)) {

            throw new RuntimeException("Entities are not available");
        }
        return useRepository.findAll().stream()
                .map(ProductMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String addProduct(ProductDTO productDTO) {

        if (useRepository.existsById(productDTO.getId())) {
            return "Entity already exists";
        }
        useRepository.save(ProductMapper.convertToEntity(productDTO));
        return "Entity added";

    }

    @Override
    public String addAllProducts(List<ProductDTO> productsDTO) {

        useRepository.saveAll(ProductMapper.convertToEntities(productsDTO));
        return "Entities added";
    }

    @Override
    public String updateProductById(Long id, ProductDTO productDTO) {

        if (useRepository.existsById(id)) {
            ProductDTO updateProductDTO = ProductMapper.convertToDTO(useRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Entity not Exists")));
            updateProductDTO.setProductName(productDTO.getProductName());
            updateProductDTO.setProductPrice(productDTO.getProductPrice());
            updateProductDTO.setProductStock(productDTO.getProductStock());
            updateProductDTO.setProductCode(productDTO.getProductCode());

            useRepository.save(ProductMapper.convertToEntity(updateProductDTO));
            return "Entity updated";
        }

        return "Entity not updated";
    }

    @Override
    public ProductDTO updateProductName(Long id, String productName) {

        Product product = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        product.setProductName(productName);
        return ProductMapper.convertToDTO(useRepository.save(product));
    }


    @Override
    public ProductDTO updateProductPrice(Long id, Double productPrice) {

        Product product = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        product.setProductPrice(productPrice);
        return ProductMapper.convertToDTO(useRepository.save(product));
    }

    @Override
    public ProductDTO updateProductStock(Long id, Integer productStock) {

        Product product = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        product.setProductStock(productStock);
        return ProductMapper.convertToDTO(useRepository.save(product));
    }

    @Override
    public ProductDTO updateProductCode(Long id, String productCode) {

        Product product = useRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Entity not found"));
        product.setProductCode(productCode);

        return ProductMapper.convertToDTO(useRepository.save(product));
    }


    @Override
    public String deleteProductById(Long id) {

        if (useRepository.existsById(id)) {
            useRepository.deleteById(id);
            return "Entity Deleted";
        }
        return "Entity not deleted";
    }

    @Override
    public String deleteAllProducts() {

        useRepository.deleteAll();
        return "All entities deleted";
    }
}
