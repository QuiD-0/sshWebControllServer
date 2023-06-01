package com.quid.webSSHControll.ssh.usecase

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RunShTest{

    @Autowired
    private lateinit var runSh: RunSh

    @Test
    fun runSh() {
        assertDoesNotThrow {
            runSh.execute("/home/wodnd", "run.sh")
        }
    }

}