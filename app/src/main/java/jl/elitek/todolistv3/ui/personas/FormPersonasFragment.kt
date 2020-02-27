package jl.elitek.todolistv3.ui.personas

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import jl.elitek.todolistv3.R

class FormPersonasFragment : Fragment() {

    companion object {
        fun newInstance() = FormPersonasFragment()
    }

    private lateinit var viewModel: FormPersonasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_personas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FormPersonasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
