package com.weimont.retrofittutorial;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MIndicadorAPIService {

    public static final String BASE_URL = "https://mindicador.cl/api/";

    @GET("dolar")
    Call<Indicador> getValues();



}
