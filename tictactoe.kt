fun check(arr: Array<Array<Char>>, ch: Char): Boolean {
    var p = false
    if (arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2] && arr[0][0] == ch) {
        p = true
    }
    if (arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] && arr[2][2] == ch) {
        p = true
    }
    if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0] && arr[0][0] == ch) {
        p = true
    }
    if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2] && arr[1][0] == ch) {
        p = true
    }
    if (arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2] && arr[2][0] == ch) {
        p = true
    }
    if (arr[2][0] == arr[1][1] && arr[2][0] == arr[0][2] && arr[0][2] == ch) {
        p = true
    }
    if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] && arr[0][1] == ch) {
        p = true
    }
    if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] && arr[1][2] == ch) {
        p = true
    }
    return p
}

fun empty(arr: Array<Array<Char>>): Boolean {
    var p = true
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (arr[i][j] == '_') {
                p = false
                break
            }
        }
    }
    return p
}

fun main() {
    val arr = Array(3) { Array(3) { '_' } }
    val u = Array(3) { Array(3) { -1 } }
    var count = 1
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            u[i][j] = count
            print("$count ")
            count++
        }
        if (i == 1) {
            print("  ------>   ")
        } else {
            print("            ")
        }
        for (j in 0 until 3) {
            print("${arr[i][j]} ")
        }
        println()
    }

    while (!empty(arr) && !check(arr, 'O') && !check(arr, 'X')) {
        print("enter the number for 'O': ")
        val num = readLine()!!.toInt()
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (u[i][j] == num) {
                    arr[i][j] = 'O'
                    u[i][j] = 0
                }
            }
        }
        println()
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                print("${arr[i][j]} ")
            }
            println()
        }
        if (check(arr, 'O') || empty(arr)) {
            break
        } else {
            print("enter the number for 'X': ")
            val s = readLine()!!.toInt()
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    if (u[i][j] == s) {
                        arr[i][j] = 'X'
                        u[i][j] = 0
                    }
                }
            }
            println()
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    print("${arr[i][j]} ")
                }
                println()
            }
        }
        println()
    }
    when {
        check(arr, 'O') -> println("O is the winner ")
        check(arr, 'X') -> println("X is the winner ")
        else -> println("No one wins ")
    }
}
