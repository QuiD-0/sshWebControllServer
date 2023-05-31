package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.Assertions.assertEquals
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
    fun processGrep() {
        assertDoesNotThrow {
            find.processGrep("SNAPSHOT")
                .onEach { println(it) }
        }
    }

    @Test
    fun checkProcessWhenExist() {
        assertEquals(true, find.checkProcess("java"))
    }

    @Test
    fun checkProcessWhenNotExist() {
        assertEquals(false, find.checkProcess("notFoundProgram"))
    }
}