package com.example.afshindeveloper.afshindeveloperandroid;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Post;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.WeatherInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by afshindeveloper on 03/09/2017.
 */

public class ApiService {
    private static final String TAG = "ApiService";
    private Context context;
    public ApiService(Context context){
        this.context=context;
    }
    public void getCurrentWeather(final OnWeatherInfoRecived onWeatherInfoRecived, String cityname){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,

                "http://api.openweathermap.org/data/2.5/weather?q=Orumiyeh&apikey=ade54f2c2320c21135637617eb8a09b9",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "onResponse: "+response.toString());
                onWeatherInfoRecived.onrecived(parseResponsToWeatherInfo(response));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: "+error.toString());
                onWeatherInfoRecived.onrecived(null);

            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(8000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(request);
    }
    private WeatherInfo parseResponsToWeatherInfo(JSONObject response){

        WeatherInfo weatherInfo=new WeatherInfo();
        try {
            JSONArray weatherjsonarray=response.getJSONArray("weather");
            JSONObject weatherjsonobject=weatherjsonarray.getJSONObject(0);
            weatherInfo.setWeathername(weatherjsonobject.getString("main"));
            weatherInfo.setDescription(weatherjsonobject.getString("description"));
            JSONObject mainjsonobject=response.getJSONObject("main");
            weatherInfo.setWeatherTempratur((float)mainjsonobject.getDouble("temp"));
            weatherInfo.setHumidity(mainjsonobject.getInt("humidity"));
            weatherInfo.setPressure(mainjsonobject.getInt("pressure"));
            weatherInfo.setMinTempratur((float)mainjsonobject.getDouble("temp_min"));
            weatherInfo.setMaxTempratur((float)mainjsonobject.getDouble("temp_max"));
            JSONObject windjsonobject =response.getJSONObject("wind");
            weatherInfo.setWindspeed((float)windjsonobject.getDouble("speed"));
            weatherInfo.setWindDegree((float)windjsonobject.getDouble("deg"));
            return weatherInfo;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getposts(final OnPostsRecived onPostsRecived){
        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, "https://afshindadashnezhad.000webhostapp.com/GetPosts.php", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Post>posts=new ArrayList<>();
                for (int i=0;i<response.length();i++){
                    Post post=new Post();
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        post.setId(jsonObject.getInt("id"));
                        post.setTitle(jsonObject.getString("title"));
                        post.setContent(jsonObject.getString("content"));
                        post.setDate(jsonObject.getString("date"));
                        post.setPostimage(jsonObject.getString("image_url"));
                        posts.add(post);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                onPostsRecived.onRecived(posts);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: "+error);

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(18000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface OnWeatherInfoRecived{
        void onrecived(WeatherInfo weatherInfo);
    }
    public interface OnPostsRecived{
        void onRecived(List<Post> posts);
    }
}
