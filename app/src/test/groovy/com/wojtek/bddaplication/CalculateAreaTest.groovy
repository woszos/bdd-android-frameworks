package com.wojtek.bddaplication

import spock.lang.Specification;

class CalculateAreaTest extends Specification {

    def "Testing methods area of circle"() {
        given: "init"
        def calculateArea = new CalculateArea()
        def radius = 2
        def expectedValue = 12.566370614359172

        when: "Calculation of the circle"
        def result = calculateArea.areaOfCircle(radius)

        then: "Check result"
        result == expectedValue
    }

    def "Testing methods area of circle - Data Tables"(int radius, double expectedValue) {
        given: "init"
        def calculateArea = new CalculateArea()

        expect: "Checking the value from the table"
        calculateArea.areaOfCircle(radius) == expectedValue

        where: "Values for the variables"
        radius | expectedValue
             1 | 3.141592653589793
             7 | 153.93804002589985
             0 | 0
    }

    def "Testing methods area of square"() {
        given: "init"
        def calculateArea = new CalculateArea()
        def valueX = 2
        def valueY = 2
        def listener = Mock(OnSquareListener)
        def expectedValue = 4

        when: "Calculation of the square"
        calculateArea.areaOfSquare(valueX, valueY, listener)

        then: "Verify that appropriate methods are called"
            1 * listener.onSuccess(expectedValue)
            0 * listener.onFailed()
    }

}