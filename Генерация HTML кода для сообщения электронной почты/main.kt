import java.io.PrintWriter
data class Message(val sender:String?, val recipient:String?, val top:String?, val message:String?){
    fun toHTML(): String {
        val result_html = "<!DOCTYPE html>" +
        	"<html>"+"<head>"+"<link rel='stylesheet' href='./style.css'>"+"</head>"+
        	"<body>"+
        	"<table>"+
            if(sender){
               sender?.let("<tr><td>Отправитель:</td><td>$it</td></tr>")
            }
            if(recipient){
               recipient.let{"<tr><td>Получатель:</td><td>$it</td></tr>"}
            }
            if(top){
               top.let{"<tr><td>Тема:</td><td>$it</td></tr>"}
            }
            if(message){
               message.let{"\t\t\t<tr><td>Сообщение:</td><td>$it</td></tr>\n"}
            }
            "</table>"+
            "</body>"
        val writerHTML=PrintWriter("index.html")
        writerHTML.append(result_html)
        writerHTML.close()
        return result_html
	}
    fun toStyle():String{
          val result_style = "table{"+
                    "border:2px solid black;"+
                    "border-collapse:collapse;"+
                    "font-size:24px;"+
                    "}"+
                    "td{"+
                    "border:1px solid black;"+
                    "}"+
        val writerStyleHTML=PrintWriter("style.css")
        writerStyleHTML.append(result_style)
        writerStyleHTML.close()
        return style
    }
}





fun main(){
    val mes=Message("plofjqfi1h1@gmail.com","dqwjqfj@mail.ru",null,"test")
    println(mes.toHTML())
    println(mes.toStyle())
}