package com.wojtek.bddaplication

import com.andrewreitz.spock.android.WithContext
import spock.lang.Specification;

class ContextTest extends Specification {

    @WithContext
    def context

    def "Test context"() {

        expect:
        context != null

    }

}