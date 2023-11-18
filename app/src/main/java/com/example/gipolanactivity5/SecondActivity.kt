package com.example.gipolanactivity5

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        val btnCamera = findViewById<Button>(R.id.btnCamera)
        val btnLocation = findViewById<Button>(R.id.btnLocation)
        val btnStorage = findViewById<Button>(R.id.btnStorage)
        btnCamera.setOnClickListener {
            requestPermission(
                Manifest.permission.CAMERA,
                CAMERA_PERMISSION_REQUEST
            )
        }
        btnLocation.setOnClickListener {
            requestPermission(
                Manifest.permission.ACCESS_FINE_LOCATION,
                LOCATION_PERMISSION_REQUEST
            )
        }
        btnStorage.setOnClickListener {
            requestPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                STORAGE_PERMISSION_REQUEST
            )
        }
    }

    private fun requestPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            showToast("Permission already granted")
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showToast("Permission granted")
        } else {
            showToast("Permission denied")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val CAMERA_PERMISSION_REQUEST = 1
        private const val LOCATION_PERMISSION_REQUEST = 2
        private const val STORAGE_PERMISSION_REQUEST = 3
    }
}
