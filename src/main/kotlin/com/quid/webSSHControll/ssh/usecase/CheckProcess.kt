package com.quid.webSSHControll.ssh.usecase

import com.quid.webSSHControll.ssh.domain.command.Find
import org.springframework.stereotype.Service

interface CheckProcess {

    fun checkJavaProcess(programName: String): Boolean
    fun checkProcess(programName: String): Boolean

    @Service
    class CheckProcessUseCase : CheckProcess {

        private val find: Find = Find.FindCommand()

        override fun checkJavaProcess(programName: String): Boolean = find.getJavaProcessPID(programName).isNotEmpty()
        override fun checkProcess(programName: String): Boolean = find.getProcessPID(programName).isNotEmpty()

    }

}