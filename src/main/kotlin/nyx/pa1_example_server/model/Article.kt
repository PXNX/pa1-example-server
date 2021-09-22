package nyx.pa1_example_server.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticlePreview(val id: Int, val title: String, val imageUrl: String)

@Serializable
data class ArticleDetail(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val publishTimestamp: Long,
    val text: String
)

fun ArticlePreview.addDetail(publishTimestamp: Long, text: String) =
    ArticleDetail(id, title, imageUrl, publishTimestamp, text)
