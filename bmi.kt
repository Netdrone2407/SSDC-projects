import java.util.Scanner
fun main(args: Array<String>) {
    println("--------------------------------------------------------->BMI CALCULATOR<------------------------------------------------------------------------------")
    val reader = Scanner(System.`in`)
    println("Enter the height in metres ")
    var height: Float=reader.nextFloat() ;
    val reader1 = Scanner(System.`in`)
    println("Enter the weight in kg ")
    var weight:Float = reader1.nextFloat()
    var bmi:Float=(weight/(height*height))
    if(bmi>=25.00){
        println("your bmi is ${bmi}")
        println("You are overweight.")
    }
    else if(bmi<=18.00){
        println("your bmi is ${bmi}")
        println("You are underweight.")
    }
    else{
        println("your bmi is ${bmi}")
        println("Your are fit ,keep going.")
    }
       
}
