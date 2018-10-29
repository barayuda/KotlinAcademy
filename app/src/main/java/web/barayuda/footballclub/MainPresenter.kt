package web.barayuda.footballclub

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import web.barayuda.footballclub.Api.ApiRespository
import web.barayuda.footballclub.Model.Team
import web.barayuda.footballclub.Model.TeamResponse

class MainPresenter(private val view: MainView,
                    private val apiRespository: ApiRespository,
                    private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRespository
                .doRequest(ApiRespository.TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

}

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}