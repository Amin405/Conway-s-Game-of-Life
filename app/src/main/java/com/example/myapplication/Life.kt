package com.example.myapplication


var world = arrayOf<Array<Boolean>>()
const val START = 0
const val END = 29
const val LIVE_CELL_PERCENTAGE = 50
const val LIVE_STRING = "* "
const val DEAD_STRING = ". "

fun main() {
    initWorld()
    drawWorld()
}

fun initWorld(){
    for(i in START..END) {
        var internalArr = arrayOf<Boolean>()
        for (j in START..END) {
            internalArr += randonGen()
        }
        world += internalArr
    }
}
fun drawWorld(){
    for(i in START..END) {

        for (j in START..END) {
            print(convertToString(world[i][j]))
        }
        println()

    }
}
fun convertToString(bool : Boolean):String{
    if (bool)
        return LIVE_STRING
    else
        return DEAD_STRING
}

fun randonGen(): Boolean{
    return Math.random() * 100 <= LIVE_CELL_PERCENTAGE
}