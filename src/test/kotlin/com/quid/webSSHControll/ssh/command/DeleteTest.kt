package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeleteTest{
    private val delete: Delete = Delete.DeleteCommand()
    private val make: Make = Make.MakeCommand()

    @BeforeEach
    fun setUp(){
        make.makeDirectory("/home/wodnd", "test")
        make.makeFile("/home/wodnd/test", "test.txt")
    }

    @Test
    fun testDeleteDirectory(){
        assertDoesNotThrow { delete.deleteDirectory("/home/wodnd/test") }
    }

    @Test
    fun testDeleteFile(){
        assertDoesNotThrow { delete.deleteFile("/home/wodnd/test", "test.txt") }
        delete.deleteDirectory("/home/wodnd/test")
    }
}