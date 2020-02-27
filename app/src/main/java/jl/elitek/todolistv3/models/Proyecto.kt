package jl.elitek.todolistv3.models

data class Proyecto(
    val id:Int,
var nombre:String,
var fecha_inicio: String,
var fecha_limite: String,
    var fecha_fin: String,
var progreso:Int,
var estado: String,
var comentarios: String,
    var dueno_id: Int
)