package com.masaibar.inappreviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.review.ReviewManagerFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = ReviewManagerFactory.create(this)

        val request = manager.requestReviewFlow()
        request.addOnCompleteListener {task ->
            if(task.isSuccessful) {
                val reviewInfo = task.result
                val flow = manager.launchReviewFlow(
                    this,
                    reviewInfo
                )
                flow.addOnCompleteListener {

                }
            } else {
                // do nothing
            }
        }
    }
}
