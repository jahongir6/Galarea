package com.example.cameraandgalarea.db

import com.example.cameraandgalarea.models.MyImage

interface MyDbInterfase {
    fun addImage(myImage: MyImage)
    fun getAllImage():ArrayList<MyImage>
}