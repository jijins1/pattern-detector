package com.ruokki.pattern.tools

import java.net.URL
import javax.imageio.ImageIO

/**
 * Permet de charger une image et de la transformer en donnée exploitable
 */
class ImgManipulator(val file: URL, val threshold: Int) {
    constructor(file: URL) : this(file, DEFAULT_THRESHOLD) {
    }

    /**
     * Converti l'image en une grille de boolean
     * @return la grid contenant les valeur
     */
    fun convertImgToBoolGrid(): Grid<Boolean> {
        val raster = ImageIO.read(file).data
        val grid = Grid(raster.width, raster.height, false)
        for (x in 0 until raster.width) {
            for (y in 0 until raster.height) {
                val rgbBlanc = IntArray(3)
                raster.getPixel(x, y, rgbBlanc)
                grid.put(x, y, rgbBlanc[0] < threshold);
            }
        }
        return grid
    }

    companion object {
        const val DEFAULT_THRESHOLD = 125;
    }


}