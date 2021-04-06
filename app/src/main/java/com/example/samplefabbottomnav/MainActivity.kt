package com.example.samplefabbottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.background = null
        bottomNav.menu.getItem(2).isEnabled = false // Number Cant be clicked in array


        // FAB
        val btnFAB: FloatingActionButton = findViewById(R.id.btn_fab)
        val btnFABSecond: FloatingActionButton = findViewById(R.id.btn_fab_second)
        val btnFABThird: FloatingActionButton = findViewById(R.id.btn_fab_third)

        //
        btnFAB.setOnClickListener {
            onAddButtonClicked()
        }

        btnFABSecond.setOnClickListener {
            Toast.makeText(this, "Sample FAB 2 had been clicked", Toast.LENGTH_SHORT).show()


        }

        btnFABThird.setOnClickListener {
            Toast.makeText(this, "Sample FAB 3 had been clicked", Toast.LENGTH_SHORT).show()
        }
    }

    //
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom) }

    //
    private var clicked = false


    // Sample Extended
    private fun onAddButtonClicked()
    {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)

        // set value to another function to become false
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean)
    {
        val btnFAB: FloatingActionButton = findViewById(R.id.btn_fab)
        val btnFABSecond: FloatingActionButton = findViewById(R.id.btn_fab_second)
        val btnFABThird: FloatingActionButton = findViewById(R.id.btn_fab_third)


        if (!clicked)
        {
            btnFABSecond.startAnimation(fromBottom)
            btnFABThird.startAnimation(fromBottom)

            btnFAB.startAnimation(rotateOpen)

        }

        else
        {
            btnFABSecond.startAnimation(toBottom)
            btnFABThird.startAnimation(toBottom)

            btnFAB.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean)
    {
        val btnFABSecond: FloatingActionButton = findViewById(R.id.btn_fab_second)
        val btnFABThird: FloatingActionButton = findViewById(R.id.btn_fab_third)

        if (!clicked)
        {
            btnFABSecond.visibility = View.VISIBLE
            btnFABThird.visibility = View.VISIBLE
        }

        else
        {
            btnFABSecond.visibility = View.INVISIBLE
            btnFABThird.visibility = View.INVISIBLE
        }
    }

    private fun setClickable(clicked: Boolean)
    {
        val btnFABSecond: FloatingActionButton = findViewById(R.id.btn_fab_second)
        val btnFABThird: FloatingActionButton = findViewById(R.id.btn_fab_third)

        if (!clicked)
        {
            btnFABSecond.isClickable = true
            btnFABThird.isClickable = true
        }

        else
        {
            btnFABSecond.isClickable = false
            btnFABThird.isClickable = false
        }
    }
}