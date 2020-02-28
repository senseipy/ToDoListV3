package jl.elitek.todolistv3.ui.proyectos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jl.elitek.todolistv3.Params
import jl.elitek.todolistv3.models.Persona
import jl.elitek.todolistv3.models.Proyecto
import jl.elitek.todolistv3.network.PersonasAPI
import jl.elitek.todolistv3.network.ProyectoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormProyectoViewModel : ViewModel() {
    private val nuevoProyecto = MutableLiveData<Proyecto>()
    val observableNuevoProyecto: LiveData<Proyecto>
        get() = nuevoProyecto

    private val proyectosApi by lazy {
        ProyectoAPI.create()
    }

    fun nuevoProyecto(proyecto: Proyecto) {
        Log.d("REST", "llamada a ViewModel.nuevoProyecto()")
        val call = proyectosApi.nuevoProyecto(proyecto)
        call.enqueue(object : Callback<Proyecto> {
            override fun onFailure(call: Call<Proyecto>, t: Throwable) {
                //Toast.makeText(requireContext(), "Hubo un error al obtener la pelicula", Toast.LENGTH_SHORT).show()
                Log.d(
                    "REST",
                    "Hubo un error al crear el proyecto: " + "${t.message}\n" + "${t.toString()}"
                )
            }

            // É X I T O
            override fun onResponse(
                call: Call<Proyecto>,
                response: Response<Proyecto>
            ) {
                val proyecto = response.body()
                Log.d("REST", response.body().toString())
                if (proyecto != null) {

                    Log.d("REST", "Nuevo Proyecto: ${proyecto.toString()}")
                    nuevoProyecto.value = proyecto
                    // se actualizan los datos del usuario que realizó la solicitud
                    Log.d("REST", "Proyecto creado exitosamente.")
                }
            }

        })
    }
}
