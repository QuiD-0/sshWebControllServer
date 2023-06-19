package com.quid.webSSHControll.ssh.usecase

import com.quid.webSSHControll.ssh.domain.command.Execute
import com.quid.webSSHControll.ssh.domain.command.Find
import org.springframework.stereotype.Service

@FunctionalInterface
interface RunSh {
    fun file(path: String, file: String)

    @Service
    class RunShUseCase : RunSh {
        private val find = Find.FindCommand()
        private val exec = Execute.ExecuteCommand()

        override fun file(path: String, file: String) =
            takeIf { find.existFile(path, file) }
                ?.let { exec.file("cd $path; chmod +x $file; bash $file") }
                ?: throw Exception("File Not Found")
    }
}