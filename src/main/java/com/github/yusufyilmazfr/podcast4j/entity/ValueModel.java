package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Description of the method for providing "Value for Value" payments
 */
@Getter
@Setter
public class ValueModel {
    /**
     * Payment type, allowed:
     * <ul>
     *     <li>lightning</li>
     *     <li>hive</li>
     *     <li>webmonetization</li>
     * </ul>
     */
    private String type;
    /**
     * Method for sending payment
     */
    private String method;
    /**
     * Suggested amount per second of playback to send. Unit is specific to the type.
     */
    private String suggested;
}
