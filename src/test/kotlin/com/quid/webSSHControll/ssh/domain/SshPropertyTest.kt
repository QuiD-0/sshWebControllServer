package com.quid.webSSHControll.ssh.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@Disabled
class SshPropertyTest{

    @Test
    fun getProperty(){
        val sshProperty = SshProperty()
        assertNotNull(sshProperty.get("ssh.user"))
    }
}