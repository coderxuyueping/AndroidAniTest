package com.halove.xyp.androidanitest

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_value_ani.*

/**
 * Copyright 杭州九爱科技有限公司. All rights reserved
 * Created by xyp on 2018/10/18.
 * 属性动画
 * 所谓属性动画，就是改变对象Object的属性来实现动画过程。
 */
class ValueAniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_ani)

        //使用ObjectAnimator可以方便实现补间动画的4种
        ObjectAnimator_btn.setOnClickListener {
            ObjectAnimator.ofFloat(iv, "rotationY", 0f, 360f)
                    .setDuration(2000)
                    .start()
        }




        /**
         * ValueAnimator是ObjectAnimator的父类，它继承自Animator。
         * ValueAnimator同样提供了ofInt、ofFloat、ofObject等静态方法，
         * 传入的参数是动画过程的开始值、中间值、结束值来构造动画对象。
         * 可以将ValueAnimator看着一个值变化器，即在给定的时间内将一个目标值
         * 从给定的开始值变化到给定的结束值。在使用ValueAnimator时通常需要
         * 添加一个动画更新的监听器，在监听器中能够获取到执行过程中的每一个动画值。
         * 本身并没有动画，只是对数值进行动态改变
         */
        valueAnimator_btn.setOnClickListener {
            val valueAni = ValueAnimator.ofFloat(0f,180f)
                    .setDuration(2000)
            valueAni.start()
            valueAni.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener{
                override fun onAnimationUpdate(animation: ValueAnimator?) {
                    //这里可以监听到该动画实时改变的值
                    val value = animation?.animatedValue as Float
                    Log.d("xudaha", "value is $value")

                    //自己拿到值去更新view的属性，执行view动画
                    iv.rotationX = value
                }
            })

            valueAni.addListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {
                }
                override fun onAnimationEnd(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }
                override fun onAnimationStart(animation: Animator?) {
                }
            })


        }


        /**
         * 插值器（Interpolator）控制动画过程速度快慢
         * 估值器(TypeEvaluator)控制整个动画过程的运动轨迹
         */
        Interpolator_btn.setOnClickListener {
            val valueAni = ValueAnimator.ofFloat(0f,20f)
                    .setDuration(2000)

            valueAni.interpolator = MyInterpolator()
            valueAni.start()
            valueAni.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener{
                override fun onAnimationUpdate(animation: ValueAnimator?) {
                    //这里可以监听到该动画实时改变的值
                    val value = animation?.animatedValue as Float
                    Log.d("xudaha", "value is $value")

                    //自己拿到值去更新view的属性，执行view动画
                    iv.rotationX = value
                }
            })
        }




        TypeEvaluator_btn.setOnClickListener {
            val valueAni = ValueAnimator.ofObject(MyEvaluator(), 0f,20f)
                    .setDuration(1000)

            valueAni.interpolator = MyInterpolator()
            valueAni.start()
            valueAni.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener{
                override fun onAnimationUpdate(animation: ValueAnimator?) {
                    //这里可以监听到该动画实时改变的值
                    val value = animation?.animatedValue as Float
                    Log.d("xudaha", "value is $value")

                    //自己拿到值去更新view的属性，执行view动画
                    iv.rotationX = value
                }
            })
        }
    }
}