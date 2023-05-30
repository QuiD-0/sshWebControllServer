package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class FindListTest {

    private val findList: Find = Find.FindCommand()

    @Test
    fun findFolderList() {
        assertDoesNotThrow {
            findList.findFolderList("/home/wodnd")
        }
    }

}