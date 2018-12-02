package web.barayuda.footballclub.Api

import java.net.URL

class ApiRespository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }

}