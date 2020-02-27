package jl.elitek.todolistv3.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import jl.elitek.todolistv3.DataProvider
import jl.elitek.todolistv3.R
import jl.elitek.todolistv3.sharedViewModels.SharedViewModel

import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var sharedViewModel: SharedViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProvider(this).get(LoginViewModel::class.java)
        }?:throw Exception("Invalid Activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = activity?.run {
            ViewModelProvider(this).get(SharedViewModel::class.java)
        }?:throw Exception("Invalid Activity")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("MSG","onActivity Created")
        /*activity?.run {
            ViewModelProviders.of(this)[SharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity") */
        //viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // observar la respuesta
        viewModel.observableUsuario.observe(
            viewLifecycleOwner,
            Observer { persona->
                when (persona.rol){
                    "A" -> {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToListaProyectosFragment())
                       // DataProvider.admin = persona
                        sharedViewModel.persona.value = persona
                        }
                    "U" -> {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToListaTareasFragment())
                      //  DataProvider.admin = null
                        }
                    else -> Toast.makeText(context, "No se reconoce",Toast.LENGTH_LONG).show()
                }

            }
        )

        // TODO: Use the ViewModel
        login_fg_button_ingresar.setOnClickListener {
            ingresarSistema()
        }
    }

    fun ingresarSistema(){
        val usr = login_fg_usuario.text.toString()
        val pass = login_fg_TIET_password.text.toString()
        viewModel.ingresar(usr, pass)
    }
    // TODO: Implement the ViewModel




}
