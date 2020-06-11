package com.dada


import kotlinx.coroutines.launch
import net.mamoe.mirai.console.plugins.PluginBase
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.event.subscribeGroupMessages
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.message.uploadAsImage
import java.awt.image.BufferedImage
import java.io.*
import java.util.*
import javax.imageio.ImageIO
import org.springframework.scheduling.annotation.Scheduled


object pcrgacha : PluginBase() {

    override fun onLoad() {
        super.onLoad()
    }

    override fun onEnable() {
        super.onEnable()

        logger.info("Plugin loaded!")

        subscribeGroupMessages {
            (contains("十连抽卡")){
                if (group.id != 736553951L) {
                    launch {
                        try {
                            SEND(subject, sender)
                        } catch (e: Exception) {
                            subject.sendMessage("error")
                        }
                    }
                }
            }
        }
    }

    suspend fun SEND(subject: Contact, sender: Member) {
        try {
            /*
            以下是从网络获取图片的语句
            //var image1: BufferedImage = get_url(1)
            //var image2: BufferedImage = get_url(6)
             */
            /*
            分成image1：5个图片和image2:5个图片来处理
             */
            var image1: BufferedImage = get_pic(1)
            var image2: BufferedImage = get_pic(6)
            for (i in (2..5)) {
                image1 = mergeImage(image1, get_pic(i), true)
            }
            for (i in (7..10)) {
                image2 = mergeImage(image2, get_pic(i), true)
            }
            val image_total = mergeImage(image1, image2, false)
            val image_stream = bufferedImageToInputStream(image_total)
            val id: Image = image_stream.uploadAsImage(subject)
            val at = At(sender)
            subject.sendMessage(at + id)
        } catch (e: Exception) {
            logger.info(e)
        }
    }
}