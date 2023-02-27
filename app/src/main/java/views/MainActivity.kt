package com.pedro.guardianinit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pedro.guardianinit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addDevice.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.add_device) {
            startActivity(Intent(this, RecorderActivity::class.java))
        }
    }
}
