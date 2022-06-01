package com.example.mypractical.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.listner.HomeListner
import com.example.mypractical.BR
import com.example.mypractical.databinding.AdapterMoviesBinding
import okhttp3.internal.notify
import okhttp3.internal.notifyAll


class MoviesAdapter(
    private val context: Context,
    private val dataList: MutableList<MoviesModel.Data>,
    private val listner: HomeListner
) : RecyclerView.Adapter<MoviesAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding =
            AdapterMoviesBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(
            rootView
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val model = dataList[position]
        holder.itemBinding.setVariable(BR.model, model)
        holder.itemBinding.setVariable(BR.position, position)
        holder.itemBinding.setVariable(BR.listner, listner)
        holder.itemBinding.executePendingBindings()
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemBinding.root)

    fun updateList(position: Int) {
        if(dataList.get(position).status == 1) {
            dataList.get(position).status = 2
        } else {
            dataList.get(position).status = 1
        }
       notifyItemChanged(position)
    }
}