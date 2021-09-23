# pa1-example-server
Server-side for my 1st Projekt Arbeit, hence "pa1-example," serving different Json responses to show networking/caching of certain platform-neutral (or platform depending) technologies, delivering a baseline to benchmark against.

## Please note

Heroku will shut down the Server after 30mins of not being used to save dyno hours, thus costs.

Starting the server, which can be done via simply accessing Heroku's Url for it, takes some time.

This therefore has to be made prior to enable for fair testing and performance metrics.

---

## Dummy data
Dummy data is being generated once the server starts to reduce overhead following along to enable for proper testing further down the line.

|Route|Result|Example Response|
|---|---|---|
|```/```|Text showing the server is up|```Hello world!```|
|```/previews```|List of [ArticlePreview][1]|```[{"id":0,"title":"Tag der deutschen Einheit!","imageUrl":"https://www.wallpaperup.com/uploads/wallpapers/2014/01/08/219616/3f9e2ddec32a2f424a660857f4efba4a-1000.jpg"},{"id":1,"title":"Happy Birthday!","imageUrl":"https://www.wallpaperup.com/uploads/wallpapers/2014/02/28/281578/afc3df95e4124bdbe1b871b43a60e559-1000.jpg"},...]```|
|```/detail/{id}```|[ArticleDetail][2] with id being the index within the list of Articles; every 4th Article features a very recent date|```{"id":0,"title":"Tag der deutschen Einheit!","imageUrl":"https://www.wallpaperup.com/uploads/wallpapers/2014/01/08/219616/3f9e2ddec32a2f424a660857f4efba4a-1000.jpg","publishTimestamp":626569200000,"text":"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."}```

[1]: https://github.com/PXNX/pa1-example-server/blob/7d28198b9c59f9fce7824abb861be74e073e5aa2/src/main/kotlin/nyx/pa1_example_server/model/Article.kt#L6
[2]: https://github.com/PXNX/pa1-example-server/blob/7d28198b9c59f9fce7824abb861be74e073e5aa2/src/main/kotlin/nyx/pa1_example_server/model/Article.kt#L9



## Clients
|Github Repo|Description|Deployment or File|
|---|---|---|
|[pa1-example-native][3]|Native Android App using a Kotlin/Jetpack Compose||
|[pa1-example-pwa][4]|Progressive Web App using a React KotlinJS wrapper|https://pa1-pwa.herokuapp.com/|
|[pa1-example-crossplatform][5]|Crossplatform App using Flutter||

[3]: https://github.com/PXNX/pa1-example-native
[4]: https://github.com/PXNX/pa1-example-pwa
[5]: https://github.com/PXNX/pa1-example-crossplatform
