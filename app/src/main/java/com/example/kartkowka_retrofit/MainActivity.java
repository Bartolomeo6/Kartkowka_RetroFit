package com.example.kartkowka_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Planszowka> planszowki = new ArrayList<>();
    Button guzik;
    ListView lista;
    EditText wpiszObszar;
    ArrayAdapter<Planszowka> adapter;
    List<Planszowka> noweP = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guzik = findViewById(R.id.button);
        lista = findViewById(R.id.listaGier);
        wpiszObszar = findViewById(R.id.editTextNumber);


        Retrofit retroFit = new Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/EskiBek/planszowkiJson/").addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceholderApi placeholderApi = retroFit.create(JsonPlaceholderApi.class);
        Call<List<Planszowka>> wywolanie = placeholderApi.getPlanszowki();
        wywolanie.enqueue(new Callback<List<Planszowka>>() {
            @Override
            public void onResponse(Call<List<Planszowka>> call, Response<List<Planszowka>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }
                else{
                    planszowki = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Planszowka>> call, Throwable t) {

            }
        });

        guzik.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int obszar;

                        try{
                            obszar = Integer.parseInt(wpiszObszar.getText().toString());
                        }
                        catch(Exception e){
                            return;
                        }

                        // /\ SIGMA IDIOTOODPORNE

                        noweP.clear();
                        for (Planszowka x: planszowki)
                        {

                            if(obszar >= x.getMinWiek()){
                                noweP.add(x);
                                adapter = new ArrayAdapter<>(
                                        getApplicationContext(), android.R.layout.simple_list_item_1, noweP
                                );
                                lista.setAdapter(adapter);

                            }

                        }


                    }
                }
        );

    }
}