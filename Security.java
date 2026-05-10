package com.example.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private SecurityCategory securityCategory;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PortfolioSecurity> portfolioSecurities;

    public Security() {}

    public Security(String name, SecurityCategory securityCategory,
                    LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isActive) {
        this.name = name;
        this.securityCategory = securityCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }

    public Long getSecurityId() { return securityId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SecurityCategory getSecurityCategory() { return securityCategory; }
    public void setSecurityCategory(SecurityCategory securityCategory) {
        this.securityCategory = securityCategory;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public List<PortfolioSecurity> getPortfolioSecurities() { return portfolioSecurities; }
    public void setPortfolioSecurities(List<PortfolioSecurity> portfolioSecurities) {
        this.portfolioSecurities = portfolioSecurities;
    }
}
