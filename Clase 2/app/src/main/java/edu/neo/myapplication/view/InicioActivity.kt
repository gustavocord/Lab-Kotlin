package edu.neo.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.neo.myapplication.R
import edu.neo.myapplication.model.User

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var user: User = intent.getSerializableExtra("user") as User

        Toast.makeText(this,"hola "+ user.username,Toast.LENGTH_SHORT).show()
    }
}