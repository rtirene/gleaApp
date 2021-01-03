package com.example.glea.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.glea.R
import com.example.glea.domain.models.Stat
import com.example.glea.domain.models.Type
import com.example.glea.presentation.components.TypeItemTextView

class StatsAdapter : RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    var statList = emptyList<Stat?>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class StatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val statTextName = itemView.findViewById<AppCompatTextView>(R.id.stat_name)
        private val statTextValue = itemView.findViewById<AppCompatTextView>(R.id.stat_value)
        //private val statProgress = itemView.findViewById<ProgressBar>(R.id.stat_progress_bar)
        fun bind(stat: Stat?) {
            stat?.let {
                statTextName.text = it.name
                it.value?.let { value ->
                    statTextValue.text = value.toString()
                    //statProgress.progress = value
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        return StatsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_stat, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return statList.size
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        holder.bind(statList[position])
    }
}