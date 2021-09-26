package com.example.basketballcounter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "GameListFragment"

class GameListFragment : Fragment() {

    private lateinit var gameRecyclerView: RecyclerView

    private val gameListViewModel: GameListViewModel by lazy {
        ViewModelProviders.of(this).get(GameListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "Total Games: ${gameListViewModel.games.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_list, container, false)

        gameRecyclerView = view.findViewById(R.id.game_recycler_view) as RecyclerView
        gameRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    private inner class GameHolder(view: View) : RecyclerView.ViewHolder(view){
        val teamAname: TextView = itemView.findViewById(R.id.savedTeamA)
        val teamBname: TextView = itemView.findViewById(R.id.savedTeamB)
        val teamAscore: TextView = itemView.findViewById(R.id.savedScoreA)
        val teamBscore: TextView = itemView.findViewById(R.id.savedScoreB)
        val gameDate: TextView = itemView.findViewById(R.id.gameDate)
    }

    companion object {
        fun newInstance(): GameListFragment {
            return GameListFragment()
        }
    }
}