package com.github.yusufyilmazfr.podcast4j.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Destination where "Value for Value" payments should be sent.
 */
@Getter
@Setter
public class ValueDestination {
    /**
     * Name for the destination
     */
    private String name;
    /**
     * Address of node to receive payment
     */
    private String address;
    /**
     * Allowed: node
     * Type of destination
     */
    private String type;
    /**
     * Share of payment the destination should receive
     */
    private Integer split;
    /**
     * Indicates if destination is included due to a fee being charged
     */
    private Boolean fee;
    /**
     * The name of a custom record key to send along with the payment.
     */
    private String customKey;
    /**
     * A custom value to pass along with the payment. This is considered the value that belongs to the customKey.
     */
    private String customValue;

}
