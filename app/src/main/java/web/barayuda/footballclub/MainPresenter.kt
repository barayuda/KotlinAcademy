package web.barayuda.footballclub

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import web.barayuda.footballclub.Api.ApiRespository
import web.barayuda.footballclub.Api.TheSportDBApi
import web.barayuda.footballclub.Model.TeamResponse

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRespository,
                    private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

}

