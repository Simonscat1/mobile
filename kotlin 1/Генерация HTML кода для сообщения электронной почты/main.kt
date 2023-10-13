import java.io.PrintWriter

data class Message(val sender:String?, val recipient:String?, val topic:String?, val message:String?){
fun toHTML():String {
     val  HTMLCode = "<!DOCTYPE html>"+
          "<html>"+
          "<head>"+
          "<link rel=\"stylesheet\" href=\"style.css\">"+
          "</head>"+
          "<body>"+
          "<table>"+
          when(sender){
               else->sender.let{"<tr><td class=\"nameRow\">Отправитель:</td><td>$it</td></tr>"}
          }+
          when(recipient){
               else->recipient.let{"<tr><td class=\"nameRow\">Получатель:</td><td>$it</td></tr>"}
          }+
          when(topic){
               else->topic.let{"<tr><td class=\"nameRow\">Тема:</td><td>$it</td></tr>"}
          }+
          when(message){
               else->message.let{"<tr><td class=\"nameRow\">Сообщение:</td><td>$it</td></tr>"}
          }+
          "</table>"+
          "</body>"+
          "</html>"

     val writerHTML=PrintWriter("main.html")
     writerHTML.append(HTMLCode)
     writerHTML.close()
     return HTMLCode
}
fun toStyle():String{
     val style=  "table{"+
               "border:2px solid black;"+
               "border-collapse:collapse;"+
               "font-size:20px;"+
               "}"+
               "td{"+
               "border:1px solid forestgreen;"+
               "text-align:center;"+
               "}"+
               ".nameRow{"+
               "text-align:left;"+
               "background-color: #F7FF7F;"+
               "}"
     val writerStyleHTML=PrintWriter("style.css")
     writerStyleHTML.append(style)
     writerStyleHTML.close()
     return style
}
}
fun main(){
     val mes=Message("plofjqfi1h1@gmail.com","dqwjqfj@mail.ru",null,"test")
     println(mes.toHTML())
     println(mes.toStyle())
}