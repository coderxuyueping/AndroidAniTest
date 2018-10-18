package com.halove.xyp.androidanitest

import android.content.Context
import android.widget.Toast

/**
 * Copyright 杭州九爱科技有限公司. All rights reserved
 * Created by xyp on 2018/10/18.
 */
fun Context.toast(msg: String, time: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, time).show()
}