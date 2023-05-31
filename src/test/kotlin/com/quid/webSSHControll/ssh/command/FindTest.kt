package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class FindTest {

    private val find: Find = Find.FindCommand()

    @Test
    fun findFolderList() {
        assertDoesNotThrow {
            find.findFolderList("/home/wodnd")
        }
    }


    @Test
    fun getProcess() {
        assertDoesNotThrow {
            find.getJavaProcessPID("gesgwad")
        }
    }

}