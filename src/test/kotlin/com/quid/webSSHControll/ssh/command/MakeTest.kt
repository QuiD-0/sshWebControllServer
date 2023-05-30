package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.assertDoesNotThrow

class MakeTest{

    private val make: Make = Make.MakeCommand()

    @org.junit.jupiter.api.Test
    fun testMakeDirectory(){
        assertDoesNotThrow { make.makeDirectory("/home/wodnd", "test") }
    }
}