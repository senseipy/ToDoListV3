package jl.elitek.todolistv3.ui.proyectos

import jl.elitek.todolistv3.adapters.ListaProyectosAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jl.elitek.todolistv3.DataProvider
import jl.elitek.todolistv3.R
import jl.elitek.todolistv3.models.Persona
import jl.elitek.todolistv3.models.Proyecto
import jl.elitek.todolistv3.network.ProyectoAPI
import jl.elitek.todolistv3.sharedViewModels.SharedViewModel
import kotlinx.android.synthetic.main.lista_proyectos_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaProyectosFragment : Fragment() {
    private lateinit var listaProyectosRv: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ListaProyectosAdapter
    private var proyectos: MutableList<Proyecto> = mutableListOf()

    private var admin: Persona?
        get() {
            TODO()
        }
        set(value) {
            admin = value
        }

    companion object {
        fun newInstance() =
            ListaProyectosFragment()
    }

    private val proycetoApi by lazy {
        ProyectoAPI.create()
    }

    private lateinit var viewModel: ListaProyectosViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_proyectos_fragment, container, false)
        listaProyectosRv = view.findViewById(R.id.lista_proyectos)

        linearLayoutManager = LinearLayoutManager(requireContext())
        listaProyectosRv.layoutManager = linearLayoutManager

        adapter = ListaProyectosAdapter(requireContext(), proyectos as ArrayList<Proyecto>)
        listaProyectosRv.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = activity?.run {
            ViewModelProvider(this).get(SharedViewModel::class.java)
        }?:throw Exception("Invalid Activity")
        // OBSERVER controla cuando se pasa el admin
        sharedViewModel.persona.observe(viewLifecycleOwner, Observer {
            Log.d("MSG","Llegó la persona ${it.toString()}")
            obtenerProyectos(it.personaId)
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListaProyectosViewModel::class.java)
        lista_proyectos_fg_crearBtn.setOnClickListener {
            findNavController().navigate(ListaProyectosFragmentDirections.actionListaProyectosFragmentToFormProyectoFragment())
        }

    }

    fun obtenerProyectos(propietarioId: Int) {
        Log.d("REST", "obtenerProyectos()")
        val call = proycetoApi.getProyectosPersona(propietarioId.toString())
        call.enqueue(object : Callback<ArrayList<Proyecto>> {
            override fun onFailure(call: Call<ArrayList<Proyecto>>, t: Throwable) {
                /*Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()*/
                Log.d("Red", t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<Proyecto>>,
                response: Response<ArrayList<Proyecto>>
            ) {
                Log.d("Red", "Llegaron los proyectos")

                val misProyectos = response.body()

                misProyectos?.forEach {
                    proyectos.add(it)
                }
                //.results?.let { proyectos.addAll(it) }
                adapter.notifyItemInserted(proyectos.size - 1)
            }

        })
    }

}
