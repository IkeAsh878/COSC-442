//src/net/sf/freecol/common/model/Season.java
package net.sf.freecol.common.model;


public enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

  
    public Season next() {
        switch (this) {
            case SPRING:
                return SUMMER;
            case SUMMER:
                return AUTUMN;
            case AUTUMN:
                return WINTER;
            case WINTER:
            default:
                return SPRING;
        }
    }
}

