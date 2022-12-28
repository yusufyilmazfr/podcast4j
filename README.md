<h1 align="center">
<img title="" src="./img/podcast4j.png" alt=" " data-align="center" width="514">
</h1>

<hr/>
<h4 align="center">
podcast4j is an open source full implemented Java client for <a href="https://podcastindex.org/" target="_blank">podcastindex.org</a>
</h4>

<p align="center">
    <a href="https://github.com/yusufyilmazfr/podcast4j/commits/main">
    <img src="https://img.shields.io/github/last-commit/yusufyilmazfr/podcast4j.svg?style=flat-square&logo=github&logoColor=white"
         alt="GitHub last commit">
    <a href="https://github.com/yusufyilmazfr/podcast4j/issues">
    <img src="https://img.shields.io/github/issues-raw/yusufyilmazfr/podcast4j.svg?style=flat-square&logo=github&logoColor=white"
         alt="GitHub issues">
    <a href="https://github.com/yusufyilmazfr/podcast4j/pulls">
    <img src="https://img.shields.io/github/issues-pr-raw/yusufyilmazfr/podcast4j.svg?style=flat-square&logo=github&logoColor=white"
         alt="GitHub pull requests">
    <a href="https://twitter.com/intent/tweet?text=try awesome podcast4j Java library for accessing podcastindex database. yusufyilmazfr/podcast4j:&url=https://github.com/yusufyilmazfr/podcast4j">
    <img src="https://img.shields.io/twitter/url/https/github.com/yusufyilmazfr/podcast4j?style=flat-square&logo=twitter"
         alt="GitHub tweet">
</p>

<p align="center">
    <a href="https://github.com/sponsors/yusufyilmazfr">
      <img src="https://img.shields.io/static/v1?label=Sponsor&message=%E2%9D%A4&logo=GitHub&color=%23fe8e86">
    </a>
</p>

<p align="center">
  <a href="#about">About</a> •
  <a href="#getting-started">Getting Started</a> •
  <a href="#usages">Usages</a> •
  <a href="#features">Features</a> •
  <a href="#support">Support</a> •
  <a href="#license">License</a>
</p>

## About

The PodcastIndex exists to preserve, protect and extend the open, independent podcasting ecosystem and podcast4j is an API client of podcastindex. You're able to interract with PodcastIndex through podcast4j.

## Getting Started

