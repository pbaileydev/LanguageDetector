package com.pbaileyapps.languagedetector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.mlkit.nl.languageid.LanguageIdentification

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById(R.id.editText)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener({
            if(!editText.text.isEmpty()){
                val languageIdentifier = LanguageIdentification.getClient()
                languageIdentifier.identifyLanguage(editText.text.toString())
                    .addOnSuccessListener { languageCode ->
                        if (languageCode == "und") {
                            textView.setText("Language not detected.")
                        } else {
                            textView.setText(languageCode)
                        }
                    }
                    .addOnFailureListener {
                        textView.setText("Error")
                    }
            }
        })
    }
}