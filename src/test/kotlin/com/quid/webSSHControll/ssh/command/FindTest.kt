package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.domain.command.Delete
import com.quid.webSSHControll.ssh.domain.command.Find
import com.quid.webSSHControll.ssh.domain.command.Make
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@Disabled
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

    @Test
    fun existFile() {
        assertEquals(true, find.existFile("/home/wodnd", "test.sh"))
    }

    @Test
    fun notExistFile() {
        assertEquals(false, find.existFile("/home/wodnd", "test1.sh"))
    }
}