package com.mx3.somethingtodo.ui.databinding;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class ViewBindingAdapters {

    @BindingAdapter("shown")
    public static void showOrInvisible(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }
}
