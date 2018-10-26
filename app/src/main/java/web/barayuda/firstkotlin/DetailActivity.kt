package web.barayuda.firstkotlin

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // sesuaikan title di navbar dengan nama club
        val navBarTitle = intent.getStringExtra(MainActivity.CLUB_NAME_KEY)
        supportActionBar?.title = navBarTitle

        DetailFootballUI().setContentView(this)

    }

    inner class DetailFootballUI : AnkoComponent<DetailActivity> {
        private var footballName: String = ""
        private var footballImage: String = ""
        private var footballDesc: String = ""

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {

            footballName = intent.getStringExtra(MainActivity.CLUB_NAME_KEY)
            footballImage = intent.getStringExtra(MainActivity.CLUB_IMAGE_KEY)
            footballDesc = intent.getStringExtra(MainActivity.CLUB_DESC_KEY)

            verticalLayout {
                imageView(footballImage.toInt()).lparams(height = dip(100), width = matchParent) {
                    padding = dip(5)
                    margin = dip(5)
                }
                textView(footballName) {
                    this.gravity = Gravity.CENTER
                    textSize = dip(12).toFloat()
                }.lparams(width = matchParent) {
                    margin = dip(10)
                }
                textView(footballDesc).lparams(width = matchParent) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        textAlignment  = View.TEXT_ALIGNMENT_TEXT_START
                    }
                    margin = dip(5)
                }
            }

        }

    }



}
