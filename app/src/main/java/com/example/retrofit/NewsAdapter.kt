package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_layout.view.*

class NewsAdapter(val context: Context,val articles: List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        when(holder){
            is ArticleViewHolder->{
                holder.bind(articles.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val newsimage = itemView.newsImage
        val newstitle = itemView.newsTitle
        val newsbody = itemView.newsBody

         fun bind(article:Article){
            newstitle.setText(article.title)
            newsbody.setText(article.description)

            val requestoptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestoptions)
                .load(article.urlToImage)
                .into(newsimage)
        }

    }
}