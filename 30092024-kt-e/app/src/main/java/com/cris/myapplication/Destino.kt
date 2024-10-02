package com.cris.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cris.myapplication.databinding.ActivityDestinoBinding
import com.cris.myapplication.databinding.ActivityMainBinding

class Destino : AppCompatActivity() {

    private lateinit var binding: ActivityDestinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_destino)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //intent en minuscula porque es un get set, recibimos el extra
        val nombre = intent.getStringExtra("nombre")?: "no hay data"
        val ep1 = intent.getStringExtra("ep1")?: "no hay data"
        //se agregó ep2
        val ep2 = intent.getStringExtra("ep2")?: "no hay ep2"

        //cambió
        //binding.txtResultado.text = "$nombre: $ep1"
        binding.txtResultado.text = "$nombre \n EP1: $ep1 \n EP2: $ep2"

    }
}