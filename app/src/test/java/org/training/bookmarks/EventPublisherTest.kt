package org.training.bookmarks

import org.assertj.core.api.Assertions
import org.junit.Test


class EventPublisherTest {

    @Test
    fun `publish only to the right listeners`() {
        // Given
        val event2 = Event2()
        val receivedEvents = ArrayList<Event>()
        val eventPublisher = EventPublisher()
        eventPublisher.register(Event1::class.java) { e ->  receivedEvents.add(e)}
        eventPublisher.register(Event2::class.java) { e ->  receivedEvents.add(e)}

        // When
        eventPublisher.publish(event2)

        // Then
        Assertions.assertThat(receivedEvents).containsExactly(event2)
    }
}

class Event2 : Event {

}

class Event1 : Event {

}
