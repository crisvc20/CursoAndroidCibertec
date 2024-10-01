package com.cris.myapplication

//generalmente no se va a trabajar asi, pero es para conocimiento
class Carro(val llantas:Int, val modelo:String, var antigue:Int) {
    constructor(llantas: Int, antigue: Int, modelo: String):this(llantas, modelo, antigue)

    fun agregarAnios(){
        antigue++
    }
}