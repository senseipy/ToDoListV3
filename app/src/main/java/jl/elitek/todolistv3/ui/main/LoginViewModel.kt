package jl.elitek.todolistv3.ui.main

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import jl.elitek.todolistpluv3.network.LoginAPI
import jl.elitek.todolistv3.Params
import jl.elitek.todolistv3.R
import jl.elitek.todolistv3.models.Persona
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel() : ViewModel() {
    private val usuario = MutableLiveData<Persona>()
    val observableUsuario: LiveData<Persona>
        get() = usuario

    private val loginApi by lazy {
        LoginAPI.create()
    }

    // TODO: Implement the ViewModel
    fun ingresar(usr: String, pass: String) {
        //  Log.d("REST","Hubo un error al obtener las personas")

               val call = loginApi.postLogin(usr, pass)

        call.enqueue(object : Callback<Persona> {
            override fun onFailure(call: Call<Persona>, t: Throwable) {
                //Toast.makeText(requireContext(), "Hubo un error al obtener la pelicula", Toast.LENGTH_SHORT).show()
                Log.d(
                    "REST",
                    "Hubo un error al obtener las personas: " + "${t.message}\n" + "${t.toString()}"
                )
            }

            // É X I T O
            override fun onResponse(
                call: Call<Persona>,
                response: Response<Persona>
            ) {
                val persona = response.body()
                Log.d("REST", response.body().toString())
                if (persona != null) {
                    Params.setPersona(persona)
                    Log.d("REST", "Params.getPersona: ${Params.getPersona().toString()}")
                    usuario.value = persona
                    // se actualizan los datos del usuario que realizó la solicitud
                    Log.d("REST", "Persona vino con éxito:")
                }
            }

        })


    }
}
