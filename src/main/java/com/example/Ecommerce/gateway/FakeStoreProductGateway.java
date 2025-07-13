package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.FakeStoreProductResponseDTO;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductGateway implements IProductGateway{
    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return null;
    }
}
