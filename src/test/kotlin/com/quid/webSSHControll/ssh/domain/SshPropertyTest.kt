package com.quid.webSSHControll.ssh.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SshPropertyTest{

    @Test
    fun getProperty(){
        val sshProperty = SshProperty()
        assertNotNull(sshProperty.get("ssh.user"))
    }
}