package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

class ExecuteTest {

    private val execute: Execute = Execute.ExecuteCommand()
    private val delete: Delete = Delete.DeleteCommand()

    @AfterEach
    fun tearDown() {
        delete.deleteFile("/home/wodnd", "test.sh")
    }

    @Test
    fun execute() {
        assertDoesNotThrow {
            execute.execute("/home/wodnd", "test.sh")
        }
    }
}