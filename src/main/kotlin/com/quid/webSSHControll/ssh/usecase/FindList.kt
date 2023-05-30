package com.quid.webSSHControll.ssh.usecase

import com.jcraft.jsch.ChannelExec
import com.quid.webSSHControll.ssh.SshConnector
import org.springframework.stereotype.Service

interface FindList {

    fun findFolderList(): List<String>
    fun makeDirectory(path : String): String

    @Service
    class FindListImpl: FindList {
        private val exec = SshConnector().connect().openChannel("exec") as ChannelExec

        override fun findFolderList(): List<String> {
            exec.apply {
                setCommand("ls")
                connect()
            }.let {
                return returnResult(it)
            }
        }

        override fun makeDirectory(path: String): String {
            exec.apply {
                setCommand("mkdir $path")
                connect()
            }.let {
                return returnResult(it).toString()
            }
        }

        fun returnResult(result: ChannelExec): List<String> {
            result.inputStream.bufferedReader().use { return it.lines().toList() }
        }
    }
}