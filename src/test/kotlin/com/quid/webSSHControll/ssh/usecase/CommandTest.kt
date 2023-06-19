package com.quid.webSSHControll.ssh.usecase

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CommandTest{

    @Autowired
    private lateinit var command: Command

    @Test
    fun dockerTest() {
        assertDoesNotThrow {
            command.execute("sudo docker ps")
        }
    }
}