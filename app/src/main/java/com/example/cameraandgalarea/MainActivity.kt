package com.example.cameraandgalarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.cameraandgalarea.adapters.ImageAdapter
import com.example.cameraandgalarea.databinding.ActivityMainBinding
import com.example.cameraandgalarea.db.MyDbHelper1
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myDbHelper1: MyDbHelper1
    private lateinit var imageAdapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        myDbHelper1 = MyDbHelper1(this)
        imageAdapter = ImageAdapter(myDbHelper1.getAllImage())
        binding.rv.adapter = imageAdapter
    }
}