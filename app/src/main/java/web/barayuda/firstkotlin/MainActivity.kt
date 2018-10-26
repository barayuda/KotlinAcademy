package web.barayuda.firstkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    companion object {
        val CLUB_IMAGE_KEY = "club_name"
        val CLUB_NAME_KEY = "club_image"
        val CLUB_DESC_KEY = "club_desc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items) {
            startActivity<DetailActivity>(
                CLUB_NAME_KEY to it.name,
                CLUB_IMAGE_KEY to it.image.toString(),
                CLUB_DESC_KEY to it.desc
            )
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)

        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i],
                image.getResourceId(i, 0),
                desc[i]
                ))
        }

        // Recycled the typed array
        image.recycle()
    }
}