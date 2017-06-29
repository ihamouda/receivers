package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by ihamouda on 2017-06-28.
 */
public class SpecialInstruction {
    @JacksonXmlProperty(localName = "instruction")
    private String instruction;

    public SpecialInstruction(String instruction) {
        this.instruction = instruction;
    }

    public SpecialInstruction() {
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
