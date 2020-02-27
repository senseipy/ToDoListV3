package jl.elitek.todolistv3.ui.proyectos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jl.elitek.todolistv3.models.Proyecto

class ListaProyectosViewModel : ViewModel() {
    // listado de proyectos del usuario
    private val listaProyectos = MutableLiveData<List<Proyecto>>()

    val observableListaProyectos: LiveData<List<Proyecto>>
        get() = listaProyectos

    fun getProyectos(){

    }
}
