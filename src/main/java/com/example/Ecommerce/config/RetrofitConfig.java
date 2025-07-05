package com.example.Ecommerce.config;

import com.example.Ecommerce.gateway.api.FakeStoreCategoryApi;
import com.example.Ecommerce.gateway.api.FakeStoreProductApi;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Bean
    public Retrofit retrofit(){
        Dotenv dotenv = Dotenv.configure().load();
        String url = dotenv.get("FAKE_STORE_API_BASE_URL");

    return new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
   return retrofit.create(FakeStoreCategoryApi.class);
    }
    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
        return retrofit.create(FakeStoreProductApi.class);
    }
}
