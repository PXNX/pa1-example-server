package nyx.pa1_example_server.data

import nyx.pa1_example_server.model.ArticleDetail
import nyx.pa1_example_server.model.ArticlePreview
import nyx.pa1_example_server.model.addDetail

object Repository {

    private val previews = emptyList<ArticlePreview>().toMutableList()
    private val details = emptyList<ArticleDetail>().toMutableList()

    init{
        generateDummyData()
    }

    @Suppress("LocalVariableName")
    fun generateDummyData() {
        val titles = listOf("Die Mauer ist gefallen!", "Happy Birthday!", "Deutschland ist Weltmeister!")
        val imagePaths = listOf(
            "https://bilder.t-online.de/b/82/65/70/98/id_82657098/tid_da/mauerfall-1989-jubelnde-menschen-auf-der-berliner-mauer-am-brandenburger-tor.jpg",
            "https://images4.alphacoders.com/699/699453.jpg",
            "https://www.wallpaperup.com/uploads/wallpapers/2014/07/14/394687/942eaea97468e179000f4f55f7ed79a6-700.jpg"
        )
        val timestamps = listOf(626_569_200_000, 975_193_200_000, 1_405_202_400_000)
        val text =
            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

        for (i in 0..15 step 3) {
            val _previews = emptyList<ArticlePreview>().toMutableList()
            val _details = emptyList<ArticleDetail>().toMutableList()

            for (j in 0..3) {
                val articlePreview = ArticlePreview(i + j, titles[i], imagePaths[i])

                _previews.add(articlePreview)
                _details.add(articlePreview.addDetail(timestamps[i], text))
            }
            previews.addAll(_previews)
            details.addAll(_details)
        }
    }


    fun getPreviews() = previews

    fun getDetails() = details
}