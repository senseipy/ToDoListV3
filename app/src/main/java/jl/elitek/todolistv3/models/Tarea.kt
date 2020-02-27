package jl.elitek.todolistv3.models

data class Tarea (
    var actividadId: Actividad,
    var estado: String,
    var nombre: String,
    var responsableId:Persona,
    var tareaId: Int
// FALTA INDICAR EL RESPONSABLE
)