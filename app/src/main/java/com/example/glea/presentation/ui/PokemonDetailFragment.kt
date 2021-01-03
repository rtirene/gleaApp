package com.example.glea.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.glea.R
import com.example.glea.domain.models.Pokemon
import com.example.glea.domain.models.Type
import com.example.glea.presentation.adapter.TypesAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*

class PokemonDetailFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private val adapter: TypesAdapter = TypesAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pokemon = arguments?.getSerializable(POKEMON) as Pokemon
        pokemon_image_detail_front.setOnClickListener(this)
        pokemon_image_detail_back.setOnClickListener(this)
        pokemon.let {
            pokemon_name.text = it.name
            setFrontImage(it.imgs?.frontUrl)
            setBackImage(it.imgs?.backUrl)
            initTypesAdapter(it.type)


        }
    }

    private fun setFrontImage(url: String?) {
        Glide.with(this)
            .load(url)
            .apply(
                RequestOptions()
                    .override(
                        resources.getDimensionPixelSize(R.dimen.pokemon_detail_image),
                        resources.getDimensionPixelSize(R.dimen.pokemon_detail_image)
                    )
            )
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(pokemon_image_detail_front)
            .onLoadFailed(null)

    }

    private fun setBackImage(url: String?) {

        Glide.with(this)
            .load(url)
            .apply(
                RequestOptions()
                    .override(
                        resources.getDimensionPixelSize(R.dimen.pokemon_detail_image),
                        resources.getDimensionPixelSize(R.dimen.pokemon_detail_image)
                    )
            )
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(pokemon_image_detail_back)
            .onLoadFailed(null)
    }

    private fun initTypesAdapter(types: List<Type?>?) {
        type_recycler.adapter = adapter
        types?.let { typeList ->
            adapter.typeList = typeList
        }
    }


    companion object {
        const val TAG = "PokemonDetailFragmemt"
        private const val POKEMON = "POKEMON"

        fun newInstance(pokemon: Pokemon? = null): PokemonDetailFragment =
            PokemonDetailFragment().apply {
                arguments = Bundle().apply {
                    this.putSerializable(POKEMON, pokemon)
                }
            }
    }

    override fun onClick(p0: View?) {
        when {
            p0?.id == R.id.pokemon_image_detail_front -> sprites_slider.showNext()
            p0?.id == R.id.pokemon_image_detail_back -> sprites_slider.showPrevious()
        }
    }
}



