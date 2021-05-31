package org.training.bookmarks

import org.assertj.core.api.Assertions
import org.junit.Test


class CreateBookmarkTest {

    @Test
    fun `Create a bookmark succeed, notify a BookmarkCreated event`() {
        // Given
        val receivedEvents = ArrayList<Event>()
        val eventPublisher = EventPublisher()
        eventPublisher.register(BookmarkCreated::class.java) { e ->  receivedEvents.add(e)}
        val createBookmark = CreateBookmark(eventPublisher)
        val url = "http://bookmark-url"
        val description = "Bookmark description"

        // When
        createBookmark.create(url, description)

        // Then
        val bookmarkTest = BookmarkCreated(url, description)
        Assertions.assertThat(receivedEvents).containsExactly(bookmarkTest)
    }
}