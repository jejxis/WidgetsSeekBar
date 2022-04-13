package com.example.widgetsprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.widgetsprogressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        thread(start=true){//서브 스레드
            Thread.sleep(3000)
            runOnUiThread { showProgress(false) }//메인 스레드
        }
    }
    fun showProgress(show: Boolean){
        binding.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
    }
}