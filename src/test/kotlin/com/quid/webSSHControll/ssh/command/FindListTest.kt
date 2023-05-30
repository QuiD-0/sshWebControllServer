package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun processGrep() {
        assertDoesNotThrow {
            findList.processGrep("SNAPSHOT")
                .onEach { println(it) }
        }
    }

    @Test
    fun checkProcessWhenExist() {
        assertEquals(true, findList.checkProcess("java"))
    }

    @Test
    fun checkProcessWhenNotExist() {
        assertEquals(false, findList.checkProcess("notFoundProgram"))
    }
}