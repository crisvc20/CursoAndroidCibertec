package com.cris.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var num1:Int = 10
    var num2:Int = 20
    var resultado:Int = 0
    /* (?) es para recibir valores nulos */
    var aux:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //resultado = num1 + num2
        resultado = sumar(num1, num2)
        Log.v("Resultado", resultado.toString())
        Log.d("Resultado", resultado.toString())
        Log.i("Resultado", resultado.toString())
        /* "$variable" tambien se puede poner asi para string */
        /* "${variable}" para arrays */
        Log.w("Resultado", "$resultado")
        Log.e("Resultado", "$resultado")
        Log.wtf("Resultado", "$resultado")
        crearLog()
        callBackFun {
            Log.wtf("No se", "Ejecutando")
        }

        callBackFunTwo(
            { Log.wtf("FirstAction", "Primera acción ejecutada") },
            { Log.wtf("SecondAction", "Segunda acción ejecutada") }
        )
        //if else
        if(num2 < 30){
            crearLogConMsg("Es menor")
        }else{
            crearLogConMsg("Es mayor")
        }

        if(num2 < 30)crearLogConMsg("Es menor") else crearLogConMsg("Es mayor")

        //when
        when(num1){
            in 1..5 -> crearLogConMsg("Es menor que 6")
            6 -> crearLogConMsg("Es igual a 6")
            in 7..20 -> crearLogConMsg("Es mayor que 6")
            else -> crearLogConMsg("Ingresó al else")
        }

        //for
        for (i in 1..10) {
            crearLogConMsg("$i")
        }

        //for con lista
        val nombres = listOf("Ana", "Juan", "Luis")
        for (nombre in nombres){
            crearLogConMsg("$nombre")
        }

        //for con indice
        for ((index, nombre) in nombres.withIndex()){
            crearLogConMsg("$index - $nombre")
        }

        //while
        var contador = 1
        while(contador <= 5){
            crearLogConMsg("$contador")
            contador++
        }

        //do while
        var contador2 = 0
        do{
            crearLogConMsg("$contador2")
            contador2++
        }while(contador2 > 5)

        val kia = Carro(4, "Picanto", 2)
        crearLogConMsg("${kia.antigue}")
        kia.agregarAnios()
        crearLogConMsg("${kia.antigue}")
        //val nissan = Carro(6,10,"modelo1")

        /* Scope functions */
        //let para evitar valores nulos
        val profesor: String? = "Cris"
        //al agregar nomProfesor -> se renombra el (it) que viene por defecto en el app
        val androidProfesor = profesor?.let { nomProfesor ->
            crearLogConMsg(nomProfesor)
            //crearLogConMsg(it)
        }
        //run
        val jeep = Carro(4, "Jeep", 20).run {
            for (i in 1..5) {
                agregarAnios() // Llama a agregarAnios() en el objeto Carro
            }
            crearLogConMsg(antigue.toString()) // Crea un log con la antigüedad del carro
            /*
            La función run retorna el resultado del último valor dentro del bloque.
            En tu caso, si crearLogConMsg devuelve algo, eso será asignado a la variable jeep
            */
            /*
            Si no se usara run seria algo asi (sin for):
            val jeep = Carro(4, "Jeep", 20)
            jeep.agregarAnios()
            jeep.agregarAnios()
            jeep.agregarAnios()
            jeep.agregarAnios()
            jeep.agregarAnios()
            jeep.crearLogConMsg(jeep.antigue.toString())
            */
        }

       


    }
    //Cuando no retorna nada se pone Unit (como void en java)
    fun crearLog(): Unit{
        Log.e("Error", "Error desde función")
    }

    fun crearLogConMsg(mensaje: String): Unit{
        Log.e("Error", mensaje)
    }

    fun sumar(a:Int, b:Int):Int{
        return a + b
    }

    fun callBackFun(action: () -> Unit){
        Log.d("callBackFun", "callBackFun")
        action()
    }

    fun callBackFunTwo(firstAction: () -> Unit, secondAction: () -> Unit){
        firstAction() // Ejecuta la primera función pasada como parámetro
        Log.d("callBackFun", "callBackFun") // Imprime un mensaje en el log
        secondAction() // Ejecuta la segunda función pasada como parámetro
    }




}