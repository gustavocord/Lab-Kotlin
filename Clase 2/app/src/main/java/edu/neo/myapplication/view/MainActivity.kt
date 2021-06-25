package edu.neo.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import edu.neo.myapplication.R
import edu.neo.myapplication.model.User
import edu.neo.myapplication.viewmodel.UserViewModel
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    lateinit var user:EditText
    lateinit var pass:EditText
    lateinit var registrar:Button
    lateinit var login:Button
    lateinit var olvido:Button
    lateinit var frameRegistrar:FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializador()

        val userVM = ViewModelProvider(this).get(UserViewModel::class.java)


        login.setOnClickListener {
            var u:User?= User(user.text.toString(),pass.text.toString())
            u = u?.let{ it1 -> userVM.validarUser(it1)}

            if (u != null){

                val intent:Intent = Intent(this,InicioActivity::class.java)
                intent.putExtra("user",u)
                startActivity(intent)}
            else
                Toast.makeText(this,"usuario invalido",Toast.LENGTH_LONG).show()

        }
        registrar.setOnClickListener {
            val viewRegistrar: View = LayoutInflater.from(this).inflate(R.layout.registrar_layout,null,false)

            var userR : EditText = viewRegistrar.findViewById(R.id.r_user)
            var passR : EditText = viewRegistrar.findViewById(R.id.r_pass)
            var saveR : Button = viewRegistrar.findViewById(R.id.r_save)

            saveR.setOnClickListener {
                userVM.saveUser(userR.text.toString(),passR.text.toString())
                Toast.makeText(viewRegistrar.context,"usuario guardado",Toast.LENGTH_SHORT).show()
                frameRegistrar.removeAllViews()
            }

            frameRegistrar.addView(viewRegistrar)

        }




    }





    fun inicializador(){
        user = findViewById(R.id.t_usuario)
        pass = findViewById(R.id.t_pass)
        registrar = findViewById(R.id.b_register)
        login = findViewById(R.id.b_login)
        olvido = findViewById(R.id.b_restore)
        frameRegistrar=findViewById(R.id.f_registrar)
    }
}