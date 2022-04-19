package personal.project.room

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import personal.project.room.adapter.AdapterRoom
import personal.project.room.databinding.ActivityMainBinding
import personal.project.room.room.AppDataBase
import personal.project.room.room.ToDoDao
import personal.project.room.room.ToDoEntity
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "todo_list.db").build()
        val dao = db.todoDao()
        val entity = ToDoEntity(0,"title",Date().toString())
        fetchData(dao)
        binding.btn.setOnClickListener {
            db.transactionExecutor.execute {
                dao.insert(listOf(entity))
            }
        }

        binding.btnDelete.setOnClickListener {
            db.transactionExecutor.execute {
                dao.deleteAll()
            }
        }
    }



    @SuppressLint("NotifyDataSetChanged")
    private fun fetchData(dao: ToDoDao){
        val list = ArrayList<ToDoEntity>()
        dao.getAll().observe(this, Observer {
            list.clear()
            list.addAll(it)
            Log.d(TAG, "onCreate: ${it.size}")
            binding.txt.text = it.size.toString()
            if (binding.recyclerview.adapter== null){
                binding.recyclerview.adapter = AdapterRoom(list = list)
            }else{
                binding.recyclerview.adapter?.notifyDataSetChanged()
            }

        })
    }
}