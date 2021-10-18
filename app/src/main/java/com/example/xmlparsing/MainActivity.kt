package com.example.xmlparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain: RecyclerView
    private lateinit var students: List<Students>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val parser = MyXmlPullParserHandler()
            val stream = assets.open("StudentDetails.xml")
            students = parser.parse(stream)
            rvMain = findViewById(R.id.rvMain)
            rvMain.adapter = RVAdapter(students)
            rvMain.layoutManager = LinearLayoutManager(this)


        } catch (e: IOException) {
            print("ISSUE: $e")
        }

    }
}