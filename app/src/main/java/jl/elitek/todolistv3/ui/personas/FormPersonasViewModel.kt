package jl.elitek.todolistv3.ui.personas

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jl.elitek.todolistpluv3.network.LoginAPI
import jl.elitek.todolistv3.Params
import jl.elitek.todolistv3.models.Persona
import jl.elitek.todolistv3.network.PersonasAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormPersonasViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val nuevoUsuario = MutableLiveData<Persona>()
    val observableNuevoUsuario: LiveData<Persona>
        get() = nuevoUsuario

    private val personApi by lazy {
        PersonasAPI.create()
    }

     fun listarPersonas(): ArrayList<Persona>? {
        return null
    }

    fun setPersona(persona: Persona){

    }

    fun nuevaPersona(persona: Persona){
        Log.d("REST","function nuevaPersona()")
        val call = personApi.nuevaPersona(persona)

        call.enqueue(object : Callback<Persona> {
            override fun onFailure(call: Call<Persona>, t: Throwable) {
                Log.d(
                    "REST",
                    "Hubo un error al crear la persona: " + "${t.message}\n" + "${t.toString()}"
                )
            }
            // É X I T O
            override fun onResponse(
                call: Call<Persona>,
                response: Response<Persona>
            ) {
                Log.d("REST","Respuesta nueva Persona: $response.message()")
                val persona = response.body()
                Log.d("REST", response.body().toString())
                if (persona != null) {
                    nuevoUsuario.value = persona
             //       Params.setPersona(persona)
                    Log.d("REST", "Params.getPersona: ${Params.getPersona().toString()}")
               //     usuario.value = persona
                    // se actualizan los datos del usuario que realizó la solicitud
                    Log.d("REST", "Persona se creó con éxito:")
                }
            }

        })

        personApi.nuevaPersona(persona)
    }
}
