package jl.elitek.todolistplus2.models

data class Tarea (
    var tarea_id: Int,
    var nombre: String,
    var fecha_programada: String,
    var fecha_inicio: String,
    var fecha_fin: String,
    var fecha_limite: String,
    var comentarios: String,
    var estado: String
// FALTA INDICAR EL RESPONSABLE
)