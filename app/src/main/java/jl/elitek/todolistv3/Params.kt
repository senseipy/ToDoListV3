package jl.elitek.todolistv3

import jl.elitek.todolistv3.models.Persona


class Params {
    companion object{
        val BASE_URL = "https://7706ae66.ngrok.io/tdlpp_rest/api/"
        private lateinit var persona: Persona

        fun setPersona(pers:Persona){
            persona = pers
        }

        fun getPersona() = persona
    }

}