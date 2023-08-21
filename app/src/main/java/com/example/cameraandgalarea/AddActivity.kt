package com.example.cameraandgalarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.cameraandgalarea.databinding.ActivityAddBinding
import com.example.cameraandgalarea.db.MyDbHelper1
import com.example.cameraandgalarea.models.MyImage
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setOnClickListener {
            getImageContent.launch("image/*")
        }
        binding.btnSave.setOnClickListener {
            if (absalyutPath != "") {
                if (binding.edtName.text.isNotBlank()) {
                    MyDbHelper1(this).addImage(
                        MyImage(
                            binding.edtName.text.toString(),
                            absalyutPath
                        )
                    )
                    Toast.makeText(this, "saqlandi", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "nom berilmadi", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "rasm berilmadi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    var absalyutPath = ""
    private val getImageContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        it ?: return@registerForActivityResult
        binding.imageView.setImageURI(it)
        val name = SimpleDateFormat("dd.MM.yyyy hh.mm.ss").format(Date())
        //filega saqlash
        val inputStream = contentResolver.openInputStream(it)
        val file = File(filesDir, "$name.jpg")
        val fileOutputStream = FileOutputStream(file)
        inputStream?.copyTo(fileOutputStream)
        inputStream?.close()
        fileOutputStream?.close()

        absalyutPath = file.absolutePath
    }
}