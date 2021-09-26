package com.example.basketballcounter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

private const val TAG = "GameListFragment"

class GameListFragment : Fragment() {
    private val gameListViewModel: GameListViewModel by lazy {
        ViewModelProviders.of(this).get(GameListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "called onCreate()")
    }

    companion object {
        fun newInstance(): GameListFragment {
            return GameListFragment()
        }
    }
}