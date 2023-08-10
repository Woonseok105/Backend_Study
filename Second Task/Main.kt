val list = arrayListOf<ToDo>()

fun main() {

    while (true) {
        val input = readLine()

        if (input == "할 일 추가") {
            add()
        } else if (input == "할 일 목록 조회") {
            checkList()
        } else if (input == "할 일 완료") {
            complete()
        } else if (input == "할 일 삭제") {
            delete()
        } else
            println("잘못 입력하셨습니다.")
    }
}

fun getRandomString(): String {
    val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
    return (1..10)
        .map { charset.random() }
        .joinToString("")
}

fun add() {
    println("제목과 내용을 입력해주세요.")
    val id = getRandomString()
    val title = readLine()
    val content = readLine()

    val toDoList = ToDo(id, title, content, false)

    list.add(0, toDoList)
    println("추가되었습니다!")
}

fun checkList() {
    if (list.isEmpty()) {
        println("할 일이 없습니다!")
    } else {
        for (toDo in list) {
            println("ID : ${toDo.id}\n제목 : ${toDo.title}\n내용 : ${toDo.context}\n완료여부 : ${toDo.isDone}")
        }
    }
}

fun complete() {
    println("완료할 To-Do List의 ID를 입력해주세요.")
    val id = readLine()

    val todoForComplete = list.find { it.id == id }

    if (todoForComplete != null) {
        todoForComplete.isDone = true
    } else {
        println("ID가 일치하는 할 일을 찾을 수 없습니다.")
    }

    println("완료되었습니다!")
}

fun delete() {
    println("삭제할 To-Do List의 ID를 입력해주세요.")
    val id = readLine()

    val todoForDelete = list.find { it.id == id }

    if (todoForDelete != null) {
        list.remove(todoForDelete)
    } else {
        println("ID가 일치하는 할 일을 찾을 수 없습니다.")
    }

    println("삭제되었습니다!")
}
