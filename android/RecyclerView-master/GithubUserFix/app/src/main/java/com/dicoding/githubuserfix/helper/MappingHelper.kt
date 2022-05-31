package com.dicoding.githubuserfix.helper

import android.database.Cursor
import com.dicoding.githubuserfix.data.FavoriteData
import com.dicoding.githubuserfix.database.DbContract

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<FavoriteData> {
        val favList = ArrayList<FavoriteData>()
        notesCursor?.apply {
            while (moveToNext()) {
                val username = getString(getColumnIndexOrThrow(DbContract.FavColumns.USERNAME))
                val name = getString(getColumnIndexOrThrow(DbContract.FavColumns.NAME))
                val location = getString(getColumnIndexOrThrow(DbContract.FavColumns.LOCATION))
                val company = getString(getColumnIndexOrThrow(DbContract.FavColumns.COMPANY))
                val avatar = getString(getColumnIndexOrThrow(DbContract.FavColumns.AVATAR))
                val repository = getString(getColumnIndexOrThrow(DbContract.FavColumns.REPOSITORY))
                val favorite = getString(getColumnIndexOrThrow(DbContract.FavColumns.FAVORITE))
                favList.add(
                    FavoriteData(
                        username,
                        name,
                        location,
                        company,
                        avatar,
                        repository,
                        favorite
                    )
                )
            }
        }
        return favList
    }
}