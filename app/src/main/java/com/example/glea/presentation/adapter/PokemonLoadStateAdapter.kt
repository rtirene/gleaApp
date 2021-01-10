package com.example.glea.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.glea.R
import com.example.glea.presentation.components.PokeballLoadingDot

class PokemonLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<PokemonLoadStateAdapter.LoadingStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadingStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): LoadingStateViewHolder {
        return LoadingStateViewHolder.getInstance(parent, retry)
    }

    class LoadingStateViewHolder(view: View, retry: () -> Unit) : RecyclerView.ViewHolder(view) {
        companion object {
            fun getInstance(parent: ViewGroup, retry: () -> Unit): LoadingStateViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.loading_state_adapter_layout, parent, false)
                return LoadingStateViewHolder(view, retry)
            }
        }

        private val loader: PokeballLoadingDot = view.findViewById(R.id.loader)
        private val retryButton: AppCompatButton = view.findViewById(R.id.retry_button)
        private val textError: AppCompatTextView = view.findViewById(R.id.error_message)

        init {
            retryButton.setOnClickListener {
                retry()
            }
        }

        fun bind(loadState: LoadState) {
            loader.visibility = if (loadState is LoadState.Loading) View.VISIBLE else View.GONE
            textError.visibility = if (loadState is LoadState.Error) View.VISIBLE else View.GONE
            retryButton.visibility = if (loadState is LoadState.Error) View.VISIBLE else View.GONE
        }
    }
}

