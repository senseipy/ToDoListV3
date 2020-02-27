package jl.elitek.todolistv3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class ListaTareasFragment : Fragment() {

    companion object {
        fun newInstance() = ListaTareasFragment()
    }

    private lateinit var viewModel: ListaTareasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_tareas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListaTareasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
