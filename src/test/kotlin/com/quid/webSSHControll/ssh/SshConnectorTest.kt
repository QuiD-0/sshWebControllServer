package com.quid.webSSHControll.ssh

import com.quid.webSSHControll.ssh.domain.SshConnector
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