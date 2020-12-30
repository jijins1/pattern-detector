package com.ruokki.pattern.detector

import com.ruokki.pattern.tools.Grid
import com.ruokki.pattern.tools.Point
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CentorDetectorTest {
    var pattern: Grid<Boolean> = Grid(5, 5, false);
    var img: Grid<Boolean> = Grid(40, 40, false)
    val decalage = Point(4, 4)
    var centerDetector: CenterDetector = CenterDetector(pattern, img)

    init {
    }


    @BeforeEach
    fun setUp() {
        generatePattern()
        generateImg()
    }

    private fun generateImg() {
        pattern.points
            .filter { point -> pattern.get(point) }
            .forEach { point: Point ->
                img.put(decalage.translate(point), true)
            }
    }

    private fun generatePattern() {
        pattern.put(2, 2, true)
        pattern.put(1, 2, true)
        pattern.put(2, 1, true)
        pattern.put(2, 3, true)
        pattern.put(3, 2, true)
    }


    @Test
    fun getScoreInCenter() {
        val scoreForPoint = centerDetector.getScoreForPoint(decalage)
        assertThat(scoreForPoint).isEqualTo(5)

        val scoreForPointMoved = centerDetector.getScoreForPoint(decalage.translate(Point(1, 0)))
        assertThat(scoreForPointMoved).isEqualTo(2)
    }

    @Test
    fun getBestPoint() {
        val bestPoint = centerDetector.getBestPoint()
        assertThat(bestPoint).isEqualTo(decalage)
    }
}