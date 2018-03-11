package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.enums.ProductInfoStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoRepository repository;

    @Override
    public Optional<ProductInfo> findById(String productId) {
        return repository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductInfoStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if (!productInfo.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }

            ProductInfo unwrapProduct = productInfo.get();
            Integer result = unwrapProduct.getProductStock() + cartDTO.getProductQuantity();
            unwrapProduct.setProductStock(result);
            repository.save(unwrapProduct);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if (!productInfo.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }

            ProductInfo unwrapProduct = productInfo.get();
            Integer result = unwrapProduct.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            unwrapProduct.setProductStock(result);
            repository.save(unwrapProduct);
        }
    }
}
