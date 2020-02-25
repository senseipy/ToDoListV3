package jl.elitek.todolistpluv3.network

import android.util.Log
import jl.elitek.todolistv3.models.Persona
import jl.elitek.todolistv3.Params
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LoginAPI {

    @POST("persona/login/{user}/{pass}")
    fun postLogin(
        @Path("user") user: String,
        @Path("pass") pass: String
       /* @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int*/
    ): Call<Persona>

    companion object {
        val BASE_URL = Params.BASE_URL


        fun create(): LoginAPI {
           // Log.d("REST","$BASE_URL")
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(LoginAPI::class.java)
        }
    }
}