package personal.project.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import personal.project.room.databinding.ItemDataBinding
import personal.project.room.room.ToDoDao
import personal.project.room.room.ToDoEntity

class AdapterRoom(  val list : ArrayList<ToDoEntity>): RecyclerView.Adapter<AdapterRoom.Holder>() {

    class Holder(val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val model = list[position]
        holder.binding.model = model
    }

    override fun getItemCount(): Int = list.size
}