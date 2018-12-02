package web.barayuda.footballclub

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import web.barayuda.footballclub.Model.MatchDataInterface

class DetailPresenter(val mView : DetailInterface.View, val matchDataInterface: MatchDataInterface) : DetailInterface.Presenter {

    override fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(matchDataInterface.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mView.displayTeamBadgeHome(it.teams[0])
            })
    }

    val compositeDisposable = CompositeDisposable()

    override fun getTeamsBadgeAway(id:String) {
        compositeDisposable.add(matchDataInterface.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mView.displayTeamBadgeAway(it.teams[0])
            })
    }
}