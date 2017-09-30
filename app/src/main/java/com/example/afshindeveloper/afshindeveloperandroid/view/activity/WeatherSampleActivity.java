package com.example.afshindeveloper.afshindeveloperandroid.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.afshindeveloper.afshindeveloperandroid.ApiService;
import com.example.afshindeveloper.afshindeveloperandroid.R;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.WeatherInfo;

import org.json.JSONObject;

public class WeatherSampleActivity extends AppCompatActivity implements ApiService.OnWeatherInfoRecived{
    private static final String TAG = "WeatherSampleActivity";
    private ApiService apiService;
    private ProgressBar progressBar;
    private TextView txtweathername;
    private TextView txtweatherdescription;
    private TextView txttemp;
    private TextView txthumidity;
    private TextView txtpressure;
    private TextView txtmintemp;
    private TextView txtmaxtemp;
    private TextView txtwindspeed;
    private TextView txtdegree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_sample);
        apiService=new ApiService(this);
        initviews();
        Button btnsendrequest=(Button)findViewById(R.id.btn_sendrequest);
        btnsendrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.getCurrentWeather(WeatherSampleActivity.this,"Orumiyeh");
                progressBar.setVisibility(View.VISIBLE);
            }
        });

    }
    private void initviews(){
        progressBar=(ProgressBar)findViewById(R.id.progressbr);
        txtweathername=(TextView)findViewById(R.id.txt_weather_name);
        txtweatherdescription=(TextView)findViewById(R.id.txt_weather_description);
        txttemp=(TextView)findViewById(R.id.txt_temprutur);
        txthumidity=(TextView)findViewById(R.id.txt_humidity);
        txtpressure=(TextView)findViewById(R.id.txt_pressure);
        txtmintemp=(TextView)findViewById(R.id.txt_temp_min);
        txtmaxtemp=(TextView)findViewById(R.id.txt_temp_max);
        txtwindspeed=(TextView)findViewById(R.id.txt_wind_speed);
        txtdegree=(TextView)findViewById(R.id.txt_wind_degree);
    }

    @Override
    public void onrecived(WeatherInfo weatherInfo) {
     if (weatherInfo!=null){

         //show information for users
         txtweathername.setText("آب و هوای فعلی:"+weatherInfo.getWeathername());
         txtweatherdescription.setText("توضیحات:"+weatherInfo.getDescription());
         txttemp.setText("دمای فعلی:"+String.valueOf(weatherInfo.getWeatherTempratur()));
         txthumidity.setText("رطوبت هوا:"+String.valueOf(weatherInfo.getHumidity()));
         txtpressure.setText("میزان فشار هوا:"+ String.valueOf(weatherInfo.getPressure()));
         txtmaxtemp.setText("بیشینه دما:"+String.valueOf(weatherInfo.getMaxTempratur()));
         txtmintemp.setText("کمینه دما:"+String.valueOf(weatherInfo.getMinTempratur()));
         txtwindspeed.setText("سرعت باد:"+ String.valueOf(weatherInfo.getWindspeed()));
         txtdegree.setText("درجه باد:"+String.valueOf(weatherInfo.getWindDegree()));

     }
     else {

         Toast.makeText(this,"خطا در دریافت اطلاعات",Toast.LENGTH_LONG).show();
     }
     progressBar.setVisibility(View.INVISIBLE);
    }
}
