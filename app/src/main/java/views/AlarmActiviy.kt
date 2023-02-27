package views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pedro.guardianinit.R
import com.pedro.guardianinit.databinding.ActivityAlarmActiviyBinding
import models.Alarm
import models.Recorder

class AlarmActiviy : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAlarmActiviyBinding
    var newalarm: Alarm = Alarm("", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.PostDevice.setOnClickListener(this)
        binding.deviceTypo1.setOnClickListener(this)

    }


    override fun onClick(v: View) {
        if (v.id == R.id.Post_device) {
            showinfo()
        }
        if (v.id == R.id.device_typo1) {
            startActivity(Intent(this, RecorderActivity::class.java))
        }
    }


    fun isvalid(): Boolean {
        val getname = binding.inputDeviceName.text.toString().trim()
        val getmac = binding.inputeAlarmMac.text.toString().uppercase()
        val getpassword = binding.inputDevicePassword.text.toString()
        return (!getname.isEmpty() && !getmac.isEmpty() && !getpassword.isEmpty())
    }


    fun showinfo() {
        if (isvalid()) {
            Toast.makeText(this, "Dispositivo cadastrado com sucesso", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "preencha todos os campos", Toast.LENGTH_LONG).show()
        }
    }


/*
    fun newrecorder() {
        if (isvalid()) {
            newalarm.name = getname
            newalarm.macAddres = getmac
            newalarm.password = getpassword
            apis.RequestService.RetrofitService.retrofitService!!.postrecorder(
                body = Alarm(),
                token = (apis.auth.USER_TOKEN)
            )
        }
    }
    */
}