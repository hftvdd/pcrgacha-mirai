package com.dada

import org.jsoup.Jsoup
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import javax.imageio.ImageIO

fun bufferedImageToInputStream(image: BufferedImage): InputStream {
    val os = ByteArrayOutputStream()
    ImageIO.write(image, "png", os)
    return ByteArrayInputStream(os.toByteArray())
}

fun mergeImage(img1: BufferedImage, img2: BufferedImage, isHorizontal: Boolean): BufferedImage {
    val w1 = img1.width
    val h1 = img1.height
    val w2 = img2.width
    val h2 = img2.height
    var ImageArrayOne = IntArray(w1 * h1)
    ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1) // 逐行扫描图像中各个像素的RGB到数组中

    var ImageArrayTwo = IntArray(w2 * h2)
    ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2)
    val DestImage: BufferedImage
    if (isHorizontal) { // 水平方向合并
        DestImage = BufferedImage(w1 + w2, h1, BufferedImage.TYPE_INT_RGB)
        DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1) // 设置上半部分或左半部分的RGB
        DestImage.setRGB(w1, 0, w2, h2, ImageArrayTwo, 0, w2)
    } else { // 垂直方向合并
        DestImage = BufferedImage(w1, h1 + h2, BufferedImage.TYPE_INT_RGB)
        DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1) // 设置上半部分或左半部分的RGB
        DestImage.setRGB(0, h1, w2, h2, ImageArrayTwo, 0, w2) // 设置下半部分的RGB
    }

    return DestImage
}

fun get_pic(i: Int): BufferedImage {
    val f1 = File("plugins\\pcrgacha\\1\\").list()
    val f2 = File("plugins\\pcrgacha\\2\\").list()
    val f3 = File("plugins\\pcrgacha\\3\\").list()
    val n = (1..10000).random()
    val img: BufferedImage
    img = if (i == 10) {
        ImageIO.read(File("plugins\\pcrgacha\\2\\" + f2.random()))
    } else if (n > 250 && n <= 8200) {
        ImageIO.read(File("plugins\\pcrgacha\\1\\" + f1.random()))
    } else if (n <= 250) {
        ImageIO.read(File("plugins\\pcrgacha\\3\\" + f3.random()))
    } else {
        ImageIO.read(File("plugins\\pcrgacha\\2\\" + f2.random()))
    }
    return img
}

/*
    以上是从本地获取图片
    以下是从网络获取图片
 */
public var Char1 = listOf<String>(
    "https://patchwiki.biligame.com/images/pcr/c/cd/mpjpf8q3fczqdn5stzx5epe7a1whb1n.png  ",
    "https://patchwiki.biligame.com/images/pcr/0/04/lo60ot9xodirhcikbgsp5ys5j1semxf.png  ",
    "https://patchwiki.biligame.com/images/pcr/6/69/1295ipvt0ha6zly43nr690rj7qsl4py.png  ",
    "https://patchwiki.biligame.com/images/pcr/2/28/dwctebo5xojfp84t1dl8rzwf5semv7n.png  ",
    "https://patchwiki.biligame.com/images/pcr/c/cc/gwnmpp3h76m69ewd0oqnl22gtmt6hje.png  ",
    "https://patchwiki.biligame.com/images/pcr/6/62/h81lrn1gzun78rl6l0354xauni9yqs0.png  ",
    "https://patchwiki.biligame.com/images/pcr/0/0f/nwn0d9rx7uo8zxbhxcrrx1s3v4ugkfc.png  ",
    "https://patchwiki.biligame.com/images/pcr/1/1d/biyc1gryppcb7c5tzdvqti6bmcyd55w.png  ",
    "https://patchwiki.biligame.com/images/pcr/3/33/gcfzk5nghr9krp81u4x59jsbpph41qr.png  ",
    "https://patchwiki.biligame.com/images/pcr/3/37/264hu9xzlhbahpe8tzexwysq3g13x3n.png  "
)

