# pa1-example-server
Server-side for my 1st Projekt Arbeit @ DHBW Ravensburg, hence the name of this Repo, serving different Json responses to show networking/caching of certain platform-neutral (or platform depending) technologies, delivering a baseline to benchmark against. This simulates a fairly simple but somewhat realistic use case.

Written entirely in Kotlin - uses Ktor (with CIO as Engine) ❤️ 

## Please note

Heroku will shut down the Server after 30mins of not being used to save dyno hours, thus costs. Therefore the following has to be made prior to enable for fair testing and performance metrics - and make the clients actually useable.

Start the server by simply accessing [Heroku's Url][deploymentUrl] for it. This may take around 30 seconds and should respond with ```Hello World!``` once done.

---

## Dummy data
Dummy data is being generated once the server starts to reduce overhead following along to enable for proper testing further down the line.

|Route|Result|Example Response|
|---|---|---|
|```/```|Text showing the server is up|```Hello world!```|
|```/previews```|List of [ArticlePreview][articlePreview]|```[{"id":0,"title":"Tag der deutschen Einheit!","imageUrl":"https://www.wallpaperup.com/uploads/wallpapers/2014/01/08/219616/3f9e2ddec32a2f424a660857f4efba4a-1000.jpg"},{"id":1,"title":"Happy Birthday!","imageUrl":"https://www.wallpaperup.com/uploads/wallpapers/2014/02/28/281578/afc3df95e4124bdbe1b871b43a60e559-1000.jpg"},...]```|
|```/detail/{id}```|[ArticleDetail][articleDetail] with id being the index within the list of Articles; every 4th Article features a very recent date|```{"id":0,"title":"Tag der deutschen Einheit!","imageUrl":"https://www.wallpaperup.com/uploads/wallpapers/2014/01/08/219616/3f9e2ddec32a2f424a660857f4efba4a-1000.jpg","publishTimestamp":626569200000,"text":"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."}```

## Clients
|Github Repo|Description|Deployment or File|
|---|---|---|
|[pa1-example-native][nativeRepo]|Native Android App using a Kotlin/Jetpack Compose||
|[pa1-example-pwa][pwaRepo]|Progressive Web App using a React KotlinJS wrapper|https://pa1-pwa.herokuapp.com/|
|[pa1-example-crossplatform][flutterRepo]|Crossplatform App using Flutter||

## Deployment

This repository is configured to be easily deployed on [Heroku][heroku]. You have to link your GitHub Account to a Heroku Application and then select the Repo you want to deploy.

If you want to run it locally, simply change the Port specified in [Application.kt][replacePort]. You might also have to add a host (e.g. "localhost") as parameter.

[deploymentUrl]: https://pa1-server.herokuapp.com/
[nativeRepo]: https://github.com/PXNX/pa1-example-native
[pwaRepo]: https://github.com/PXNX/pa1-example-pwa
[flutterRepo]: https://github.com/PXNX/pa1-example-crossplatform
[articlePreview]: https://github.com/PXNX/pa1-example-server/blob/7d28198b9c59f9fce7824abb861be74e073e5aa2/src/main/kotlin/nyx/pa1_example_server/model/Article.kt#L6
[articleDetail]: https://github.com/PXNX/pa1-example-server/blob/7d28198b9c59f9fce7824abb861be74e073e5aa2/src/main/kotlin/nyx/pa1_example_server/model/Article.kt#L9
[heroku]: https://heroku.com
[replacePort]: https://github.com/PXNX/pa1-example-server/blob/2a60184a473f6dc0081042cc9414ff2fa9304cec/src/main/kotlin/nyx/pa1_example_server/Application.kt#L12
