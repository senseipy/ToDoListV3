package jl.elitek.todolistv3.models

data class Actividad (
    var actividadId: Int,
    var nombre: String,
    var progreso: Int,
    var proyecto_id: Proyecto
)