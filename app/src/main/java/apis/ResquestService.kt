package apis

import models.Alarm
import models.Recorder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


class RequestService {

    interface RetrofitService {

        @GET("/video-devices/")
        fun getallrecorders(@Header(apis.auth.USER_TOKEN) token: String): Call<models.Recorders>

        @Headers("Content-Type: application/json")
        @POST("/video-devices")
        fun postrecorder(
            @Header((apis.auth.USER_TOKEN)) token: String,
            @Body body: Recorder
        ): Call<models.Recorder>

        @Headers("Content-Type: application/json")
        @POST("/alarm-centrals")
        fun postrecorder(
            @Header((apis.auth.USER_TOKEN)) token: String,
            @Body body: Alarm
        ): Call<models.Alarm>

        companion object {

            var retrofitService: RetrofitService? = null
            fun getInstance(): RetrofitService {

                if (retrofitService == null) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("http://squad-apps.ddns.net:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    retrofitService = retrofit.create(RetrofitService::class.java)
                }
                return retrofitService!!
            }
        }
    }
}