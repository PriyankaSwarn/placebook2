package com.raywenderlich.placebook.repository

import Bookmark
import BookmarkDao
import android.content.Context
import androidx.lifecycle.LiveData
import com.raywenderlich.placebook.db.PlaceBookDatabase


class BookmarkRepo(application: Any) {
    // 1
    class BookmarkRepo(context: Context) {
        // 2
        private var db = PlaceBookDatabase.PlaceBookDatabase.getInstance(context)
        private var bookmarkDao: BookmarkDao = db.bookmarkDao()
        // 3
        fun addBookmark(bookmark: Bookmark): Long? {
            val newId = bookmarkDao.insertBookmark(bookmark)
            bookmark.id = newId
            return newId
        }
        // 4
        fun createBookmark(): Bookmark {
            return Bookmark()
        }
        // 5
        val allBookmarks: LiveData<List<Bookmark>>
            get() {
                return bookmarkDao.loadAll()
            }
    }
}