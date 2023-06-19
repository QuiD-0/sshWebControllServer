package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.domain.command.Delete
import com.quid.webSSHControll.ssh.domain.command.Make
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

@Disabled
class MakeTest {

    private val make: Make = Make.MakeCommand()
    private val delete: Delete = Delete.DeleteCommand()

    @AfterEach
    fun tearDown() {
        delete.deleteDirectory("/home/wodnd/test")
    }

    @Test
    fun makeDirectory() {
        assertDoesNotThrow { make.makeDirectory("/home/wodnd", "test") }
    }

    @Test
    fun makeFile() {
        make.makeDirectory("/home/wodnd", "test")
        assertDoesNotThrow { make.makeFile("/home/wodnd/test", "test.txt") }
    }
}