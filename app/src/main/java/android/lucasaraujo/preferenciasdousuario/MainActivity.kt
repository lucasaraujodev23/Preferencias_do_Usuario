package android.lucasaraujo.preferenciasdousuario

import android.graphics.Color
import android.lucasaraujo.preferenciasdousuario.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    companion object {
        const val NOME_ARQUIVO = "arquivo.prefs.xml"
    }

    private var cor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()
        window.statusBarColor = Color.WHITE
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.cor1.setOnClickListener() {
            cor = "#D70000"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
        binding.cor2.setOnClickListener() {
            cor = "#3F51B5"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
        binding.cor3.setOnClickListener() {
            cor = "#4CAF50"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
        binding.cor4.setOnClickListener() {
            cor = "#E300FB"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
        binding.cor5.setOnClickListener() {
            cor = "#FFE500"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

    }

    override fun onResume() {
        super.onResume()

        val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val cor = preferencias.getString("cor", "")

        if(cor!!.isNotEmpty()){
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }

    private fun salvarCor(cor: String) {

        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        binding.btnTrocar.setOnClickListener {
            val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.putString("nome", "Lucas")
            editor.putString("sobrenome", "Araujo")
            editor.putInt("idade", 18)
            editor.apply()
        }

        Toast.makeText(this, "Cor salva no arquivo cores", Toast.LENGTH_LONG).show()
    }

    private fun snackBar(view: View) {
        val snackbar = Snackbar.make(view, "Cor de fundo alterada com sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK"){

        }

        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()
    }
}