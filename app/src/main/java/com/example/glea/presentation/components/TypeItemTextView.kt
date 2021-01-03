package com.example.glea.presentation.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.glea.R

class TypeItemTextView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    private var mStatus: TextStatus? = TextStatus.TYPE_DEFAULT


    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState = super.onCreateDrawableState(extraSpace + TextStatus.values().size)
        when (mStatus) {
            TextStatus.TYPE_FIGHTING -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_FIGHTING.status })
            TextStatus.TYPE_FLYING -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_FLYING.status })
            TextStatus.TYPE_POISON -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_POISON.status })
            TextStatus.TYPE_GROUND -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_GROUND.status })
            TextStatus.TYPE_ROCK -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_ROCK.status })
            TextStatus.TYPE_BUG -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_BUG.status })
            TextStatus.TYPE_GHOST -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_GHOST.status })
            TextStatus.TYPE_STEEL -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_STEEL.status })
            TextStatus.TYPE_FIRE -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_FIRE.status })
            TextStatus.TYPE_WATER -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_WATER.status })
            TextStatus.TYPE_GRASS -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_GRASS.status })
            TextStatus.TYPE_ELECTRIC -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_ELECTRIC.status })
            TextStatus.TYPE_PSYCHIC -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_PSYCHIC.status })
            TextStatus.TYPE_ICE -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_ICE.status })
            TextStatus.TYPE_DRAGON -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_DRAGON.status })
            TextStatus.TYPE_DARK -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_DARK.status })
            TextStatus.TYPE_FAIRY -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_FAIRY.status })
            TextStatus.TYPE_DEFAULT -> View.mergeDrawableStates(
                drawableState,
                IntArray(1) { TextStatus.TYPE_DEFAULT.status })

        }
        return drawableState

    }

    fun setStatus(status: TextStatus) {
        mStatus = status
        setTextStatusColor()
        refreshDrawableState()
    }

    private fun setTextStatusColor() {
        when (mStatus) {
            TextStatus.TYPE_FIGHTING -> setTextColor(ContextCompat.getColor(context, R.color.blue))
            TextStatus.TYPE_FLYING -> setTextColor(ContextCompat.getColor(context, R.color.blue_green))

            TextStatus.TYPE_POISON -> setTextColor(ContextCompat.getColor(context, R.color.violet))
            TextStatus.TYPE_GROUND -> setTextColor(ContextCompat.getColor(context, R.color.brown))
            TextStatus.TYPE_ROCK -> setTextColor(ContextCompat.getColor(context, R.color.black))
            TextStatus.TYPE_BUG -> setTextColor(ContextCompat.getColor(context, R.color.green))
            TextStatus.TYPE_GHOST -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.dark_grey
                )
            )
            TextStatus.TYPE_STEEL -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.dark_blue
                )
            )
            TextStatus.TYPE_FIRE -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.orange_red
                )
            )
            TextStatus.TYPE_WATER -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.light_blue
                )
            )
            TextStatus.TYPE_GRASS -> setTextColor(ContextCompat.getColor(context, R.color.green))
            TextStatus.TYPE_ELECTRIC -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.yellow
                )
            )
            TextStatus.TYPE_PSYCHIC -> setTextColor(ContextCompat.getColor(context, R.color.violet))
            TextStatus.TYPE_ICE -> setTextColor(ContextCompat.getColor(context, R.color.light_blue))
            TextStatus.TYPE_DRAGON -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.watermelon_red
                )
            )
            TextStatus.TYPE_DARK -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.dark_violet
                )
            )
            TextStatus.TYPE_FAIRY -> setTextColor(ContextCompat.getColor(context, R.color.hot_pink))
            TextStatus.TYPE_DEFAULT -> setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.dark_grey
                )
            )
            else -> setTextColor(ContextCompat.getColor(context, R.color.dark_grey))

        }
    }


    enum class TextStatus(val status: Int) {
        TYPE_FIGHTING(R.attr.fighting),
        TYPE_FLYING(R.attr.flying),
        TYPE_POISON(R.attr.poison),
        TYPE_GROUND(R.attr.ground),
        TYPE_ROCK(R.attr.rock),
        TYPE_BUG(R.attr.bug),
        TYPE_GHOST(R.attr.ghost),
        TYPE_STEEL(R.attr.steel),
        TYPE_FIRE(R.attr.fire),
        TYPE_WATER(R.attr.water),
        TYPE_GRASS(R.attr.grass),
        TYPE_ELECTRIC(R.attr.electric),
        TYPE_PSYCHIC(R.attr.psychic),
        TYPE_ICE(R.attr.ice),
        TYPE_DRAGON(R.attr.dragon),
        TYPE_DARK(R.attr.dark),
        TYPE_FAIRY(R.attr.fairy),
        TYPE_DEFAULT(R.attr.normal)
    }


}