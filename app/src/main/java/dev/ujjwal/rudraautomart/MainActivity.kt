package dev.ujjwal.rudraautomart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = arrayListOf(
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3
        )

        for (i in images) {
            flipperImages(i)
        }

        main_iv_next.setOnClickListener {
            view_flipper.stopFlipping()
            view_flipper.setInAnimation(this, R.anim.slide_in_right)
            view_flipper.setOutAnimation(this, R.anim.slide_out_left)
            view_flipper.showNext()
            view_flipper.startFlipping()
        }
        main_iv_previous.setOnClickListener {
            view_flipper.stopFlipping()
            view_flipper.setInAnimation(this, R.anim.slide_in_left)
            view_flipper.setOutAnimation(this, R.anim.slide_out_right)
            view_flipper.showPrevious()
            view_flipper.startFlipping()
            view_flipper.setInAnimation(this, R.anim.slide_in_right)
            view_flipper.setOutAnimation(this, R.anim.slide_out_left)
        }
    }

    private fun flipperImages(image: Int) {
        val imageView = ImageView(this)
        imageView.setBackgroundResource(image)
        imageView.scaleType = ImageView.ScaleType.FIT_XY

        view_flipper.addView(imageView)
        view_flipper.flipInterval = 4000
        view_flipper.isAutoStart = true

        view_flipper.setInAnimation(this, R.anim.slide_in_right)
        view_flipper.setOutAnimation(this, R.anim.slide_out_left)
    }
}