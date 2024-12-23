package com.example.tennis

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvTeamOneScore: TextView
    private lateinit var tvTeamTwoScore: TextView

    private var teamOneScore = 0
    private var teamTwoScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvTeamOneScore = findViewById(R.id.textView6)
        tvTeamTwoScore = findViewById(R.id.textView7)

        savedInstanceState?.let { bundle ->
            teamOneScore = bundle.getInt("teamOneScore")
            teamTwoScore = bundle.getInt("teamTwoScore")
        }

        tvTeamOneScore.text = teamOneScore.toString()
        tvTeamTwoScore.text = teamTwoScore.toString()

        findViewById<Button>(R.id.button5).setOnClickListener {
            teamOneScore++
            tvTeamOneScore.text = teamOneScore.toString()
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            teamTwoScore++
            tvTeamTwoScore.text = teamTwoScore.toString()
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("teamOneScore", teamOneScore)
        outState.putInt("teamTwoScore", teamTwoScore)

    }

    private fun checkWinner(){
        if(teamOneScore == 10) {
            Toast.makeText(this, "Federer Wins", Toast.LENGTH_SHORT).show()
        }
        else if(teamTwoScore == 10){
            Toast.makeText(this, "Nadal Wins", Toast.LENGTH_SHORT).show()
        }
        else if(teamOneScore == 10 || teamTwoScore == 10){
            teamOneScore = 0
            teamTwoScore = 0
            tvTeamOneScore.text = teamOneScore.toString()
            tvTeamTwoScore.text = teamTwoScore.toString()
        }
    }
}