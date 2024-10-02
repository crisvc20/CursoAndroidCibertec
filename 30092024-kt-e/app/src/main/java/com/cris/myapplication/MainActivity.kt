package com.cris.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cris.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAction.setOnClickListener {
            //Muestra el show flotante del texto generado al ingresar datos en este caso Cris: 20
            val textToShow = "${binding.etNombre.text}: ${binding.etEp1.text}"
            //comentó esto a raiz de hacer la prueba con los radio button
            //se copia para ser ejecutada en la clase Utils
            //Toast.makeText(this,textToShow,Toast.LENGTH_LONG).show()
            //se agrega este codigo para interactuar con el toast de la clase Utils
            Utils.showToast(this@MainActivity, textToShow)

            //Para los check
            var ep1: Int = binding.etEp1.text.toString().toInt()
            if(binding.rbAdd.isChecked){
                ep1 += 1
            }

            //Para ir a la vista Destino
            val newView = Intent(this, Destino::class.java)
            //luego se agregó este extra
            newView.putExtra("nombre", "${binding.etNombre.text}")
            //ya no le va a pasar este campo porque puede ser que este marcado como q no
            //newView.putExtra("ep1", "${binding.etEp1.text}")
            newView.putExtra("ep1", "$ep1")
            newView.putExtra("ep2", "${binding.etEp2.text}")
            //Enviar el disparador
            startActivity(newView)
        }
    }
}