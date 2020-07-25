package com.ttw.databindingsample

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("app:popularityIcon")
fun popularityIcon(view: ImageView, popularity: SimpleViewModel.Popularity) {

    val color = getAssociatedColor(popularity, view.context)

    ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(color))

    view.setImageDrawable(getDrawablePopularity(popularity, view.context))
}

private fun getAssociatedColor(popularity: SimpleViewModel.Popularity, context: Context): Int {
    return when (popularity) {
        SimpleViewModel.Popularity.NORMAL -> context.theme.obtainStyledAttributes(
            intArrayOf(android.R.attr.colorForeground)
        ).getColor(0, 0x000000)
        SimpleViewModel.Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
        SimpleViewModel.Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
    }
}

private fun getDrawablePopularity(popularity: SimpleViewModel.Popularity,context:Context):Drawable?{
    return when(popularity){
        SimpleViewModel.Popularity.NORMAL-> ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
        SimpleViewModel.Popularity.POPULAR -> ContextCompat.getDrawable(context,R.drawable.ic_whatshot_black_96dp)
        SimpleViewModel.Popularity.STAR -> ContextCompat.getDrawable(context,R.drawable.ic_whatshot_black_96dp)
    }
}