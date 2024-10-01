package com.cris.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cris.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //agrega variable privada (solo para uso de la clase MainActivity)
    /*
     al haberle agregado al build.gradle.kts
     viewBinding {
        enable = true
    }
    hace que ActivityMainBinding se crea
    y tambien estara para ActivityDestinoBinding en caso de desee utilizar
    */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //agregando datos a la variable binding
        //una vez que tengamos la vista hay que inflarla
        binding = ActivityMainBinding.inflate(layoutInflater) //inflando el ActivityMainBinding

        enableEdgeToEdge()

        //setContentView(R.layout.activity_main) //al clicar envia al activity_main
        //reemplazando
        //y es para que no muestre la vista activity_main
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("EjercicioKT", "onCreate")

        /* evento clic kt */
        /* lo referente a los cambios agregados arriba es para evitarnos la variable button, el findviewbyid que se hizo en java*/
        /* con esto ya accedimos al boton */
        /* con esto ya tenemos el clic */
        /* en kotlin hay dos tipos de declaracion de variables */
        /* el val q nunca cambie y el var si */
        binding.btnMove.setOnClickListener {
            //En este caso ya no se hace el new
            //Hay algunas cosas que se mantienen como los ::class.java
            val intent = Intent(this, Destino::class.java)
            startActivity(intent)
        }

        binding.txtHola.text = "Soy nuevo en KT"

    }

    override fun onResume() {
        super.onResume()
        Log.d("EjercicioKT", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("EjercicioKT", "onPause")
    }

    override fun onStart() {
        super.onStart()
        Log.d("EjercicioKT", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("EjercicioKT", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("EjercicioKT", "onDestroy")
    }


}