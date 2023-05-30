package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExecuteTest{

        private val execute: Execute = Execute.ExecuteCommand()

        @Test
        fun execute() {
            assertDoesNotThrow {
                execute.execute("/home/wodnd", "test.sh")
            }
        }
}