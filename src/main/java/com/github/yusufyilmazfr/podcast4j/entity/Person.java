package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

/**
 * People with an interest in episode.
 */
@Getter
@Setter
public class Person {
    /**
     * The internal PodcastIndex.org person ID.
     */
    private Integer id;
    /**
     * The name of the person.
     */
    private String name;
    /**
     * Used to identify what role the person serves on the show or episode.
     */
    private String role;
    /**
     * The group the person's role is in.
     */
    private String group;
    /**
     * The url to a relevant resource of information about the person, such as a homepage or third-party profile platform.
     */
    private URL href;
    /**
     * URL to a picture or avatar of the person.
     */
    private URL img;
}
