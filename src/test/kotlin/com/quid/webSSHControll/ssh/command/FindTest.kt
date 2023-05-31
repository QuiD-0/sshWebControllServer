package com.quid.webSSHControll.ssh.command

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class FindTest {

    private val find: Find = Find.FindCommand()
    private val make: Make = Make.MakeCommand()
    private val delete: Delete = Delete.DeleteCommand()

    @BeforeEach
    fun setUp() {
        make.makeFile("/home/wodnd", "test.sh")
    }

    @AfterEach
    fun tearDown() {
        delete.deleteFile("/home/wodnd", "test.sh")
    }

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