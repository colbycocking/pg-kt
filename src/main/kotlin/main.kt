package io.github.lcorg.pgjava

import java.sql.DriverManager

object App {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "colbycocking", "colbycocking")
        val stmt = c.createStatement()
        val resultSet = stmt.executeQuery("select * from person")
        while (resultSet.next()) {
            print(resultSet.getString(1) + " ")

            println(resultSet.getString(2))
        }
        val pstmt = c.prepareStatement("select * from person")
    }
}