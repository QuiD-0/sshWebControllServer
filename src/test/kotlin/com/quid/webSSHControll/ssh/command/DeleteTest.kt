package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

class DeleteTest {
    private val delete: Delete = Delete.DeleteCommand()
    private val make: Make = Make.MakeCommand()

    @Test
    fun testDeleteDirectory() {
        make.makeDirectory("/home/wodnd", "test")
        assertDoesNotThrow { delete.deleteDirectory("/home/wodnd/test") }
    }

    @Test
    fun testDeleteFile() {
        make.makeFile("/home/wodnd", "test.txt")
        assertDoesNotThrow { delete.deleteFile("/home/wodnd", "test.txt") }
    }
}