package jl.elitek.todolistv3.network

import android.util.Log
import jl.elitek.todolistv3.models.Persona
import jl.elitek.todolistv3.Params
import jl.elitek.todolistv3.models.Proyecto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ProyectoAPI {

    @GET("proyecto/persona/{idPersona}")
    fun getProyectosPersona(
        @Path("idPersona") idPersona: String

    ): Call<ArrayList<Proyecto>>

    @POST("proyecto")
    fun nuevoProyecto(
        @Body proyecto: Proyecto
    ): Call<Proyecto>

    companion object {
        val BASE_URL = Params.BASE_URL

        fun create(): ProyectoAPI {
            // Log.d("REST","$BASE_URL")
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ProyectoAPI::class.java)
        }
    }
}