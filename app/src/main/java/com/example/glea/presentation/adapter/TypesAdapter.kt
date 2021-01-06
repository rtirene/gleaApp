package com.example.glea.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.glea.R
import com.example.glea.domain.models.Type
import com.example.glea.presentation.components.TypeItemTextView
import com.example.glea.util.Types.Companion.BUG
import com.example.glea.util.Types.Companion.DARK
import com.example.glea.util.Types.Companion.DRAGON
import com.example.glea.util.Types.Companion.ELECTRIC
import com.example.glea.util.Types.Companion.FAIRY
import com.example.glea.util.Types.Companion.FIGHTING
import com.example.glea.util.Types.Companion.FIRE
import com.example.glea.util.Types.Companion.FLYING
import com.example.glea.util.Types.Companion.GHOST
import com.example.glea.util.Types.Companion.GRASS
import com.example.glea.util.Types.Companion.GROUND
import com.example.glea.util.Types.Companion.ICE
import com.example.glea.util.Types.Companion.POISON
import com.example.glea.util.Types.Companion.PSYCHIC
import com.example.glea.util.Types.Companion.ROCK
import com.example.glea.util.Types.Companion.STEEL
import com.example.glea.util.Types.Companion.WATER


class TypesAdapter : RecyclerView.Adapter<TypesAdapter.TypeViewHolder>() {

    var typeList = emptyList<Type?>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class TypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val typeTextView = itemView.findViewById<TypeItemTextView>(R.id.type_element)
        fun bind(type: Type?) {
            type?.typeName?.let {
                typeTextView.setStatus(retrieveLabelStatus(it))
                typeTextView.text = it
            }
        }

        private fun retrieveLabelStatus(type: String): TypeItemTextView.TextStatus {
            when (type) {
                FIGHTING -> return TypeItemTextView.TextStatus.TYPE_FIGHTING
                FLYING -> return TypeItemTextView.TextStatus.TYPE_FLYING
                POISON -> { return TypeItemTextView.TextStatus.TYPE_POISON }
                GROUND -> return TypeItemTextView.TextStatus.TYPE_GROUND
                ROCK -> return TypeItemTextView.TextStatus.TYPE_ROCK
                BUG -> return TypeItemTextView.TextStatus.TYPE_BUG
                GHOST -> return TypeItemTextView.TextStatus.TYPE_GHOST
                STEEL -> return TypeItemTextView.TextStatus.TYPE_STEEL
                FIRE -> return TypeItemTextView.TextStatus.TYPE_FIRE
                WATER -> return TypeItemTextView.TextStatus.TYPE_WATER
                GRASS -> return TypeItemTextView.TextStatus.TYPE_GRASS
                ELECTRIC -> return TypeItemTextView.TextStatus.TYPE_ELECTRIC
                PSYCHIC -> return TypeItemTextView.TextStatus.TYPE_PSYCHIC
                ICE -> return TypeItemTextView.TextStatus.TYPE_ICE
                DRAGON -> return TypeItemTextView.TextStatus.TYPE_DRAGON
                DARK -> return TypeItemTextView.TextStatus.TYPE_DARK
                FAIRY -> return TypeItemTextView.TextStatus.TYPE_FAIRY
                else -> return TypeItemTextView.TextStatus.TYPE_DEFAULT
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        return TypeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_type, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return typeList.size
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        holder.bind(typeList[position])
    }


}