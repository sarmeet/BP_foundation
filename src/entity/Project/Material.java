package entity.Project;

import entity.Base;
import org.mongodb.morphia.annotations.Reference;

import java.math.BigDecimal;

/**
 * Created by sarmeetsingh on 9/7/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class Material extends Base {
    @Reference
    private Project project; // The project this material belongs to.
    private String name; // 6' cmu
    private String type; // Cmu
    private Long contractMaterialAmount; // Total number e.g. 400 cu. Yard
    private String unit; // The unit of measure for the material. e.g. Blocks is numbers, Cement is Cubic yards
    private Long MaterialAmountAlreadyApplied; // The amount that was already applied in case the job is a job that
    // has been going on before the job was taken by current contractor.
    private BigDecimal price; // The total price of material
    private BigDecimal PriceOfOne; // the price of one unit of material
    private Long materialApplied; // The amount of material Bayport applied

    public Material() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getContractMaterialAmount() {
        return contractMaterialAmount;
    }

    public void setContractMaterialAmount(Long contractMaterialAmount) {
        this.contractMaterialAmount = contractMaterialAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getMaterialAmountAlreadyApplied() {
        return MaterialAmountAlreadyApplied;
    }

    public void setMaterialAmountAlreadyApplied(Long materialAmountAlreadyApplied) {
        MaterialAmountAlreadyApplied = materialAmountAlreadyApplied;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceOfOne() {
        return PriceOfOne;
    }

    public void setPriceOfOne(BigDecimal priceOfOne) {
        PriceOfOne = priceOfOne;
    }

    public Long getMaterialApplied() {
        return materialApplied;
    }

    public void setMaterialApplied(Long materialApplied) {
        this.materialApplied = materialApplied;
    }
}