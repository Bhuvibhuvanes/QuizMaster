package com.frenzo.course.modules;

import java.util.ArrayList;
import java.util.List;

import com.frenzo.course.module.learning.unit.LearningUnit;
import com.frenzo.entity.UserInfo;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "learning_modules")
public class LearningModule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany
    @JoinTable(
        name = "learning_module_units",
        joinColumns = @JoinColumn(name = "learning_module_id"),
        inverseJoinColumns = @JoinColumn(name = "learning_unit_id")
    )
    private List<LearningUnit> learningUnits = new ArrayList<>();

    private String name;

    private String description;
    @Column(name = "\"order\"")
    private int order;
//
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private UserInfo creator;
//
    private boolean checkPrerequisite;

    private boolean checkPrerequisitePasses;

    private String htmlData;

    private boolean active;

    private boolean isTrial;
}

