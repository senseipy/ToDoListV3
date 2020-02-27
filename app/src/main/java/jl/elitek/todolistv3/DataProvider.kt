package jl.elitek.todolistv3

import jl.elitek.todolistv3.models.Persona

object DataProvider {
    // en caso de que el usuario que ingreso sea el administrador
    var admin:Persona?
        get() {
            TODO()
        }
        set(value) {
            admin = value
        }
    // en caso de que el usuario que ingreso sea el usuario normal
    var usuario:Persona?
        get() {
            TODO()
        }
        set(value) {}
}