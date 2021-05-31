package org.training.bookmarks

class CreateBookmark(private val eventPublisher: EventPublisher) {
    fun create(url: String, description: String) {
        val bookmarkCreated = BookmarkCreated(url, description)
        eventPublisher.publish(bookmarkCreated)
    }

}
