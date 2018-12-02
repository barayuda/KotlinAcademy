package web.barayuda.footballclub

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import web.barayuda.footballclub.Model.MatchDataInterface

class MainPresenter(val mainInterface: MainInterface.View, val matchDataInterface: MatchDataInterface) : MainInterface.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getFootballUpcomingData() {
        mainInterface.showLoading()
        compositeDisposable.add(matchDataInterface.getUpcomingMatch("4328")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mainInterface.displayFootballMatch(it.events)
                mainInterface.hideLoading()
            })
    }

    override fun getFootballMatchData() {
        mainInterface.showLoading()
        compositeDisposable.add(matchDataInterface.getFootballMatch("4328")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mainInterface.displayFootballMatch(it.events)
                mainInterface.hideLoading()
            })
    }
}