package com.example.Ecommerce.gateway.api;

import com.example.Ecommerce.dto.FakeStoreCategoryResponseDTO;
import com.example.Ecommerce.dto.FakeStoreProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductApi {
    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getFakeProducts(@Path("id") Long id) throws Exception;
}
