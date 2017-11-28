package com.example.hnino.consumingopendata;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hnino.consumingopendata.entities.CultivoIlicito;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.etDepartamento)
    EditText etDepartamento;
    @BindView(R.id.etMunicipio)
    EditText etMunicipio;
    @BindView(R.id.etLimitar)
    EditText etLimitar;
    @BindView(R.id.etWhereQuery)
    EditText etWhereQuery;
    @BindView(R.id.tvTotalRegistros)
    TextView tvTotalRegistros;

    public static final String BASE_URL = "https://www.datos.gov.co/resource/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String departamento = etDepartamento.getText().toString().trim();
                String municipio = etMunicipio.getText().toString().trim();
                String where = etWhereQuery.getText().toString().trim();
                String limitar = etLimitar.getText().toString().trim();

                if (departamento.isEmpty()) {
                    departamento = null;
                }
                if (municipio.isEmpty()) {
                    municipio = null;
                }
                if (where.isEmpty()) {
                    where = null;
                }
                if (limitar.isEmpty()) {
                    limitar = null;
                }
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                MyApiEndPointInterface apiService = retrofit.create(MyApiEndPointInterface.class);
                Call<List<CultivoIlicito>> call = apiService.getCrops(departamento, municipio, "", limitar);
                call.enqueue(new Callback<List<CultivoIlicito>>() {
                    @Override
                    public void onResponse(Call<List<CultivoIlicito>> call, Response<List<CultivoIlicito>> response) {
                        List<CultivoIlicito> list = response. body();
                        if (list == null) {
                            Toast.makeText(getApplicationContext(), R.string.no_resultados, Toast.LENGTH_SHORT).show();
                        } else {
                            tvTotalRegistros.setText("Total Registros: " + String.valueOf(list.size()));
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView.setAdapter(new CultivoRecyclerViewAdapter(list));
                        }

                    }

                    @Override
                    public void onFailure(Call<List<CultivoIlicito>> call, Throwable t) {

                    }
                });
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
