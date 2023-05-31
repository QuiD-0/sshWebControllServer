package com.quid.webSSHControll.ssh.usecase

import com.quid.webSSHControll.ssh.command.Execute
import com.quid.webSSHControll.ssh.command.Find
import org.springframework.stereotype.Service

interface RunSh {
    fun runSh(path: String, file: String)

    @Service
    class RunShUseCase : RunSh {
        private val find = Find.FindCommand()
        private val exce = Execute.ExecuteCommand()

        override fun runSh(path: String, file: String) {
            exce.execute(path, file)
        }
    }
}