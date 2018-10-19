package com.halove.xyp.androidanitest

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

/**
 * android坐标3体系：原点在v屏幕的左上角，往左为x正方向，往下为y正方向
 *
 * 对应View来说，top为view顶点到x的距离，bottom为view下边到x的距离，left为左边到父容器边缘的距离，right为最右边到父容器边缘的距离，这些在初始时就定了的，不会在改变
 * getX和getY为view基于父容器边缘左上角的坐标，getX = left+translationX（移动的x）  getY = top + translationY
 *MotionEvent.getX()：获取点击事件距离控件左边缘的距离，单位：像素；
 * MotionEvent.getY()：获取点击事件距离控件上边缘的距离，单位：像素；
 * MotionEvent.getRawX()：获取点击事件距离屏幕左边缘的距离，单位：像素；
 * MotionEvent.getRawY()：获取点击事件距离屏幕上边缘的距离，单位：像素。
 */
class MainActivity : AppCompatActivity() {

    //补间动画并没有改变view的位置，点击事件还是在以前的位置。属性动画才是真正改变view的位置属性

    /**
     * android:duration     动画持续时间
    android:fillAfter    为true动画结束时，View将保持动画结束时的状态
    android:fillBefore   为true动画结束时，View将还原到开始开始时的状态
    android:repeatCount  动画重复执行的次数
    android:repeatMode   动画重复模式 ，重复播放时restart重头开始，reverse重复播放时倒叙回放，该属性需要和android:repeatCount一起使用
    android:interpolator 插值器，相当于变速器，改变动画的不同阶段的执行速度



    rotate、scale动画的android:pivotX和android:pivotY属性、translate动画的android:toXDelta和android:toYDelta属性的取值都可以是都可以数值、百分数、百分数p，比如：50、50%、50%p，他们取值的代表的意义各不相同：
    50表示以View左上角为原点沿坐标轴正方向(x轴向右，y轴向下)偏移50px的位置；
    50%表示以View左上角为原点沿坐标轴正方向(x轴向右，y轴向下)偏移View宽度或高度的50%处的位置；
    50%p表示以View左上角为原点沿坐标轴正方向(x轴向右，y轴向下)偏移父控件宽度或高度的50%处的位置（p表示相对于ParentView的位置）。
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alpha_btn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.alpha_xml)
            alpha_tv.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    toast("动画结束")
                }

                override fun onAnimationStart(animation: Animation?) {
                }

            })
        }


        rotate_btn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.rotate_xml)
            rotate_tv.startAnimation(animation)
        }


        scale_btn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale_xml)
            scale_tv.startAnimation(animation)
        }


        translate_btn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.translate_xml)
            translate_tv.startAnimation(animation)
        }


        //帧动画
        iv.setImageResource(R.drawable.frame_ani)
        val ani = iv.drawable as AnimationDrawable
        start_anim_list.setOnClickListener {
            if(ani.isRunning) ani.stop() else ani.start()
        }


        dump.setOnClickListener { startActivity(Intent(this, ValueAniActivity::class.java)) }
    }
}
