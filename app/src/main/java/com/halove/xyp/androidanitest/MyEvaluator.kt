package com.halove.xyp.androidanitest

import android.animation.TypeEvaluator

/**
 * Copyright 杭州九爱科技有限公司. All rights reserved
 * Created by xyp on 2018/10/18.
 * 自定义的估值器，控制运动轨迹
 */
class MyEvaluator : TypeEvaluator<Float> {
    override fun evaluate(fraction: Float, startValue: Float?, endValue: Float?): Float {
        //也是通过数学函数来计算
        val value = startValue!! + fraction * (endValue!! - startValue)
        return value
    }
}