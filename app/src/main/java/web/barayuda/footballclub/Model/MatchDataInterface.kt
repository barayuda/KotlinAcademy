package web.barayuda.footballclub.Model

import io.reactivex.Flowable
import web.barayuda.footballclub.Model.FootballMatch
import web.barayuda.footballclub.Model.Teams

interface MatchDataInterface {

    fun getFootballMatch(id : String) : Flowable<FootballMatch>

    fun getTeams(id : String = "0") : Flowable<Teams>

    fun getUpcomingMatch(id : String) : Flowable<FootballMatch>

}