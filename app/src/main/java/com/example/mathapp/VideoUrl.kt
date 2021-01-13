package com.example.mathapp


import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.URLUtil
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_video_url.*

class VideoUrl: AppCompatActivity() {
    private var video_link = ""
    private var url_code = -1
    private var activity_num = -1
    lateinit var VideoView_URL: VideoView
    lateinit var loading_text: TextView

    private var mCurrentPosition = 0

    private val PLAYBACK_TIME = "play_time"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_url)

        //collect data from intent bundle
        url_code = intent.getIntExtra("urlCode", 0)
        activity_num = intent.getIntExtra("activity", 0)

        //calls function to set values for the url based on the activity_num and url_code
        //passed in the intent bundle
        setVideoUrlCode(url_code, activity_num)

        //hooks in the videoView and textView
        VideoView_URL = findViewById(R.id.videoview_url)
        loading_text = findViewById(R.id.loading_textview)

        //creates onclick listener for button
        returnToCourseSelect.visibility = View.INVISIBLE
        returnToCourseSelect.setOnClickListener {
            //return user to previous course activity based on the activity_num
            when(activity_num){
                1 ->{startActivity(Intent(this, CollegeAlgebra::class.java))}
                2 ->{startActivity(Intent(this, Calculus1::class.java))}
                3 ->{startActivity(Intent(this, Calculus2::class.java))}

                else -> startActivity(Intent(this, CourseSelection::class.java))
            }
            finishAffinity()
        }

        if (savedInstanceState != null) {
            mCurrentPosition =
                savedInstanceState.getInt(PLAYBACK_TIME)
        }

       val controller = MediaController(this)
        controller.setMediaPlayer(VideoView_URL)
        VideoView_URL.setMediaController(controller)
    }
    /*
    method for dynamically setting url for video_link
     */
    private fun setVideoUrlCode(urlCode: Int, activity_num: Int) {

        when(activity_num){
            1 -> when(url_code){
                1 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/CA-Equ_Linear.mp4"
                2 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/CA-Complex_Numb.mp4"
                3 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/CA-Equ_Quad.mp4"
                4 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/Applications_Quadratic.mp4"
                5 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/CA-Eq_QuadInForm.mp4"
                6 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-Eq_Rational.mp4"
                7 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-Equ_Radical.mp4"
                8 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-Equ_Abs_Value.mp4"
                9 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-Inequalities.mp4"
                10 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-Inequalities_Abs_Value.mp4"
                11 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-Rect_Coord_Sys.mp4"
                12 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-Circles.mp4"
                13 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/FUN_Domain.mp4"
                14 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/CA-FUN_Range.mp4"
            }
            2 -> when(url_code){
                1 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/C1-FUN_Lim_Quest.mp4"
                2 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/C1-FUN_Limit_Graphs.mp4"
                3 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/C1_Lim_Fin_2sided.mp4"
                4 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-Finite-1-sided-Limits.mp4"
                5 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/08/C1-Continuity.mp4"
                6 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/C1-Infinite-2-1-sided-Limits.mp4"
                7 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/C1-Finite_Limits_at_Infinity.mp4"
                8 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/C1-Infinite_Limits_at_Infinity.mp4"
                9 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/C1-Der_Intro.mp4"
                10 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/Der_Specific.mp4"
                11 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/C1-Der_Generic_01.mp4"
                12 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/C1-Der_Generic_02.mp4"
                13 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/09/C1-Der_Intro_02.mp4"
            }
            3 -> when(url_code){
                1 -> video_link="http://www.mathbywilson.com/wp-content/uploads/2020/06/zoom_Position_PLUS.mp4"
                2 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-Area_Between_Curves-20200825a.mp4"
                3 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-3D_Disk-20200827a.mp4"
                4 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-3D_Washer-20020827a.mp4"
                5 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-Shell_Method.mp4"
                6 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-ArcLength.mp4"
                7 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-Surface_Area.mp4"
                8 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/08/C2-Physics_Apps.mp4"
                9 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/06/zoom_Log_Exp_FUN.mp4"
                10 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/06/zoom_Log_Diff.mp4"
                11 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/06/zoom_Hyperbolic_FUN.mp4"
                12 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/09/AnitDer_C1_AntiDer.mp4"
                13 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/09/AntiDer_Int_by_Parts.mp4"
                14 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/09/C2-INT_InvTrig.mp4"
                15 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/09/C2-Int_Quad_FUN.mp4"
                16 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/09/C2-Int_Trig_FUN.mp4"
                17 -> video_link = "http://www.mathbywilson.com/wp-content/uploads/2020/06/zoom_Int_Part_Fraction.mp4"
                18 -> video_link = ""
                19 -> video_link = ""
                20 -> video_link = ""
            }
        }

    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onPause() {
        super.onPause()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            VideoView_URL.pause()
        }
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(
            PLAYBACK_TIME, VideoView_URL.currentPosition
        )
    }

    private fun initializePlayer() {

        loading_text.visibility = VideoView.VISIBLE

        val videoUri = getMedia(video_link)
        VideoView_URL.setVideoURI(videoUri)

        VideoView_URL.setOnPreparedListener {
            loading_text.visibility = VideoView.INVISIBLE


            if (mCurrentPosition > 0) {
                VideoView_URL.seekTo(mCurrentPosition)
            } else {
                // Skipping to 1 shows the first frame of the video.
                VideoView_URL.seekTo(1)
            }

            // Start playing!
            VideoView_URL.start()
        }


        VideoView_URL.setOnCompletionListener {
            Toast.makeText(
                this,
                R.string.toast_message,
                Toast.LENGTH_SHORT
            ).show()

            // Return the video position to the start.
            VideoView_URL.seekTo(0)
            //show return to video selection button
            returnToCourseSelect.visibility = View.VISIBLE
        }
    }

    private fun releasePlayer() {
        VideoView_URL.stopPlayback()
    }


    private fun getMedia(mediaName: String): Uri {
        return if (URLUtil.isValidUrl(mediaName)) {
            Uri.parse(mediaName)
        } else {

             Uri.parse(
                "android.resource://" + packageName +
                        "/raw/" + mediaName
            )
        }
    }
}