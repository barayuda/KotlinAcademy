package web.barayuda.footballclub.Model

import com.google.gson.annotations.SerializedName

data class FootballMatch (
    @SerializedName("events") var events: List<Events>
)