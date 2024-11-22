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
public class ProductService {

    @Autowired
    ProductRepository useRepository;


    public ProductDTO getProductById(Long id) {

        Product getProduct = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not found"));
        return ProductMapper.convertToDTO(getProduct);
    }


    public List<ProductDTO> getAllProducts() {

        if (!(useRepository.count() > 0)) {

            throw new RuntimeException("Entities are not available");
        }
        return useRepository.findAll().stream()
                .map(ProductMapper::convertToDTO)
                .collect(Collectors.toList());
    }


    public ProductDTO addProduct(ProductDTO productDTO) {

        if(useRepository.existsById(productDTO.getId())){

            throw  new RuntimeException("Product Already exists");
        }
        Product product = useRepository.save(ProductMapper.convertToEntity(productDTO));
        return ProductMapper.convertToDTO(product);
    }


    public List<ProductDTO> addAllProducts(List<ProductDTO> productsDTO) {

        int exist = 0;
        for (ProductDTO products : productsDTO){

            if(useRepository.existsById(products.getId())){

                exist += 1;
            }
        }

        if (exist!=0){
            throw new RuntimeException("Products already exists");
        }

        return ProductMapper
                .convertToDTOs(useRepository
                        .saveAll(ProductMapper
                        .convertToEntities(productsDTO)));

    }


    public ProductDTO updateProductById(Long id, ProductDTO productDTO) {

        if (useRepository.existsById(id)) {
            ProductDTO updateProductDTO = ProductMapper.convertToDTO(useRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Entity not Exists")));
            updateProductDTO.setProductName(productDTO.getProductName());
            updateProductDTO.setProductPrice(productDTO.getProductPrice());
            updateProductDTO.setProductStock(productDTO.getProductStock());
            updateProductDTO.setProductCode(productDTO.getProductCode());

            return ProductMapper
                    .convertToDTO(useRepository
                            .save(ProductMapper
                                    .convertToEntity(updateProductDTO)));

        }

       else {

           throw new RuntimeException("Product Not found");
        }
    }


    public ProductDTO updateProductName(Long id, String productName) {

        Product product = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        product.setProductName(productName);
        return ProductMapper.convertToDTO(useRepository.save(product));
    }



    public ProductDTO updateProductPrice(Long id, Double productPrice) {

        Product product = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        product.setProductPrice(productPrice);
        return ProductMapper.convertToDTO(useRepository.save(product));
    }


    public ProductDTO updateProductStock(Long id, Integer productStock) {

        Product product = useRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        product.setProductStock(productStock);
        return ProductMapper.convertToDTO(useRepository.save(product));
    }


    public ProductDTO updateProductCode(Long id, String productCode) {

        Product product = useRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Entity not found"));
        product.setProductCode(productCode);

        return ProductMapper.convertToDTO(useRepository.save(product));
    }



    public String deleteProductById(Long id) {

        if (useRepository.existsById(id)) {
            useRepository.deleteById(id);
            return "Entity Deleted";
        }
        return "Entity not exists";
    }


    public String deleteAllProducts() {

        useRepository.deleteAll();
        return "All entities deleted";
    }
}
