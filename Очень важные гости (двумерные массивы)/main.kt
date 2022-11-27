import java.util.*
import java.io.File
import java.io.PrintWriter
import java.io.FileOutputStream


fun computing(nSize: Int, mSize: Int, nP: Int, mP: Int) : Array<Array<Int>> {
    val nPlace = nP - 1
    val mPlace = mP - 1
    val array = Array(nSize) {Array(mSize) {404}}
    var hallSize = nSize*mSize
    array[nPlace][mPlace] = hallSize
    hallSize--
    var nStart = nPlace
    val mStart = mPlace
    var n : Int
    var m : Int
    while (hallSize > 0) {
        nStart--
        if (nStart >= 0) {
            array[nStart][mStart] = hallSize
            hallSize--
        }
        n = nStart
        m = mStart
        while(n != nPlace){
            n++
            m--
            if ((n>=0 && m>=0) && (n<nSize && m<mSize)) {
                array[n][m] = hallSize
                hallSize--
            }
        }
        while(m != mPlace){
            n++
            m++
            if ((n>=0 && m>=0) && (n<nSize && m<mSize)) {
                array[n][m] = hallSize
                hallSize--
            }
        }
        while(n != nPlace){
            n--
            m++
            if ((n>=0 && m>=0) && (n<nSize && m<mSize)) {
                array[n][m] = hallSize
                hallSize--
            }
        }
        while(m != mPlace+1){
            n--
            m--
            if ((n>=0 && m>=0) && (n<nSize && m<mSize)) {
                array[n][m] = hallSize
                hallSize--
            }
        }
    }
    return array
}

fun main(args: Array<String>) {
    val (nPlace, mPlace) = "1 1".split(' ').map(String::toInt)

    println("Введите название файла с данными на вход:")
    val input = File(readLine())
    val inpFile = input.readLines().drop(1)
    val re = Regex("[^0-9]")
    val out = File("output.txt")
    for (i in inpFile) {
        val (nS, mS) = i.split(' ').map(String::toString)
        val mSize = re.replace(mS, "").toInt()
        val nSize = re.replace(nS, "").toInt()
        val array = computing(nSize, mSize, nPlace, mPlace)

        for (b in array) {
            for (a in b) {
                print(a.toString() + '\t')
            }

            println()
        }
        println()
    }
}
