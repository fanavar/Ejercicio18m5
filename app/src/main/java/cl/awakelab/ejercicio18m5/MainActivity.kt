package cl.awakelab.ejercicio18m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.awakelab.ejercicio18m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener{
            var texto = binding.ingresarTexto.text.toString()
            var entero = binding.valorEntero.text.toString().toInt()
            var decimal = binding.ingresarDecimal.text.toString().toDouble()
            var switch = binding.switch1.isChecked
        }

        binding.btnBorrar.setOnClickListener{

        }
    }
}