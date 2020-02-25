package jl.elitek.todolistplus2.models

data class Actividad (
    var id: Int,
    var proyecto_id: Int,
    var nombre: String,
    var fecha_programada: String,
    var fecha_inicio: String,
    var fecha_fin: String,
    var fecha_limite: String,
    var progreso: Int,
    var comentarios: String,
    var responsable_id: String
)