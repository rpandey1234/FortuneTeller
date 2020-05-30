package edu.stanford.rkpandey.fortuneteller

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private val answers = listOf(
            "Ask again later.",
            "Very doubtful.",
            "It is certain.",
            "Reply hazy, try again.",
            "Concentrate and ask again.",
            "Ask your parents.",
            "Depends on how hard you work!",
            "Look inside yourself.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAnswer.setOnClickListener {
            Log.i(TAG, "btnAnswer click")
            tvAnswer.text = answers.random()
            hideSoftKeyBoard()
        }
    }

    private fun hideSoftKeyBoard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isAcceptingText) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }
}
