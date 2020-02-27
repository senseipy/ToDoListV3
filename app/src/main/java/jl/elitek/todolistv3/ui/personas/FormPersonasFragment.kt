package jl.elitek.todolistv3.ui.personas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import jl.elitek.todolistv3.R
import jl.elitek.todolistv3.models.Persona
import kotlinx.android.synthetic.main.form_personas_fragment.*

class FormPersonasFragment : Fragment() {

    companion object {
        fun newInstance() = FormPersonasFragment()
    }

    private lateinit var persona:Persona

    private lateinit var viewModel: FormPersonasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_personas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormPersonasViewModel::class.java)
        form_persona_btn_guardar.setOnClickListener{
            Log.d("REST","Click nueva persona")
            persona = Persona(0,form_persona_nombre.text.toString(),form_persona_email.text.toString(),"U")
            guardarPersona(persona)
        }

        viewModel.observableNuevoUsuario.observe(
            viewLifecycleOwner,
            Observer {
            Toast.makeText(context,"Usuario: ${it.nombre}, con ID: ${it.personaId} creado exitosamente.",Toast.LENGTH_SHORT).show()
            }
        )

    }

    fun guardarPersona(pers:Persona){
        Log.d("REST","Nueva persona por ingresar: ${pers.toString()}")
        viewModel.nuevaPersona(persona)

    }



}
