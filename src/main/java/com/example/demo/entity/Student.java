package com.example.demo.entity;


import com.example.demo.service.CalculationDtoJpaConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.SecondaryTable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@org.hibernate.annotations.Table(appliesTo = "student", fetch = FetchMode.SELECT)
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student {


    private Long versionNUmber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OFFER_ID", table = "student", nullable = false)
    private Version version;

    @Column(name = "student_name")
    private String studentName;

    @Getter
    @Setter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "OFFER_CALCULATION", joinColumns = @JoinColumn(name = "OFFER_VERSION_ID", nullable = false))
    @OrderColumn(name = "bookName",columnDefinition = "bookName")
    @Convert(converter = CalculationDtoJpaConverter.class)
    private Set<BookDto> bookDtos;


}
