package jl.elitek.todolistv3.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jl.elitek.todolistv3.R
import jl.elitek.todolistv3.models.Proyecto
import kotlinx.android.synthetic.main.item_proyecto.view.*


class ListaProyectosAdapter (val context: Context, val proyectos: ArrayList<Proyecto>
): RecyclerView.Adapter<ListaProyectosAdapter.ProyectoHolder>() {

    // 1. Inicializamos el ViewHolder pasandole el layout que el adaptor usará para crear las vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProyectoHolder {
        val view =
            LayoutInflater
                .from(context).inflate(R.layout.item_proyecto, parent, false)
        return ProyectoHolder(view)
    }

    // EL adaptador sabe cuantas peliculas hay
    override fun getItemCount() = proyectos.size

    // Este metodo se usa para configurar el contenido de las vistas en la posicion "position"
    override fun onBindViewHolder(holder: ProyectoHolder, position: Int) {
        val proyecto = proyectos[position]
        holder.bindProyecto(proyecto)
    }

    // El siguiente paso será bajar la librería para mostrar fotos
    class ProyectoHolder(val v: View): RecyclerView.ViewHolder(v) {
        companion object {
            val imageUrlBase = "https://image.tmdb.org/t/p/w500"
        }

        fun bindProyecto(proyecto: Proyecto) {
            v.item_proyecto_nombre.text = proyecto.nombre
            v.item_proyecto_resumen.text = proyecto.comentarios
            v.item_proyecto_vencimiento.text = proyecto.fecha_limite
            v.item_proyecto_inicio.text = proyecto.fecha_inicio
            v.item_proyecto_estado_tv.text = proyecto.estado
            v.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Log.d("RED","Click! "+proyecto.nombre)

                }
            })


        }

        fun verDetalles(){

        }
    }
}