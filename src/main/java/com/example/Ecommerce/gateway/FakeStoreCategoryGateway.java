package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.dto.FakeStoreCategoryResponseDTO;
import com.example.Ecommerce.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        // 1.make the http request to the fakestore api to fetch all the categories
        FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApi
                .getAllFakeCategories().execute().body();
        // 2. check if the response is null and throw an io exception if it is
        if(response == null){
            throw new IOException("failed to fetch categories from FakeStore Api");
        }
        // 3. map the response to a list of categorydto objects
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
