package com.example.android.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        val clickableViews: List<View> =
            listOf(boxe_one_text, bow_two_text, box_three_text,
                box_four_text, box_five_text,
                red_button, green_button)

        for(box in clickableViews){
            box.setOnClickListener{makeColored(it)}
        }
    }

    fun makeColored(view: View) {
        when (view.id) {
            // Boxes using Color class colors for background
            R.id.boxe_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.bow_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text  -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> box_three_text.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.yellow_button -> box_four_text.setBackgroundResource(android.R.color.holo_orange_light)
            R.id.green_button -> box_five_text.setBackgroundResource(android.R.color.holo_blue_dark)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}