package edu.neo.myapplication.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import edu.neo.myapplication.model.User

class UserViewModel: ViewModel() {

    var usuario: String = ""
    var usarList: ArrayList<User> = ArrayList()

    fun validateUser(user:User):Boolean{
        return (user.username.equals("user")&& user.password.equals("pass"))

    }

    fun validarUser(user:User): Boolean {
        usarList.forEach({
            if(it.username.equals(user.username)&& it.password.equals(user.password))
                return true
        })
        return false
    }

    fun saveUser(username:String,password:String){
        usarList.add(User(username,password))
    }
}