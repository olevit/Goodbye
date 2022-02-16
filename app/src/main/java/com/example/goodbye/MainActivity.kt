package com.example.goodbye

import android.content.Context
import android.content.QuickViewConstants
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences
    private var counter: Int = 0
    private var counterCats: Int = 0
    private val APP_PREFERENCES_COUNTER_CAT = "counterCat"
    private val APP_PREFERENCES_COUNTER = "counter"
    private var KEY_COUNT: String = "COUNT"
    private var KEY_COUNT_CAT: String = "COUNTCAT"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)


        button_hello.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            myDialogFragment.show(manager, "myDialog")
        }

        /*button_hello.setOnClickListener {
            textView.text = "Hello Kitty!"
        }*/

        button_counter.setOnClickListener {
            textView.text = "Я нарахувала\nворони:${++counter}\nкоти:${counterCats}"
        }

        button_counter_cats.setOnClickListener {
            textView.text = "Я нарахувала\nворони:${counter}\nкоти:${++counterCats}"
        }

        button_counter0.setOnClickListener {
            counter = 0
            textView.text = "Я нарахувала\nворони:${counter}\nкоти:${counterCats}"
        }

        button_counter_cats0.setOnClickListener {
            counterCats = 0
            textView.text = "Я нарахувала\nворони:${counter}\nкоти:${counterCats}"
        }
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNT, 0)
            counterCats = savedInstanceState.getInt(KEY_COUNT_CAT, 0)
            textView.text = "Я нарахувала\nворони:${counter}\nкоти:${counterCats}"
        }
    }

    override fun onPause() {
        super.onPause()
        val editor = prefs.edit()
        editor.putInt(APP_PREFERENCES_COUNTER, counter).apply()
        val editorCat = prefs.edit()
        editorCat.putInt(APP_PREFERENCES_COUNTER_CAT, counterCats).apply()
    }

    override fun onResume() {
        super.onResume()
        if(prefs.contains(APP_PREFERENCES_COUNTER) || prefs.contains(APP_PREFERENCES_COUNTER_CAT)){
            counter = prefs.getInt(APP_PREFERENCES_COUNTER, 0)
            counterCats = prefs.getInt(APP_PREFERENCES_COUNTER_CAT, 0)
            textView.text = "Я нарахувала\nворони:${counter}\nкоти:${counterCats}"
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, counter)
        outState.putInt(KEY_COUNT_CAT, counterCats)
    }
}
