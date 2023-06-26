package com.example.firestorecrud.util

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel(): ViewModel() {

    // Writing Data
    fun saveData(
        user: UserData,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {
        val db = Firebase.firestore
            .collection("user")
            .document(user.userId)

        try {
            db.set(user)
                .addOnSuccessListener {
                    Toast.makeText(context, "Data Saved!!!", Toast.LENGTH_SHORT).show()
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    // Retrieving Data
    fun retrieveData(
        userID: String,
        context: Context,
        data: (UserData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {
        val db = Firebase.firestore
            .collection("user")
            .document(userID)

        try {
            db.get().addOnSuccessListener {
                if(it.exists()) {
                    val userData = it.toObject<UserData>()!!
                    data(userData)
                }
                else {
                    Toast.makeText(context, "No User Data Found", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    // Deleting Data
    fun deleteData(
        userID: String,
        context: Context,
        navController: NavController,
    ) = CoroutineScope(Dispatchers.IO).launch {
        val db = Firebase.firestore
            .collection("user")
            .document(userID)

        try {
            db.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Deletion Done!!!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

}