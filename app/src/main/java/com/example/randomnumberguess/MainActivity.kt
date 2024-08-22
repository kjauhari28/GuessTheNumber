package com.example.randomnumberguess

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.randomnumberguess.ui.theme.RandomNumberGuessTheme
import kotlin.random.Random.Default.nextInt


class MainActivity : ComponentActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset: ImageButton
    lateinit var imageButtonCheck: ImageButton

    var random: Int =  nextInt(from=1, 100)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageButtonReset = findViewById(R.id.imageButtonReset)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)

        textView.text = "Guess the number: "

        imageButtonCheck.setOnClickListener {
            val number: Int = editText.text.toString().toInt()

            if (number < random) {
                textView.text = "Guess a bit higher"
                editText.text.clear()
            } else if (number > random) {
                textView.text = "Guess a bit lower"
                editText.text.clear()
            } else {
                textView.text = " Congratulations! \nYour guess is right"
                editText.text.clear()
            }
        }

        imageButtonReset.setOnClickListener {

                reset()
        }
    }


    fun reset(){
        random = nextInt(1, 100)
        textView.text = "Guess the number: "
        editText.text.clear()
    }

}

