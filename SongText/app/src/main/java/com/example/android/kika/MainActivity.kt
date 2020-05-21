package com.example.android.kika

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.kika.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_activity.view.*
import kotlinx.android.synthetic.main.main_activity.view.intro_text

private lateinit var binding: MainActivityBinding

private val song: Song = Song("U drive my for Wheel coffin")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.main_activity)
        //binding.song = song
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.main_activity, null, false)
        setContentView(binding.root)

            //findViewById<Button>(R.id.done_button).setOnClickListener{ addSongName(it) }
        binding.doneButton.setOnClickListener { addSongName(it) }
    }

    private fun addSongName(view: View){
        binding.apply {
            //song?.intro = intro_text.text.toString()
            intro_text.text = introEdit.text
            invalidateAll()
            introEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            intro_text.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
