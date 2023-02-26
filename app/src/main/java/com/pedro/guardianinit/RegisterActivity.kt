package com.pedro.guardianinit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pedro.guardianinit.databinding.ActivityDeviceRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDeviceRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeviceRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // binding.backbuttom.setOnClickListener(this)
        binding.PostDevice.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.Post_device) {
            showinfo()
        }
    }

 /*   fun backbuttom(v: View) {
        if (v.id == R.id.backbuttom) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    */

    fun isvalid(): Boolean {
        val getname = binding.inputDeviceUser.text.toString().trim()
        val getserial = binding.inputDeviceSerial.text.toString().uppercase()
        val getmac = binding.inputDeviceMac.text.toString().uppercase()
        val gettcport = binding.inputDevicePort.text.toString().toIntOrNull()
        val getuser = binding.inputDeviceUser.text.toString()
        val getpassword = binding.inputDevicePassword.text.toString()
        return (!getname.isEmpty() && !getserial.isEmpty() && !getmac.isEmpty()
                && gettcport != null && (gettcport > 1024 && gettcport < 65535) && !getuser.isEmpty() && !getpassword.isEmpty())
    }

    fun showinfo() {
        if (isvalid()) {
            Toast.makeText(this, "Dispositivo cadastrado com sucesso", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "preencha todos os campos", Toast.LENGTH_LONG).show()
        }
    }

    fun catch() {
        if (isvalid()) {
            val getname = binding.inputDeviceUser.text.toString().trim()
            print(getname)
        }
    }
}