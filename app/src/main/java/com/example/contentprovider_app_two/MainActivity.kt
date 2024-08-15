package com.example.contentprovider_app_two

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val values = ContentValues()
        values.put("id",32015695)
        values.put("title","Android april 2024")
        values.put("price","000000")

        var newUri = contentResolver.insert(
            Uri.withAppendedPath(
                Uri.parse(
                    "content://in.bitcode.products"),
                    "products"
                ),
                values
            )
        Log.e("tag","$newUri")

        if (newUri != null){
            var cursor = contentResolver.query(
                newUri,null,null,null,null)

            while (cursor!!.moveToNext()==true){
                Log.e("tag","id -- ${cursor.getInt(0)}" + "title -- ${cursor.getString(1)}"+ "price -- ${cursor.getInt(2)}")
            }
            cursor.close()
        }
    }
}