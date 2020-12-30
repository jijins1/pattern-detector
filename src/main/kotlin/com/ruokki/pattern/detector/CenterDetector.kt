package com.ruokki.pattern.detector

import com.ruokki.pattern.tools.Grid
import com.ruokki.pattern.tools.Point

class CenterDetector(val gridPattern: Grid<Boolean>, val gridImage: Grid<Boolean>) {


    val pointInPatternToUse: List<Point>
        get() {
            return gridPattern.points.filter { point -> gridPattern.get(point) }
        }

    /**
     * Retourne une grid avec tout les scores
     * @return
     */
    fun getAllScore(): Grid<Int> {
        val gridOfScore = Grid(gridImage.height, gridImage.width, 0);
        gridImage.points.forEach() { point -> gridOfScore.put(point, getScoreForPoint(point)) }
        return gridOfScore
    }

    /**
     * retourne le point avec le meilleur score
     */
    fun getBestPoint(): Point {
        val allScore = getAllScore()
        return allScore.points.maxBy { point -> allScore.get(point) }!!;
    }

    /**
     * Retourne le score du point en parametre
     */
    fun getScoreForPoint(point: Point): Int {
        return pointInPatternToUse.map { pointInPattern -> pointInPattern.translate(point) }
            .map { pointAbsolute ->
                var result = false;
                try {
                    result = gridImage.get(pointAbsolute)
                } catch (ignore: IndexOutOfBoundsException) {
                }
                result
            }.map { isPattern: Boolean ->
                if (isPattern) {
                    1
                } else {
                    0
                }
            }.reduceRight { i, acc -> i + acc }
    }
}