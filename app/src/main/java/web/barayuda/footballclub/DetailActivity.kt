package web.barayuda.footballclub

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import web.barayuda.footballclub.Api.ApiRest
import web.barayuda.footballclub.Api.TheSportDBApi
import web.barayuda.footballclub.Model.MatchData
import web.barayuda.footballclub.Model.Events
import web.barayuda.footballclub.Model.Team

class DetailActivity : AppCompatActivity(), DetailInterface.View {

    override fun displayTeamBadgeAway(team: Team) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .apply(RequestOptions().placeholder(R.drawable.img_loading))
            .into(iv_away_logo)
    }

    override fun displayTeamBadgeHome(team: Team) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .apply(RequestOptions().placeholder(R.drawable.img_loading))
            .into(iv_home_logo)
    }

    lateinit var mPresenter : DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val service = TheSportDBApi.getClient().create(ApiRest::class.java)
        val request = MatchData(service)
        mPresenter = DetailPresenter(this, request)

        val event = intent.getParcelableExtra<Events>("match")
        mPresenter.getTeamsBadgeAway(event.idAwayTeam)
        mPresenter.getTeamsBadgeHome(event.idHomeTeam)
        initData(event)
        supportActionBar?.title = event.strEvent
    }

    fun initData(event:Events){
        if(event.intHomeScore == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                tv_date_schedule.setTextColor(applicationContext.getColor(R.color.upcoming_match))
            }
        }

        tv_date_schedule.text = event.dateEvent
        tv_home_name.text = event.strHomeTeam
        tv_home_score.text = event.intHomeScore
        tv_away_name.text = event.strAwayTeam
        tv_away_score.text = event.intAwayScore

        tv_home_scorer.text = event.strHomeGoalDetails
        tv_away_scorer.text= event.strAwayGoalDetails

        tv_home_goalkeeper.text = event.strHomeLineupGoalkeeper
        tv_away_goalkeeper.text = event.strAwayLineupGoalkeeper

        tv_home_defender.text = event.strHomeLineupDefense
        tv_away_defender.text = event.strAwayLineupDefense

        tv_home_midfielder.text = event.strHomeLineupMidfield
        tv_away_midfielder.text = event.strAwayLineupMidfield

        tv_home_forwarder.text = event.strHomeLineupForward
        tv_away_forwarder.text = event.strAwayLineupForward

        tv_home_sub.text = event.strHomeLineupSubstitutes
        tv_away_sub.text = event.strAwayLineupSubstitutes

    }



}