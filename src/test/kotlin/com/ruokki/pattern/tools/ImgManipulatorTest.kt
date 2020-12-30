package com.ruokki.pattern.tools

import com.ruokki.pattern.detector.CentorDetectorTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.net.URL

internal class ImgManipulatorTest {

    var imgManipulator: ImgManipulator? = null;

    @BeforeEach
    internal fun setUp() {
        val resource: URL = CentorDetectorTest::class.java.getResource("/sample_cross.png")
        imgManipulator = ImgManipulator(resource)
    }

    @Test
    fun convertImgToBooleanGrid() {
        imgManipulator?.convertImgToBoolGrid()
    }
}