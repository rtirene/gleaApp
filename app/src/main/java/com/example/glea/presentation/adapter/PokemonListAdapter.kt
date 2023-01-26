package com.example.glea.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.glea.R
import com.example.glea.domain.models.Pokemon


class PokemonListAdapter :
    PagingDataAdapter<Pokemon, RecyclerView.ViewHolder>(pokemonDiffCallback) {

    var pokemonSelectedListener: OnPokemonSelectedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonViewHolder) {
            holder.bind(getItem(position))
        }
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pokemonNameTextView : AppCompatTextView = itemView.findViewById(R.id.pokemon_name)
        private val pokemonImageView : AppCompatImageView = itemView.findViewById(R.id.pokemon_image)
        fun bind(pokemon: Pokemon?) {
            pokemonNameTextView.text = pokemon?.name
            pokemon?.imgs?.frontUrl?.let {
                setPokemonListImage(url = pokemon.imgs.frontUrl)
            }
            itemView.setOnClickListener {
                pokemonSelectedListener?.onPokemonSelected(pokemon)
            }
        }

        private fun setPokemonListImage(url : String){
            Glide.with(itemView.context)
                .load(url)
                .placeholder(R.drawable.loading_animation)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokemonImageView)
        }
    }


    interface OnPokemonSelectedListener {
        fun onPokemonSelected(pokemon: Pokemon?)
    }

    companion object {
        private val pokemonDiffCallback = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem == newItem
        }
    }
}

