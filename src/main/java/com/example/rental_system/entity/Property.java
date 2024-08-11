package com.example.rental_system.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    @Column(nullable = false)
    private Long landlordId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(nullable = false, length = 20)
    private String zipCode;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(nullable = false, length = 50)
    private String propertyType;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlordId", referencedColumnName = "userId", insertable = false, updatable = false)
    private User landlord;

    // Constructors
    public Property() {
    }

    public Property(Long landlordId, String title, String description, String address, String city, String state, String zipCode, String country, BigDecimal pricePerNight, String propertyType) {
        this.landlordId = landlordId;
        this.title = title;
        this.description = description;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.pricePerNight = pricePerNight;
        this.propertyType = propertyType;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Long landlordId) {
        this.landlordId = landlordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId);
    }

    // toString method
    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", landlordId=" + landlordId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", propertyType='" + propertyType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}