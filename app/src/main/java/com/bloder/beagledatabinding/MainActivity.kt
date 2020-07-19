package com.bloder.beagledatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.zup.beagle.android.components.Text
import br.com.zup.beagle.android.components.layout.Container
import br.com.zup.beagle.android.components.layout.Screen
import com.bloder.beagledatabinding.databinding.ActivityMainBinding
import com.bloder.interpreter.toBeagle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
        val beagleView = binding.toBeagle()
        /**
        Screen(
            child = Container(children = listOf(
                Text(text = "Hello World!"),
                Text(text = "Hello World!")
            ))
        )
        **/
        setContentView(R.layout.activity_main)
    }
}