package com.androiddevs.mvvmnewsapp.ui.repository

import com.androiddevs.mvvmnewsapp.ui.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.ui.database.articleDB
import com.androiddevs.mvvmnewsapp.ui.model.Article

class NewsRepository(
    val db: articleDB

) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(articale: Article) = db.getArticleDao().upsert(articale)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun  deleteArticale(articale: Article) = db.getArticleDao().deleteArticle(articale)
}