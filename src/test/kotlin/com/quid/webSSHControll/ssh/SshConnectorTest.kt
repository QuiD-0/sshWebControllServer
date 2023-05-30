package com.quid.webSSHControll.ssh

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class SshConnectorTest{

    @Test
    fun testConnect(){
        assertDoesNotThrow { SshConnector().connect() }
    }

    @Test
    fun testDisconnect(){
        assertDoesNotThrow{ SshConnector().connect().disconnect() }
    }
}