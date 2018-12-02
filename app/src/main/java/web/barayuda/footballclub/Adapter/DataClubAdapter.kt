package web.barayuda.footballclub.Adapter

import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_detail.view.*
import org.jetbrains.anko.startActivity
import web.barayuda.footballclub.DetailActivity
import web.barayuda.footballclub.Model.Events
import web.barayuda.footballclub.R

class DataClubAdapter(val eventList:List<Events>, val context: Context): RecyclerView.Adapter<DataClubAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.main_match_item, parent, false))
    }

    override fun getItemCount(): Int = eventList.size


    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event:Events){
            if(event.intHomeScore == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    itemView.tv_date_schedule.setTextColor(context.getColor(R.color.upcoming_match))
                }
            }
            itemView.tv_date_schedule.text = event.dateEvent
            itemView.tv_home_name.text = event.strHomeTeam
            itemView.tv_home_score.text = event.intHomeScore
            itemView.tv_away_name.text = event.strAwayTeam
            itemView.tv_away_score.text = event.intAwayScore

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("match" to event)
            }
        }
    }

}