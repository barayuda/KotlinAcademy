package web.barayuda.footballclub

import web.barayuda.footballclub.Model.Events

interface MainInterface {

    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<Events>)
    }

    interface Presenter{
        fun getFootballMatchData()

        fun getFootballUpcomingData()
    }

}