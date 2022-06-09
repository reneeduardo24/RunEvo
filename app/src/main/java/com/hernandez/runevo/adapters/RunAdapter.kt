package com.hernandez.runevo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hernandez.runevo.databinding.ItemRunBinding
import com.hernandez.runevo.db.Run
import com.hernandez.runevo.util.TrackingUtility
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {
    inner class RunViewHolder(val binding: ItemRunBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(run: Run) {
            binding.apply {
                Glide.with(ivRunImage).load(run.img).into(ivRunImage)
                val calendar = Calendar.getInstance().apply {
                    timeInMillis = run.timestamp
                }
                val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
                tvDate.text = dateFormat.format(calendar.time)

                val avgSpeed = "${run.avgSpeedInKMH} km/h"
                tvAvgSpeed.text = avgSpeed

                val distanceInKm = "${run.distanceInMeter / 1000f} km"
                tvDistance.text = distanceInKm

                tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)

                val caloriesBurned = "${run.caloriesBurned} kcal"
                tvCalories.text = caloriesBurned
            }
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<Run>() {
        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(
            ItemRunBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        differ.currentList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}