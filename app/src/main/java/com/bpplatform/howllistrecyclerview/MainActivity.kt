package com.bpplatform.howllistrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        howl_recyclerview.adapter = MainRecyclerviewAdapter()
        howl_recyclerview.layoutManager = LinearLayoutManager(this)
    }

    class MainRecyclerviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var images = arrayOf(R.drawable.rail01,R.drawable.rail02,R.drawable.rail03,R.drawable.rail04)
        var titles = arrayOf("프랑크푸르트","런던","파리","프라하")
        var countries = arrayOf("독일","영국","프랑스","체코")
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_layout, parent, false)

            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {

            var imageview: ImageView? = null
            var textview: TextView? = null
            var textview2: TextView? = null
            init {
                imageview = view!!.findViewById(R.id.profile_imageview)
                textview = view.findViewById(R.id.title_textview)
                textview2 = view.findViewById(R.id.country_textview)
            }

        }

        override fun getItemCount(): Int {
           return images.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            var view = holder as CustomViewHolder
            view.imageview!!.setImageResource(images[position])
            view.textview!!.text = titles[position]
            view.textview2!!.text = countries[position]
        }
    }
}
