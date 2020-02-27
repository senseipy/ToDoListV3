package jl.elitek.todolistv3.network

import jl.elitek.todolistpluv3.network.LoginAPI
import jl.elitek.todolistv3.Params
import jl.elitek.todolistv3.models.Persona
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface PersonasAPI {
    @POST("persona")
    fun nuevaPersona(
    @Body persona:Persona
    ): Call<Persona>

    companion object {
        val BASE_URL = Params.BASE_URL


        fun create(): PersonasAPI {
            // Log.d("REST","$BASE_URL")
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PersonasAPI::class.java)
        }
    }
}