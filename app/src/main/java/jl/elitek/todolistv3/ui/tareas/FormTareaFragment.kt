package jl.elitek.todolistv3.ui.tareas

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import jl.elitek.todolistv3.R

class FormTareaFragment : Fragment() {

    companion object {
        fun newInstance() = FormTareaFragment()
    }

    private lateinit var viewModel: FormTareaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_tarea_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FormTareaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
