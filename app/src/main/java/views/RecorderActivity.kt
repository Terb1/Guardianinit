package com.pedro.guardianinit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pedro.guardianinit.databinding.ActivityRecorderRegisterBinding

class RecorderActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRecorderRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecorderRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.PostDevice.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.Post_device) {
            showinfo()
        }
    }

        fun isvalid(): Boolean {
            val getname = binding.inputDeviceUser.text.toString().trim()
            val getserial = binding.inputDeviceSerial.text.toString().uppercase()
            val getuser = binding.inputDeviceUser.text.toString()
            val getpassword = binding.inputDevicePassword.text.toString()
            return (!getname.isEmpty() && !getserial.isEmpty() && !getuser.isEmpty() && !getpassword.isEmpty())
        }

        fun showinfo() {
            if (isvalid()) {
                Toast.makeText(this, "Dispositivo cadastrado com sucesso", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }

    }