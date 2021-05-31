package org.training.bookmarks

data class BookmarkCreated(val url: String, val description: String) : Event {

}
