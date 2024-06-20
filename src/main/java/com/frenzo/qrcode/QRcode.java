//package com.frenzo.qrcode;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "qrcode")
//public class QRcode {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    @Column(name = "random_key", length = 128, nullable = true)
//    private String randomKey;
//
//    @Column(name = "short_key", length = 128, unique = true, nullable = true)
//    private String shortKey;
//
//    @Column(name = "image_path", nullable = true)
//    private String imagePath;
//
//    @Column(name = "used", nullable = false)
//    private Boolean used = false;
//
//    @Column(name = "active", nullable = false)
//    private Boolean active = false;
//
//    @ManyToOne
//    @JoinColumn(name = "handler_id", nullable = false)
//    private QRcodeHandler handler;
//}
