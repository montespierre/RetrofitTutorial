package com.weimont.retrofittutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // https://youtu.be/a0CLPuM1LSI

    private ListView vList_indicadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vList_indicadores = (ListView) findViewById(R.id.list_indicadores);

        callService();


    }

    public void callService(){
        Retrofit rf = new Retrofit.Builder().baseUrl(MIndicadorAPIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        MIndicadorAPIService svc = rf.create(MIndicadorAPIService.class);

        Call<Indicador> dolar = svc.getValues();

        dolar.enqueue(new Callback<Indicador>() {
            @Override
            public void onResponse(Call<Indicador> call, Response<Indicador> response) {
                if(!response.isSuccessful()){
                    Log.e("callService.onResponse", "Error" + response.code());

                } else {
                    Indicador usd = response.body();
                    fillList(usd);
                }

            }

            @Override
            public void onFailure(Call<Indicador> call, Throwable t) {
                Log.e("CallService.onfailure", t.getLocalizedMessage());

            }
        });
    }

    private void fillList(Indicador usd) {
        String[] valores = new String[usd.getSerie().size()];
        int i = 0;

        for (ValorIndicador vi : usd.getSerie()){
            valores[i] = vi.getValor() + " ( " + vi.getFecha() + " ) ";
            i++;

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores );
        vList_indicadores.setAdapter(adapter);



    }
}