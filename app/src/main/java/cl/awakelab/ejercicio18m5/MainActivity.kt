package cl.awakelab.ejercicio18m5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.awakelab.ejercicio18m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSharedPreferences = getSharedPreferences("cookie", Context.MODE_PRIVATE)
        binding.btnGuardar.setOnClickListener{
            var texto = binding.ingresarTexto.text.toString()
            var entero = binding.valorEntero.text.toString().toInt()
            var decimal = binding.ingresarDecimal.text.toString().toFloat()
            var boleano = binding.switch1.isChecked

            guardarDatos(texto, entero, decimal, boleano)
        }
        binding.btnMostrar.setOnClickListener{
            mostrarDatos()
        }
        binding.btnBorrar.setOnClickListener{
            borrarDatos()
        }
    }
    private fun guardarDatos(texto: String, entero: Int, decimal: Float, boleano: Boolean){
        mSharedPreferences.edit().putString("miTexto", texto).apply()
        mSharedPreferences.edit().putInt("miEntero", entero).apply()
        mSharedPreferences.edit().putFloat("miTexto", decimal).apply()
        mSharedPreferences.edit().putBoolean("miBooleano", boleano).apply()
    }

    private fun mostrarDatos() {
        val texto = mSharedPreferences.getString("miTexto", "")
        val entero = mSharedPreferences.getInt("miEntero", 0)
        val decimal = mSharedPreferences.getFloat("miDecimal", 0.0f)
        val boleano = mSharedPreferences.getBoolean("miBooleano", false)

        binding.textoAlmacenado.text = texto
        binding.valorEntero.text = entero.toString()
        binding.valorDecimal.text = decimal.toString()
        binding.txSwicht.text = boleano.toString()

        binding.switch1.isChecked = boleano
    }
    private fun borrarDatos(){
        binding.textoAlmacenado.text = ""
        binding.valorEntero.text = ""
        binding.valorDecimal.text = ""
        binding.txSwicht.text = ""

        binding.ingresarTexto.text.clear()
        binding.ingresarDecimal.text.clear()
        binding.ingresarNumero.text.clear()
        binding.switch1.isChecked = false

        mSharedPreferences.edit().clear().apply()
    }
}