package com.example.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="train_details" , uniqueConstraints=
@UniqueConstraint(columnNames={"train_number"})
)
public class TrainDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="train_number")
    private Long train_number;

    @Column(name="train_name")
    private String train_name;

    @Column(name="train_state")
    private String train_state;

    @Column(name="train_platform")
    private String train_platform;

    @Column(name="train_time")
    private String train_time;

    @Column(name="updated_at")
    private Timestamp updated_at;
}
