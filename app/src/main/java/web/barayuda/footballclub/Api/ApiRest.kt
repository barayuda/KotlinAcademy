package web.barayuda.footballclub.Api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import web.barayuda.footballclub.Model.FootballMatch
import web.barayuda.footballclub.Model.Teams

interface ApiRest {

    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<FootballMatch>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<FootballMatch>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<Teams>

}