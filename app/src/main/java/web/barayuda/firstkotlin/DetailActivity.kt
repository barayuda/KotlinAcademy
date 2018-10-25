package web.barayuda.firstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class DetailActivity : AppCompatActivity() {

    private var footballName: String = ""
    lateinit var fbNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(10)
            fbNameTextView = textView()
        }

        val detailIntent = intent
        footballName = detailIntent.getStringExtra("football")
        fbNameTextView.text = footballName
    }


}
