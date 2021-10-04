package com.info.bootcampweek5.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(messageToShow:String){
    Toast.makeText(requireContext(), messageToShow, Toast.LENGTH_SHORT).show()
}