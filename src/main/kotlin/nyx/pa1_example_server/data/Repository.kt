package nyx.pa1_example_server.data

import nyx.pa1_example_server.model.ArticleDetail
import nyx.pa1_example_server.model.ArticlePreview
import nyx.pa1_example_server.model.addDetail

object Repository {

    private val previews = emptyList<ArticlePreview>().toMutableList()
    private val details = emptyList<ArticleDetail>().toMutableList()

    init {
        generateDummyData()
    }

    @Suppress("LocalVariableName")
    fun generateDummyData() {
        val titles =
            listOf("Die Mauer ist gefallen!", "Happy Birthday!", "Deutschland ist Weltmeister!", "Corona in 4k!")
        val imagePaths = listOf(
            "https://www.100.bmwi.de/BMWI100/Redaktion/DE/Bilder/Startseite/meilenstein-08-wiedervereinigung.jpg?__blob=normal&v=4&size=1920w",
            "https://wallpaperforu.com/wp-content/uploads/2020/08/food-wallpaper-20080219232413-scaled.jpg",
            "https://www.wallpaperup.com/uploads/wallpapers/2014/07/14/394687/942eaea97468e179000f4f55f7ed79a6-700.jpg",
            "https://c.files.bbci.co.uk/D505/production/_115033545_gettyimages-1226314512.jpg"
        )
        val timestamps =
            listOf(626_569_200_000, 975_193_200_000, 1_405_202_400_000, System.currentTimeMillis() - 300_000)
        val text =
            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

        for (i in 0..64 step 3) {
            val _previews = emptyList<ArticlePreview>().toMutableList()
            val _details = emptyList<ArticleDetail>().toMutableList()

            for (j in titles.indices) {
                val articlePreview = ArticlePreview(i + j, titles[j], imagePaths[j])

                _previews.add(articlePreview)
                _details.add(articlePreview.addDetail(timestamps[j], text))
            }
            previews.addAll(_previews)
            details.addAll(_details)
        }
    }


    fun getPreviews() = previews

    fun getDetails() = details
}