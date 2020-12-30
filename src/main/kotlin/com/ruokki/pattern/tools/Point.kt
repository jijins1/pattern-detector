package com.ruokki.pattern.tools

data class Point(val x: Int, val y: Int) {

    /**
     * Retourne un nouveau point de this + point
     */
    fun translate(point: Point): Point {
        return Point(this.x + point.x, this.y + point.y)
    }

}