package com.halove.xyp.androidanitest

import android.util.Log
import android.view.animation.Interpolator

/**
 * Copyright 杭州九爱科技有限公司. All rights reserved
 * Created by xyp on 2018/10/18.
 * 自定义的插值器，改变动画的执行速度
 */
class MyInterpolator : Interpolator{
    override fun getInterpolation(input: Float): Float {
        //input表示时间流逝的百分比
        //全部时间需要4秒钟，而现在时间过了2秒，那么时间流逝的百分比就是2/4=0.5
        //根据函数公式来计算
        Log.d("xuyueping", "input is $input")
        //翻译成数学表达式就是：{0.5*cos[(input + 1)π] + 0.5}  最基本的余弦函数变换
        return (Math.cos((input + 1) * Math.PI) / 2.0f).toFloat() + 0.5f
    }
}