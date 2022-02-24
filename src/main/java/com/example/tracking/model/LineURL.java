package com.example.tracking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "url")
public class LineURL {

    @OneToMany(mappedBy = "line") //поле, по которому связана таблица
    private List<Prefix> prefixList; //один line - многго префиксов

    @Id
    @JoinColumn(name = "line")
    private String line;

    @Column(name = "line_full_name")
    private String linefullname;

    @Column(name = "url")
    private String url;

    @Column(name = "post")
    private String urlendof;


}
