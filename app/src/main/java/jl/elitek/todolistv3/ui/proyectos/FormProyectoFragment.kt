package jl.elitek.todolistv3.ui.proyectos

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import jl.elitek.todolistv3.R
import jl.elitek.todolistv3.models.Proyecto
import kotlinx.android.synthetic.main.form_proyecto_fragment.*
import kotlinx.android.synthetic.main.item_proyecto.*

class FormProyectoFragment : Fragment() {

    companion object {
        fun newInstance() = FormProyectoFragment()
    }

    private lateinit var viewModel: FormProyectoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_proyecto_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormProyectoViewModel::class.java)
        // TODO: Use the ViewModel
        form_proyecto_btn_guardar.setOnClickListener {
            nuevoProyecto()
        }
    }

    fun nuevoProyecto() {
        val nombre = form_proyecto_nombre.text.toString()
        val fecha_inicio = form_proyecto_fecha_inicio.text.toString()
        val comentarios = form_proyecto_comentarios.text.toString()
        val fecha_limite = form_proyecto_fecha_limite.text.toString()
        val fecha_fin = ""
        val progreso = 0
        val estado = form_proyecto_estado.text.toString()
        val proyecto = Proyecto(
            0,
            nombre,
            fecha_inicio,
            fecha_limite,
            fecha_fin,
            progreso,
            estado,
            comentarios,
            2
        )
        viewModel.observableNuevoProyecto.observe(viewLifecycleOwner, Observer {
             Toast.makeText(context, "Proyecto ${it.nombre} con ID ${it.id} creado exitosamente", Toast.LENGTH_SHORT).show()
        })
        viewModel.nuevoProyecto(proyecto)
    }

}
