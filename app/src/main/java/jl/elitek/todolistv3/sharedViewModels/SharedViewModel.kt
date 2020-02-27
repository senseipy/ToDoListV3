package jl.elitek.todolistv3.sharedViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jl.elitek.todolistv3.models.Persona

open class SharedViewModel: ViewModel() {
    val persona = MutableLiveData<Persona>()

    fun persona(item: Persona) {
        persona.value = item
    }
    /*
    private val admin = MutableLiveData<Persona>()
    val observableAdmin: LiveData<Persona>
        get() = admin

    fun setAdmin(pers:Persona){
        admin.value = pers
        Log.d("MSG","Viene ${admin.value.toString()}")
    }

    fun getAdmin(): Persona? {
        val value = admin.value
        return value
    }

    fun mostrar() {
        Log.d("MSG","Estoy aquí")
    }
    */

}