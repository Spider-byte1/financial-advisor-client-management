package com.example.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "portfolio_security")
public class PortfolioSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioSecurityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal purchasePrice;

    public PortfolioSecurity() {}

    public PortfolioSecurity(Portfolio portfolio, Security security,
                             Integer quantity, LocalDate purchaseDate, BigDecimal purchasePrice) {
        this.portfolio = portfolio;
        this.security = security;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
    }

    public Long getPortfolioSecurityId() { return portfolioSecurityId; }

    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }

    public Security getSecurity() { return security; }
    public void setSecurity(Security security) { this.security = security; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }
}