Before use podcast4j, we have to create an PodcastIndex account and generate secret and auth key on [podcastindex.org](https://podcastindex.org/). You are able to create an account on [podcastindex](https://api.podcastindex.org/)

After generating secret and auth key, you're able to create `Podcast4jServiceFactory` instance to accessing podcastindex API end-points. 

```java
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;

//..

Config config = Config.builder()
        .secret("<SECRET_KEY>")
        .authKey("<AUTH_KEY>")
        .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
```

There are several required fields such as `secret` and `authKey` but you're able to add another fields such as; `userAgent` and `timeOut` these fields are default values. It is up to developer who uses this client. If you want to use these fields, you can change these codes that are below.

```java
import com.github.yusufyilmazfr.podcast4j.config.Config;
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory;

//..

Config config = Config.builder()
        .secret("<SECRET_KEY>")
        .authKey("<AUTH_KEY>")
        .userAgent("SuperPodcastPlayer/1.8")
        .timeOut(10000)
        .build();

Podcast4jServiceFactory factory = Podcast4jServiceFactory.with(config);
```

<u>*We are using timeOut field in HTTP cals, default time out is 5 seconds.*</u>

## Usages

<p>This section is all about <b>podcast4j</b> client usages with provided services. 
Before getting started every service is generated from <code>Podcast4jServiceFactory</code>, so we have to create first <code>Podcast4jServiceFactory</code> then create another service that we need.<code>Podcast4jServiceFactory</code> provides us services. Example codes point this.</p>

### Search Service
<details>
  <summary><b>Search Podcasts: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jSearchService searchService = serviceFactory.getSearchService();

SearchPodcastsByTermArg arg = SearchPodcastsByTermArg.builder()
                                                     .q(CODEFICTION_PODCAST_TITLE) // CODEFICTION_PODCAST_TITLE = "Codefiction Podcast";
                                                     .build();

List<Podcast> podcasts = searchService.searchPodcastsByTerm(arg);
````
</details>

<details>
  <summary><b>Search Podcasts by Title: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jSearchService searchService = serviceFactory.getSearchService();

SearchPodcastsByTitleArg arg = SearchPodcastsByTitleArg.builder()
                                                       .q(CODEFICTION_PODCAST_TITLE) // CODEFICTION_PODCAST_TITLE = "Codefiction Podcast";
                                                       .similar(Boolean.TRUE)
                                                       .build();

List<Podcast> podcasts = searchService.searchPodcastsByTitle(arg);
````

</details>

### Podcast Service

<details>
  <summary><b>Get Podcast By Feed ID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

Podcast podcast = podcastService.getPodcastByFeedId(CODEFICTION_FEED_ID); // CODEFICTION_FEED_ID = 53723;
````
</details>


<details>
  <summary><b>Get Podcast By Feed URL: Click Here to See</b></summary>

```java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

Podcast podcast = podcastService.getPodcastByFeedURL(CODEFICTION_FEED_URL); // CODEFICTION_FEED_URL = "https://feeds.simplecast.com/3Ro7Vrg6";
```
</details>

<details>
  <summary><b>Get Podcast By GUID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

Podcast podcast = podcastService.getPodcastByGUID(CODEFICTION_GUID_ID); // CODEFICTION_GUID_ID = "d2e4c26d-0626-5d32-9634-987be192f841";
````
</details>

<details>
  <summary><b>Get Podcast By iTunes ID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

Podcast podcast = podcastService.getPodcastByiTunesID(CODEFICTION_iTUNES_ID); // CODEFICTION_iTUNES_ID = 1172391831L;
````
</details>

<details>
  <summary><b>Get Podcasts By Medium: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

List<Podcast> podcasts = podcastService.getPodcastsByMedium(MediumType.MUSIC);
````
</details>

<details>
  <summary><b>Get Trending Podcasts: Click Here to See</b></summary>

```java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

TrendPodcastsArg arg = TrendPodcastsArg.builder()
                                       .lang("en")
                                       .cat("News")
                                       .notCat("Entertainment")
                                       .max(5)
                                       .build();

List<TrendPodcast> trendPodcasts = podcastService.getTrendPodcasts(arg);
```
</details>

<details>
  <summary><b>Get Dead Podcasts: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jPodcastService podcastService = serviceFactory.getPodcastService();

List<DeadPodcast> deadPodcasts = podcastService.getDeadPodcasts();
````
</details>

### Episode Service


<details>
  <summary><b>Get Episodes By Feed ID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

ByFeedIdArg arg = ByFeedIdArg.builder()
                             .id(CODEFICTION_FEED_ID) // CODEFICTION_FEED_ID = 53723;
                             .max(10)
                             .build();

List<Episode> episodes = episodeService.getEpisodesByFeedId(arg);
````
</details>

<details>
  <summary><b>Get Episodes By Feed URL: Click Here to See</b></summary>
 
```java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

ByFeedURLArg arg = ByFeedURLArg.builder()
                               .url(CODEFICTION_FEED_URL) // CODEFICTION_FEED_URL = "https://feeds.simplecast.com/3Ro7Vrg6";
                               .max(10)
                               .build();

List<Episode> episodes = episodeService.getEpisodesByFeedURL(arg);
```
</details>

<details>
  <summary><b>Get Episode By GUID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

ByGUIDArg arg = ByGUIDArg.builder()
                         .guid("PC2084")
                         .feedId(920666)
                         .build();

Episode episode = episodeService.getEpisodeByGUID(arg);
````
</details>

<details>
  <summary><b>Get Episode By ID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

ByIdArg arg = ByIdArg.builder()
                     .id(CODEFICTION_EPISODE_ID) // CODEFICTION_EPISODE_ID = 2146512028L; // 513 - Fazla mesai yazılımcının kaderi mi?
                     .fulltext(Boolean.TRUE)
                     .build();

// Actual
Episode episode = episodeService.getEpisodeById(arg);
````
</details>

<details>
  <summary><b>Get Episodes By iTunes ID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

ByiTunesArg arg = ByiTunesArg.builder()
                             .id(CODEFICTION_iTUNES_ID) // CODEFICTION_iTUNES_ID = 1172391831L;
                             .max(10)
                             .build();

List<Episode> episodes = episodeService.getEpisodesByiTunesId(arg);
````
</details>

<details>
  <summary><b>Get Live Episodes: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

List<Episode> episodes = episodeService.getLiveEpisodes(5);
````
</details>

<details>
  <summary><b>Get Random Episodes: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jEpisodeService episodeService = serviceFactory.getEpisodeService();

RandomEpisodesArg arg = RandomEpisodesArg.builder()
                                         .lang("tr")
                                         .cat("Technology")
                                         .max(5)
                                         .build();

List<Episode> episodes = episodeService.getRandomEpisodes(arg);
````
</details>

### Category Service
<details>
  <summary><b>Get Categories: Click Here to See</b></summary>

```java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jCategoryService categoryService = serviceFactory.getCategoryService();

List<Category> categories = categoryService.getAll();
```
or you're able to use like fluent version. ✨🫶

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

List<Category> categories = Podcast4jServiceFactory.with(config)
                                                   .getCategoryService()
                                                   .getAll();

````
</details>

### Recent Service
### Apple Replacement Service

<details>
  <summary><b>Search on Apple iTunes: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jAppleReplacementService appleReplacementService  = serviceFactory.getAppleReplacementService();

List<AppleReplacementSearch> searches = appleReplacementService.search("batman");
````

</details>

<details>
  <summary><b>Lookup on Apple iTunes: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jAppleReplacementService appleReplacementService  = serviceFactory.getAppleReplacementService();

List<AppleReplacementSearch> searches = appleReplacementService.lookup(CODEFICTION_iTUNES_ID, null); // CODEFICTION_iTUNES_ID = 1172391831L;
````
</details>

### Value Service

<details>
  <summary><b>Get Value By Feed ID: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jValueService valueService = serviceFactory.getValueService();

Value value = valueService.getValueByFeedId(PODCAST_INDEX_FEED_ID_FOR_VALUE); // PODCAST_INDEX_FEED_ID_FOR_VALUE = 920666;
````
</details>

<details>
  <summary><b>Get Value By Feed URL: Click Here to See</b></summary>

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jValueService valueService = serviceFactory.getValueService();

Value value = valueService.getValueByFeedURL(PODCAST_INDEX_FEED_URL_FOR_VALUE); // PODCAST_INDEX_FEED_URL_FOR_VALUE = "https://mp3s.nashownotes.com/pc20rss.xml";
````
</details>

### Hub Service
<details>
  <summary><b>Notify Changes By FEED Id: Click Here to See</b></summary>

```java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jHubService hubService = serviceFactory.getHubService();

hubService.notifyByFeedId(CODEFICTION_FEED_ID); // CODEFICTION_FEED_ID = 53723;
```
</details>

<details>
  <summary><b>Notify Changes By FEED URL: Click Here to See</b></summary>

```java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jHubService hubService = serviceFactory.getHubService();

hubService.notifyByFeedURL(CODEFICTION_FEED_URL); // CODEFICTION_FEED_URL = "https://feeds.simplecast.com/3Ro7Vrg6";

```
</details>

### Stats Service
<details>
  <summary><b>Get PodcastIndex Stats: Click Here to See</b></summary>

```java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Podcast4jServiceFactory serviceFactory = Podcast4jServiceFactory.with(config);
Podcast4jStatsService statsService = serviceFactory.getStatsService();

Stats stats = statsService.get();
```

or you're able to use like fluent version. ✨🫶

````java
Config config = Config.builder()
                      .secret("<SECRET_KEY>")
                      .authKey("<AUTH_KEY>")
                      .build();

Stats stats = Podcast4jServiceFactory.with(config)
                                     .getStatsService()
                                     .get();
````


</details>

<hr />

## Features

|                            | 🔰 Status |                         | 🔰 Status |
|----------------------------|:---------:| ----------------------- | --------- |
| **Search**                 |           | **Recent**              |           |
| Search Podcasts            | ✔️        | Get Recent Episodes     | ✔️        |
| Search Podcasts by Title   | ✔️        | Get Recent Feeds        | ✔️        |
| Search Episodes by Person  | ⌛         | Get New Feeds           | ✔️        |
| Search Music Podcasts      | ⌛         | Get Soundbites          | ✔️        |
|                            |           |                         |           |
| **Podcast**                |           | **Episodes**            |           |
| Get Podcast By Feed ID     | ✔️        | Get Episodes By Feed ID | ✔️        |
| Get Podcast By Feed URL    | ✔️        | Get Episodes By Feed URL | ✔️        |
| Get Podcast By GUID        | ✔️        | Get Episode By GUID     | ✔️        |
| Get Podcasts By TAG        | ✔️        | Get Episode By ID       | ✔️        |
| Get Podcast By iTunes ID   | ✔️        | Get Episodes By iTunes ID | ✔️        |
| Get Podcasts By Medium     | ✔️        | Get Live Episodes       | ✔️        |
| Get Trending Podcasts      | ✔️        | Get Random Episodes     | ✔️        |
| Get Dead Podcasts          | ✔️        |                         |           |
|                            |           |                         |           |
| **Apple Replacement**      |           | **Value**               |           |
| Search on Apple iTunes     | ✔️        | Get Value By Feed ID    | ✔️        |
| Lookup on Apple iTunes     | ✔️        | Get Value By Feed URL   | ✔️        |
|                            |           |                         |           |
| **Stats**                  |           | **Category**            |           |
| Get Current Stats          | ✔️        | Get Categories          | ✔️        |
|                            |           |                         |           |
| **Hub**                    |           | **Add Service**         |          |
| Notify Changes By Feed Id  | ✔️        | ...                     | ⌛         |
| Notify Changes By Feed URL | ✔️        | ...                     | ⌛         |

## Support

Reach out to me via the [**GitHub**](https://github.com/yusufyilmazfr) or [**Twitter**](https://twitter.com/yusufyilmazfr)

## License

yusufyilmazfr/podcast4j is licensed under the MIT License.
