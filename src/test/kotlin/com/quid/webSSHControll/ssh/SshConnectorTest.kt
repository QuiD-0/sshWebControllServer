package com.quid.webSSHControll.ssh

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class SshConnectorTest{

    @Test
    fun getExec() {
        assertDoesNotThrow {
            SshConnector().exec()
        }
    }

    @Test
    fun getSftp() {
        assertDoesNotThrow {
            SshConnector().sftp()
        }
    }
}