package com.example.myapplication


var world = arrayOf<Array<Boolean>>()
const val START = 0
const val END = 29
const val LIVE_STRING = "* "
const val DEAD_STRING = ". "
const val LIVE_CELL_PERCENTAGE_START = 40
const val LIVE_CELL_PERCENTAGE_END = 70
const val SLEEP_TIME = 1000

fun main() {
    initWorld()
    while (true){
        drawWorld()
        gameLogic()
        sleep(SLEEP_TIME)
    }
}

fun gameLogic(){
    var worldCopy = copy(world)
    for(i in START..END) {
        for (j in START..END) {
            val neigbors = countNeighbors(i, j, worldCopy)
            if (worldCopy[i][j]){
                world[i][j] = neigbors == 2 || neigbors == 3
            }else{
                world[i][j] = neigbors ==3
            }
        }

    }
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
    println()
}

private fun countNeighbors(
    i: Int,
    j: Int,
    worldCopy: Array<Array<Boolean>>
): Int {
    var neighbors = 0

    var im1 = i - 1
    var jm1 = j - 1
    var ip1 = i + 1
    var jp1 = j + 1

    if (im1 < START)
        im1 = END
    if (ip1 > END)
        ip1 = START
    if (jm1 < START)
        jm1 = END
    if (jp1 > END)
        jp1 = START

    if (worldCopy[im1][j])
        neighbors++
    if (worldCopy[i][jm1])
        neighbors++

    if (worldCopy[ip1][j])
        neighbors++
    if (worldCopy[i][jp1])
        neighbors++

    if (worldCopy[im1][jm1])
        neighbors++
    if (worldCopy[ip1][jp1])
        neighbors++

    if (worldCopy[ip1][jm1])
        neighbors++
    if (worldCopy[ip1][jm1])
        neighbors++
    return neighbors
}

fun convertToString(bool : Boolean):String{
    if (bool)
        return LIVE_STRING
    else
        return DEAD_STRING
}

fun randonGen(): Boolean{
    return Math.random() * 100 <= randomLiveCellPercentage()
}

fun randomLiveCellPercentage(): Int{
    return kotlin.random.Random.nextInt(LIVE_CELL_PERCENTAGE_START, LIVE_CELL_PERCENTAGE_END)
}

fun sleep(time: Int){
    try {
        // sleep for one second
        Thread.sleep(time.toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}

fun <T> copy(arr: Array<T>): Array<T> {
    return arr.clone()
}