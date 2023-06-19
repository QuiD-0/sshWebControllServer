package com.quid.webSSHControll.ssh.usecase

import com.quid.webSSHControll.ssh.domain.command.Execute
import org.springframework.stereotype.Service

@FunctionalInterface
interface Command {
    fun execute(command: String)

    @Service
    class CommandUseCase : Command {
        private val exec = Execute.ExecuteCommand()

        override fun execute(command: String) =
                exec.command(command)
    }
}