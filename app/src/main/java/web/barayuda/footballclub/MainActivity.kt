package web.barayuda.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import web.barayuda.footballclub.Adapter.DataClubAdapter
import web.barayuda.footballclub.Api.ApiRest
import web.barayuda.footballclub.Api.TheSportDBApi
import web.barayuda.footballclub.Model.MatchData
import web.barayuda.footballclub.Model.Events
import web.barayuda.footballclub.Util.invisible
import web.barayuda.footballclub.Util.visible

class MainActivity : AppCompatActivity(), AnkoLogger, MainInterface.View {

    lateinit var mPresenter : MainPresenter

    private var matchLists : MutableList<Events> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = TheSportDBApi.getClient().create(ApiRest::class.java)
        val request = MatchData(service)
        mPresenter = MainPresenter(this, request)
        mPresenter.getFootballMatchData()
    }

    override fun hideLoading() {
        mainProgressBar.invisible()
        rvFootball.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBar.visible()
        rvFootball.visibility = View.INVISIBLE
    }

    override fun displayFootballMatch(matchList: List<Events>) {
        Log.v("LIST_SIZE", ""+matchList.size)
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = DataClubAdapter(matchList, applicationContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.nextmatch -> mPresenter.getFootballUpcomingData()
            R.id.lastMach -> mPresenter.getFootballMatchData()
        }
        return true
    }
}
