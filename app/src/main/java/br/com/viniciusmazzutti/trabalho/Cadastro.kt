package br.com.viniciusmazzutti.trabalho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.viniciusmazzutti.trabalho.databinding.ActivityCadastroBinding
import br.com.viniciusmazzutti.trabalho.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Cadastro : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.btCadastro.setOnClickListener {
            val email: String = binding.editEmail.text.toString()
            val senha: String = binding.editSenha.text.toString()
            val senha2: String = binding.editSenha2.text.toString()

           if (email.isNotEmpty() && senha.isEmpty() && senha2.isEmpty()){
               if(senha == senha2){
                   createUserWithEmailAndPassoword(email, senha)
               }else{
                   Toast.makeText(this@Cadastro, "Senha incompativel ", Toast.LENGTH_SHORT).show()
               }
           }else{
               Toast.makeText(this@Cadastro, "Por favor preencha os campos vazios", Toast.LENGTH_SHORT).show()
           }

        }

    }


    private fun createUserWithEmailAndPassoword(email: String, senha:String) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Log.d(TAG,"Conta criada com sucesso")
              //  val user = auth.currentUser
                navegarTelaLogin()
            }else{
                Log.w(TAG,"Erro de autenticação")
            }
        }
    }
    companion object{
        private  var TAG = "EmailAndPassword"
    }

    private fun navegarTelaLogin(){
        val intent = Intent(this@Cadastro, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}