package org.training.bookmarks

class EventPublisher {
    private var listeners = HashMap<Class<out Event>, (Event) -> Unit>()

    fun <T> register(event: Class<T>, listener: (Event) -> Unit) where T : Event {
        listeners.put(event, listener)
    }

    fun publish(event: Event) {
        listeners
            .filter { it -> it.key.equals(event.javaClass) }
            .forEach { it -> it.value(event) }
    }
}
