package com.example.mypractical.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractical.R
import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.data.model.UpdateListModel
import com.example.mypractical.ui.home.HomeActivity
import com.example.mypractical.ui.home.MoviesAdapter
import com.example.mypractical.utils.LogM
import com.example.mypractical.utils.setDivider

@BindingAdapter("bindMoviesList","homeListner", "isUpdateList", requireAll = false)
fun bindMoviesList(view: RecyclerView, list: List<MoviesModel.Data>?, listner: HomeActivity, updateListModel: UpdateListModel?) {

    LogM.e("bindMoviesList is calling !!! position is ${updateListModel?.positon} "  )

    view.setDivider(R.drawable.recyclerview_divider)
    if(list != null) {
        var adapter : MoviesAdapter? = view.adapter as? MoviesAdapter
        if (adapter == null) {
            adapter = MoviesAdapter(view.context, list.toMutableList(),listner)
            view.adapter = adapter
        } else {
            adapter.updateList(updateListModel?.positon!!)
//            if(updateListModel?.isUpdate!!) {
//                if(list.get(updateListModel.positon).status == 1) {
//                    list.get(updateListModel.positon).status = 2
//                } else {
//                    list.get(updateListModel.positon).status = 1
//                }
//            }
//            adapter.updateList(list)
        }
    }
}

@BindingAdapter("setLikeUnlike")
fun setLikeUnlike(view: ImageView, status: Int) {

    LogM.e("setLikeUnlike is calling !!! " + status)

    if (status == 1) {
        view.setImageResource(R.drawable.ic_un_like)
    } else  {
        view.setImageResource(R.drawable.ic_like)
    }
}

