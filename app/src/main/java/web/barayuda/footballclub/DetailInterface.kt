package web.barayuda.footballclub

import web.barayuda.footballclub.Model.Team

interface DetailInterface {

    interface View{
        fun displayTeamBadgeHome(team: Team)
        fun displayTeamBadgeAway(team: Team)
    }

    interface Presenter{
        fun getTeamsBadgeAway(id:String)
        fun getTeamsBadgeHome(id:String)
    }
}