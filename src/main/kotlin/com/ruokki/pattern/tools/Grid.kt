package com.ruokki.pattern.tools

class Grid<T>(val width: Int, val height: Int, defaultValue: T) {
    private val grid: ArrayList<ArrayList<T>> = ArrayList()

    init {
        for (x in 0 until width) {
            val ligne = ArrayList<T>()
            grid.add(ligne)
            for (y in 0 until height) {
                ligne.add(defaultValue);
            }
        }
    }


    fun put(x: Int, y: Int, value: T) {
        grid[x][y] = value
    }

    fun put(point: Point, value: T) {
        this.put(point.x, point.y, value)
    }

    fun get(point: Point): T {
        return this.get(point.x, point.y)
    }

    fun get(x: Int, y: Int): T {
        return grid[x][y]
    }

    val points: List<Point>
        get() {
            return this.grid.mapIndexed { x, ligne -> ligne.mapIndexed { y, cell -> Point(x, y) } }.flatMap { it }
        }


    override fun toString(): String {
        return grid.map(ArrayList<T>::toString).map { ligne -> ligne + "\n" }.toString()
    }


}