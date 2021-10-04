package com.info.bootcampweek5.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseCallBack<T> : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {

        if(response.isSuccessful){
            response.body()?.let {
                onSuccess(it)
            } ?: run {
                onFailure()
            }
        } else{
            onFailure()
        }

    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure()
    }

    abstract fun onSuccess(data: T) //onSuccess i abstract yaparak kullanılan her yerde implement etme zorunluluğu getirmiş olduk.

    open fun onFailure() {
    }


}