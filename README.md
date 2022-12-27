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

<hr/>

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



## Features



|                            | 🔰 Status |                           | 🔰 Status |
| -------------------------- |:---------:| ------------------------- | --------- |
| **Search**                 |           | **Recent**                |           |
| Search Podcasts            | ✔️        | Get Recent Episodes       | ✔️        |
| Search Podcasts by Title   | ✔️        | Get Recent Feeds          | ✔️        |
| Search Episodes by Person  | ⌛         | Get New Feeds             | ✔️        |
| Search Music Podcasts      | ⌛         | Get Soundbites            | ✔️        |
|                            |           |                           |           |
| **Podcast**                |           | **Episodes**              |           |
| Get Podcast By Feed ID     | ✔️        | Get Episodes By Feed ID   | ✔️        |
| Get Podcast By Feed URL    | ✔️        | Get Episodes By Feed URL  | ✔️        |
| Get Podcast By GUID        | ✔️        | Get Episodes By GUID      | ✔️        |
| Get Podcasts By TAG        | ✔️        | Get Episode By ID         | ✔️        |
| Get Podcast By iTunes ID   | ✔️        | Get Episodes By iTunes ID | ✔️        |
| Get Podcast By Medium      | ✔️        | Get Live Episodes         | ✔️        |
| Get Trending Podcasts      | ✔️        | Get Random Episodes       | ✔️        |
| Get Dead Podcasts          | ✔️        |                           |           |
|                            |           |                           |           |
| **Apple Replacement**      |           | **Value**                 |           |
| Search on Apple iTunes     | ✔️        | Get Values By Feed ID     | ✔️        |
| Lookup on Apple iTunes     | ✔️        | Get Values By Feed URL    | ✔️        |
|                            |           |                           |           |
| **Stats**                  |           | **Category**              |           |
| Get Current Stats          | ✔️        | Get Categories            | ✔️        |
|                            |           |                           |           |
| **Hub**                    |           | **Add Service**           | ⌛         |
| Notify Changes By Feed Id  | ✔️        | ...                       | ⌛         |
| Notify Changes By Feed URL | ✔️        | ...                       | ⌛         |

## Support

Reach out to me via the [**Github**](https://github.com/yusufyilmazfr) or [**Twitter**](https://twitter.com/yusufyilmazfr)

## License

yusufyilmazfr/podcast4j is licensed under the MIT License.