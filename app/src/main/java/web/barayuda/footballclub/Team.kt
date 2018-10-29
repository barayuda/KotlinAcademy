package web.barayuda.footballclub

import com.google.gson.annotations.SerializedName

data class Team(

    /* SerializeName -> ini dari string key yg ada di JSON response API */

    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null
)