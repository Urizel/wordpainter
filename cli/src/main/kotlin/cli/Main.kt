@file:JvmName("Main")

package cli

import com.xenomachina.argparser.ArgParser
import core.*

fun main(vararg args: String) {
    val parsedArgs = ArgParser(args).parseInto(::AppArgs)

    val vkChatGrabber = VkChatGrabber(parsedArgs.userId, parsedArgs.accessToken)
    val answer = vkChatGrabber.getConversationMessages(parsedArgs.peerId)

    answer.forEach {
        println(it)
    }
}

private class AppArgs(parser: ArgParser) {
    val userId by parser.storing(
            "-u", "--uid",
            help = "user id") { toInt() }

    val accessToken by parser.storing(
            "-t", "--token",
            help = "access token")

    val peerId by parser.storing(
            "-p", "--peer_id",
            help = "Conversation peer id") { toInt() }
}
