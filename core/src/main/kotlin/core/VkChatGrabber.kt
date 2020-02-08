package core

import com.vk.api.sdk.client.TransportClient
import com.vk.api.sdk.client.VkApiClient
import com.vk.api.sdk.client.actors.UserActor
import com.vk.api.sdk.httpclient.HttpTransportClient

class VkChatGrabber(
        userId: Int,
        accessToken: String
) {
    private val vk: VkApiClient
    private val actor: UserActor

    init {
        val transportClient: TransportClient = HttpTransportClient.getInstance()
        vk = VkApiClient(transportClient)
        actor = UserActor(userId, accessToken)
    }

    fun getConversationMessages(chatPeerId: Int): List<String> {

        val messages = arrayListOf<String>()
        do {
            // FIXME API is old as fuck - write own request and response parser
            val historyChunk = vk.messages().getHistory(actor)
                    .peerId(chatPeerId)
                    .count(MESSAGE_COUNT)
                    .offset(messages.size)
                    .execute()
            messages.addAll(historyChunk.items.map { it.text })
        } while (messages.size < historyChunk.count)

        return messages
    }

    companion object {
        private const val MESSAGE_COUNT = 200
    }
}
