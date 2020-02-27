package jl.elitek.todolistv3.network

import jl.elitek.todolistv3.Params
import jl.elitek.todolistv3.models.Tarea
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TareaAPI {
    @GET("tarea/{persona}/{idPersona}")
    fun getTareasPersona(
        @Path("idPersona") idPersona: String

    ): Call<ArrayList<Tarea>>

    @POST("tarea")
    fun editarTarea(tarea:Tarea){

    }

    companion object {
        val BASE_URL = Params.BASE_URL

        fun create(): TareaAPI {
            // Log.d("REST","$BASE_URL")
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(TareaAPI::class.java)
        }
    }


}