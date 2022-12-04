import java.lang.Character.isDigit


class Robot(var x: Int, var y: Int, var direction: Direction) {
     fun stepForward() {
         when (direction) {
             Direction.RIGHT -> x++
             Direction.LEFT -> x--
             Direction.UP -> y++
             Direction.DOWN -> y--
         }
     }
     fun turnLeft(){
         when (direction) {
             Direction.RIGHT -> direction=Direction.UP
             Direction.LEFT -> direction=Direction.DOWN
             Direction.UP -> direction=Direction.LEFT
             Direction.DOWN -> direction=Direction.RIGHT
         }
     }
     fun turnRight(){
         when (direction) {
             Direction.RIGHT -> direction=Direction.DOWN
             Direction.LEFT -> direction=Direction.UP
             Direction.UP -> direction=Direction.RIGHT
             Direction.DOWN -> direction=Direction.LEFT
         }
     }
     fun checkTurn(toX:Int,toY: Int){
             if((toX==x) and (toY==y)){
                 print("Место прибытия совпадает с началом движения")
             }
             else {
                 println("начало движения(Стартовая позиция): ${toString()}")
                 while (true) {
                     while (y != toY) {
                         if ((toY > y) and (direction != Direction.UP)) {
                             if (direction == Direction.LEFT) {
                                 turnRight()
                                 println("Поворот направа: ${toString()}")
                             } else if (direction == Direction.RIGHT) {
                                 turnLeft()
                                 println("Поворот налево: ${toString()}")
                             } else {
                                 turnLeft()
                                 println("Поворот налево: ${toString()}")
                             }
                         } else if ((toY < y) and (direction != Direction.DOWN)) {
                             if (direction == Direction.LEFT) {
                                 turnLeft()
                                 println("Поворот налево: ${toString()}")
                             } else if (direction == Direction.RIGHT) {
                                 turnRight()
                                 println("Поворот направа: ${toString()}")
                             } else {
                                 turnRight()
                                 println("Поворот направа: ${toString()}")
                             }
                         } else {
                             stepForward()
                             println("Движение: ${toString()}")
                         }
                     }
                     while (x != toX) {
                         if ((toX > x) and (direction != Direction.RIGHT)) {
                             if (direction == Direction.UP) {
                                 turnRight()
                                 println("Поворот направа: ${toString()}")
                             } else if (direction == Direction.DOWN) {
                                 turnLeft()
                                 println("Поворот налево: ${toString()}")
                             } else {
                                 turnLeft()
                                 println("Поворот налево: ${toString()}")
                             }
                         } else if ((toX < x) and (direction != Direction.LEFT)) {
                             if (direction == Direction.UP) {
                                 turnLeft()
                                 println("Поворот налево: ${toString()}")
                             } else if (direction == Direction.DOWN) {
                                 turnRight()
                                 println("Поворот направа: ${toString()}")
                             } else {
                                 println("Поворот направа: ${toString()}")
                                 println(toString())
                             }
                         } else {
                             stepForward()
                             println("Движение: ${toString()}")
                         }
                     }
                     println("Робот достиг места назначения(Финиш): ${toString()}")
                     break
                 }
             }
         }
 
 
     override fun toString(): String {
         return "(${x}, ${y}), looks ${direction}"
     }
 }


fun input(): Int {
    while (true) {
        var ch=0
        val digit = readLine().toString()
        digit.forEach {
            if(!isDigit(it)){
                ch++
            }
        }
        if(ch!=0){
            print("Введённое вами значение не является числом или содержит иные символы\nПовторите попытку:")
        }
        else{
            return (digit.toInt())
        }
    }
}

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}
fun moveRobot(r: Robot, toX: Int, toY: Int) {
    r.checkTurn(toX,toY)
}

fun main() {
    println("Для работы программы необходимо указать начальную позицию робота и конечную")
    print("Укажите текущее положение робота по оси Х:")
    val X0=input()
    print("Укажите текущее положение робота по оси У:")
    val Y0=input()
    print("Укажите место прибытия робота по оси Х:")
    val X=input()
    print("Укажите место прибытия робота по оси У:")
    val Y=input()
    val r=Robot(X0,Y0,Direction.UP)
    moveRobot(r,X,Y)


}