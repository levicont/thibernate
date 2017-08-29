@org.hibernate.annotations.GenericGenerator(
        name = "ID_GENERATOR",
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence-name",
                        value = "JPWH_SEQUENCE"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "initial-value",
                        value = "1000"
                )
        }
)
package com.lvg.thibernate.ce.models;