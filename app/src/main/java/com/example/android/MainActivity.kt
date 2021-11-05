package com.example.android

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.android.databinding.ActivityMainBinding
import kotlin.concurrent.thread
const val CURRENT_COUNT = "current count"
const val HELLO = "hello"
class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun showToast(view: View) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG).show()
        //Thread.sleep(3000)
        Intent(this, SecondActivity::class.java).apply {
            putExtra(CURRENT_COUNT, mCount.toString())
            putExtra(HELLO, "Hello!")
            startActivity(this)
        }
    }

    fun countUp(view: View) {
        mCount++
        binding.showCount.text = mCount.toString()
        if (mCount % 2 == 0) {
            binding.buttonCount.setBackgroundColor(getColor(R.color.red))
        } else {
            binding.buttonCount.setBackgroundColor(getColor(R.color.green))
        }
        binding.buttonZero.setBackgroundColor(getColor(R.color.pink))
    }

    fun setZero(view: View) {
        binding.buttonZero.setBackgroundColor(getColor(R.color.gray))
        mCount = 0
        binding.showCount.text = mCount.toString()
    }
}