package com.example.gamelog.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.gamelog.R
import com.example.gamelog.model.Game
import kotlinx.android.synthetic.main.activity_add_game.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AddGameActivity : AppCompatActivity() {
    private lateinit var gameViewModel: AddGameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        fabSave.setOnClickListener {
            saveItem()
        }
    }

    private fun initViewModel() {
        gameViewModel = ViewModelProviders.of(this).get(AddGameViewModel::class.java)
    }

    private fun saveItem() {
        val item =
            Game(
                etGameTitle.text.toString(),
                etGamePlatform.text.toString(),
                LocalDate.parse(
                    etYear.text.toString() + "-" + etMonth.text.toString() + "-" + etDay.text.toString(),
                    DateTimeFormatter.ISO_DATE
                ),
                null
            )
        gameViewModel.insertGame(item)
        finish()
    }
}
