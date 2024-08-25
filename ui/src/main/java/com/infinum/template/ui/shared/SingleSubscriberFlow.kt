package com.infinum.template.ui.shared

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.AbstractFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.sync.Mutex

@OptIn(FlowPreview::class)
class SingleSubscriberFlow<Event>(
    private val delegateFlow: Flow<Event>,
) : AbstractFlow<Event>() {

    private val mutex: Mutex = Mutex()

    override suspend fun collectSafely(collector: FlowCollector<Event>) {
        val lockSucceeded = mutex.tryLock()
        if (lockSucceeded) {
            try {
                delegateFlow.collect(collector)
            } finally {
                mutex.unlock()
            }
        } else {
            error("SingleSubscriberFlow can only have 1 active subscriber")
        }
    }
}
