package com.androiddevs.mvvmnewsapp.ui.database

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.ui.model.Source

class Converter {

    @TypeConverter
    fun ConvertFromSource(source: Source) : String {

        return source.name
    }

    @TypeConverter
    fun ConvertToSource(name : String) : Source {
        return Source(name,name)
    }
}