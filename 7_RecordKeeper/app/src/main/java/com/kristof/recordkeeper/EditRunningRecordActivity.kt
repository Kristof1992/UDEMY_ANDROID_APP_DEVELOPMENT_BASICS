package com.kristof.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kristof.recordkeeper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditRunningRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val distance = intent.getSerializableExtra("Distance")
        title = "$distance Record"
    }
}