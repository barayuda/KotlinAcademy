package web.barayuda.footballclub.Model

import io.reactivex.Flowable
import web.barayuda.footballclub.Api.ApiRest

class MatchData(private val footballRest: ApiRest) : MatchDataInterface {

    override fun getUpcomingMatch(id: String): Flowable<FootballMatch> = footballRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<FootballMatch> = footballRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<Teams> = footballRest.getTeam(id)
}