package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.domain.command.Delete
import com.quid.webSSHControll.ssh.domain.command.Execute
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@Disabled
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
            execute.file("cd /home/wodnd; chmod +x run.sh; bash run.sh")
        }
    }
}