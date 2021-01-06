package com.example.glea.presentation.components

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.glea.R


class PokeballLoadingDot : FrameLayout {
    private var margin:Int = resources.getDimensionPixelSize(R.dimen.smallest_margin)
    private var pokeballRadius:Int = resources.getDimensionPixelSize(R.dimen.very_small_margin)
    private var numberOfPokeballs = 3
    private val animators = mutableListOf<Animator>()
    private var animationDuration = 1000L
    private var minScale = 0.5F
    private var maxScale = 1F
    private var animator: ValueAnimator? = null
    private lateinit var pokeballProgressBar: LinearLayout
    private var pokeballBackground = R.drawable.pokeball
    private var pokeballAnimator: ValueAnimator? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
    private fun init() {
        clipChildren = false
        clipToPadding = false
        pokeballProgressBar = LinearLayout(context)
        val progressBarLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        progressBarLayoutParams.gravity = Gravity.CENTER
        pokeballProgressBar.layoutParams = progressBarLayoutParams
        pokeballProgressBar.clipChildren = false
        pokeballProgressBar.clipToPadding = false
        addView(pokeballProgressBar)
        animators.clear()
        for (i in 0 until numberOfPokeballs) {
            val pokeball = View(context)
            val layoutParams = LayoutParams(pokeballRadius * 2, pokeballRadius * 2)
            layoutParams.setMargins(margin, margin, margin, margin)
            pokeball.layoutParams = layoutParams
            pokeball.scaleX = minScale
            pokeball.scaleY = minScale
            pokeball.setBackgroundResource(pokeballBackground)
            pokeballProgressBar.addView(pokeball)
            val animator = getScaleAnimator(pokeball)
            animators.add(animator)
        }
        animator?.cancel()
        animator = ValueAnimator.ofInt(0, numberOfPokeballs)
        animator?.addUpdateListener {
            if (it.animatedValue != numberOfPokeballs)
                animators[it.animatedValue as Int].start()
        }
        animator?.repeatMode = ValueAnimator.RESTART
        animator?.repeatCount = ValueAnimator.INFINITE
        animator?.duration = animationDuration
        animator?.interpolator = LinearInterpolator()
        startAnimation()
    }

    private fun getScaleAnimator(view: View): Animator {
        if (pokeballAnimator != null)
            return pokeballAnimator as ValueAnimator
        val animator = ValueAnimator.ofFloat(minScale, maxScale)
        animator.addUpdateListener {
            view.scaleX = it.animatedValue as Float
            view.scaleY = it.animatedValue as Float
        }
        animator.duration = animationDuration / numberOfPokeballs.toLong()
        animator.repeatCount = 1
        animator.repeatMode = ValueAnimator.REVERSE
        animator.interpolator = LinearInterpolator()
        return animator
    }

    private fun stopAnimation() {
        animator?.cancel()
    }

    private fun startAnimation() {
        animator?.start()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        if(visibility == View.GONE){
            stopAnimation()
        }
    }


}