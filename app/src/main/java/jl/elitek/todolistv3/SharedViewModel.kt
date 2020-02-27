package jl.elitek.todolistv3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jl.elitek.todolistv3.models.Persona

class SharedViewModel:  ViewModel() {
    private val usuario = MutableLiveData<Persona>()
    val observableUsuario: LiveData<Persona>
    get() = usuario
}