public var Char2 = listOf<String>(
    "https://patchwiki.biligame.com/images/pcr/1/14/8pn703o0duodmiyou1c565wjczj5b5o.png",
    "https://patchwiki.biligame.com/images/pcr/6/62/nu4e4h9eopdciqg2va9hf4c8fqjzq3q.png",
    "https://patchwiki.biligame.com/images/pcr/c/c3/f8eexvpqyqkccbjad1uucs9z9whwnuy.png",
    "https://patchwiki.biligame.com/images/pcr/e/e5/6d00c5yutzbikc8vnta72rjzppu5wvj.png",
    "https://patchwiki.biligame.com/images/pcr/5/59/516euuhwnsfoqvolt8usv5z1jq0kfov.png",
    "https://patchwiki.biligame.com/images/pcr/4/41/fwg0kohgsjgf76yxk3t7uleary1rho4.png",
    "https://patchwiki.biligame.com/images/pcr/4/49/md183zh8ewq7lupcmo9smuymjw749cm.png",
    "https://patchwiki.biligame.com/images/pcr/e/e1/bh7jkgsmitpvxulkc6mc217pzge6jzx.png",
    "https://patchwiki.biligame.com/images/pcr/2/2e/o6c9lsjthg36mzdt7cysolok3cv3pvm.png",
    "https://patchwiki.biligame.com/images/pcr/0/05/exnyc4y1iuhrbjg3gxe7fncrj2mevmh.png",
    "https://patchwiki.biligame.com/images/pcr/d/db/egxfjidgjrjc8uatgi30dhvwzb3hkwn.png",
    "https://patchwiki.biligame.com/images/pcr/b/b5/672mvpqoxo64iv5t5dkr6vs31ko148k.png",
    "https://patchwiki.biligame.com/images/pcr/3/39/dvomjvmcbbyliifd5hvb97mmqwtocjf.png",
    "https://patchwiki.biligame.com/images/pcr/c/ce/fbvjbat2po9fy580a3jyj0z2q4tmf2l.png",
    "https://patchwiki.biligame.com/images/pcr/e/ed/mez3hg9iq9s5h6gor8ih6om9n9ln2za.png",
    "https://patchwiki.biligame.com/images/pcr/0/02/al8yiod9vehdtaov9pgs41uovntnkr2.png"
)

public var Char3 = listOf<String>(
    "https://patchwiki.biligame.com/images/pcr/7/72/edy145bksvw972yhfpfgp8qbquhsi1j.png ",
    "https://patchwiki.biligame.com/images/pcr/7/72/jb3637kcjwh7z9559n3ca377tkldr0t.png ",
    "https://patchwiki.biligame.com/images/pcr/a/a5/jsara36yjh1e8kj1srxtkztghdhmljd.png ",
    "https://patchwiki.biligame.com/images/pcr/b/ba/e1q3ot9mhbtqh7nsgpnc5bp39idld6s.png ",
    "https://patchwiki.biligame.com/images/pcr/8/82/a1pquxl61ls6ahhinzptb63tvadus03.png ",
    "https://patchwiki.biligame.com/images/pcr/8/8c/dy0rtln3fvhxkkqfxsnbnws61k8qqjh.png ",
    "https://patchwiki.biligame.com/images/pcr/e/e3/ccy9fdczpyc94sfm20q7uucw6g0vm5j.png ",
    "https://patchwiki.biligame.com/images/pcr/9/91/4h2e4w8p876oxtcu1xv2e9anb16od6s.png ",
    "https://patchwiki.biligame.com/images/pcr/a/a9/hj9uxkawbpguzfrpkrr6ymjwff6vmym.png ",
    "https://patchwiki.biligame.com/images/pcr/2/27/ergoy0815kqjqqpqn3sa0yuz2be4pco.png ",
    "https://patchwiki.biligame.com/images/pcr/9/98/4qostpj00cvuozwjjl2po690k9iu994.png ",
    "https://patchwiki.biligame.com/images/pcr/0/00/0koylmjvym7s63y8xmz9skaa1xfuo0t.png ",
    "https://patchwiki.biligame.com/images/pcr/0/03/smxy5tsyd5t92fqk5onwy56hlvbobb1.png ",
    "https://patchwiki.biligame.com/images/pcr/7/7f/j62dyqwinraqa1jhcey51t2xgpl3kkq.png ",
    "https://patchwiki.biligame.com/images/pcr/7/7c/9mlr4cmt1yol6qam0k5eetgqpoy9wao.png "
)

fun get(url: String): BufferedImage {
    val stream = Jsoup.connect(url).ignoreContentType(true).execute().bodyStream()
    val temp_image = ImageIO.read(stream)
    return temp_image
}


fun get_url(i: Int): BufferedImage {
    val n = (1..10000).random()
    val url: String
    url = if (i == 10) {
        Char2.random()
    } else if (n <= 250) {
        Char3.random()
    } else if (n > 250 && n <= 8200) {
        Char1.random()
    } else {
        Char2.random()
    }
    return get(url)
}

